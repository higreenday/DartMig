package com.firstinfo.dart.job.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocBodyEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocContentEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocInstEntity;
import com.firstinfo.dart.entity.DartTbPaDartMasterEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocSectionEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocBodyRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocContentRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocInstRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocSectionRepository;

@Service
public class DartTbPaDartBody {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger("chk_xml");

    // db
    @Autowired
    DartTbPaDartDocBodyRepository dartTbPaDartDocBodyRepository;
    
    @Autowired
    DartTbPaDartDocInstRepository dartTbPaDartInstRepository;
    
    @Autowired
    DartTbPaDartDocContentRepository dartTbPaDartDocContentRepository;
    
    @Autowired
    DartTbPaDartDocSectionRepository dartTbPaDartSectionRepository;

    // xml 
    @Autowired
    DartTbPaDartCorrection dartTbPaDartCorrection;
    
    @Autowired
    DartTbPaDartCover dartTbPaDartCover;
    
    @Autowired
    DartTbPaDartToc dartTbPaDartToc;
    
    @Autowired
    DartTbPaDartInsertion dartTbPaDartInsertion;
    
    @Autowired
    DartTbPaDartPart dartTbPaDartPart;
    
    @Autowired
    DartTbPaDartSection dartTbPaDartSection;
    
    @Autowired
    DartTbPaDartInsertionLibrary dartTbPaDartInsertionLibrary;

    // 체크용 저장 경로
    @Value("${com.first.dart.path.chk_path}")
    private String dartChkPath;

    @Value("${com.first.dart.prod}")
    private String isProdYn;

    private void chkElem(Document xdoc, String xpath, String path, boolean existsChk, boolean multipleChk) {
        if (isProdYn.equals("N")) {
            try {
                if (existsChk && XMLUtil.isExistsElement(xpath, xdoc)) {
                    File srcFile = new File(path);
                    File targetFile = new File(dartChkPath + srcFile.getName());
                    if (targetFile.exists() == false) {
                        FileUtils.copyDirectory(srcFile, targetFile);
                    }
                    log.info(xpath + " EXISTS :" + srcFile.getName());
                }
                if (multipleChk && XMLUtil.isExistsElement(xpath, xdoc) && XMLUtil.getMultiElements(xpath, xdoc).size() > 1) {
                    File srcFile = new File(path); 
                    File targetFile = new File(dartChkPath + srcFile.getName());
                    if (targetFile.exists() == false) {
                        FileUtils.copyDirectory(srcFile, targetFile);
                    }
                    log.info(xpath + " MULTIPLE EXISTS :" + XMLUtil.getMultiElements(xpath, xdoc).size() + ":" + srcFile.getName());
                }
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }
    }
 
    public void xmlToDb(Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {
        DartTbPaDartDocBodyEntity docBodyEnt = new DartTbPaDartDocBodyEntity();
        DartTbPaDartDocInstEntity instEnt = new DartTbPaDartDocInstEntity();
        DartTbPaDartDocSectionEntity sec1Ent = new DartTbPaDartDocSectionEntity();
        DartTbPaDartDocContentEntity sec1ContEnt = new DartTbPaDartDocContentEntity(); 
        
        docBodyEnt.setJurirno(docEnt.getJurirno());
        docBodyEnt.setDataSeCode(docEnt.getDataSeCode());
        docBodyEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
        docBodyEnt.setAtchFileSn(docEnt.getAtchFileSn());

        chkElem(xdoc, "//BODY/TOC", dartEntity.getDirPath(), false, true); 
        chkElem(xdoc, "//BODY/COVER", dartEntity.getDirPath(), false, true); 
        chkElem(xdoc, "//BODY/CORRECTION", dartEntity.getDirPath(), true, true); 
        chkElem(xdoc, "//BODY/SUBTITLE", dartEntity.getDirPath(), true, true); 
        chkElem(xdoc, "//BODY/CAUTION", dartEntity.getDirPath(), true, true); 
        chkElem(xdoc, "//BODY/WARNING", dartEntity.getDirPath(), true, true); 
        chkElem(xdoc, "//BODY/PART", dartEntity.getDirPath(), true, true); 
        chkElem(xdoc, "//BODY/P", dartEntity.getDirPath(), true, true); 
        chkElem(xdoc, "//BODY/TABLE-GROUP", dartEntity.getDirPath(), true, true); 
        chkElem(xdoc, "//BODY/TITLE", dartEntity.getDirPath(), true, true); 
        chkElem(xdoc, "//BODY/APPENDIX", dartEntity.getDirPath(), true, true); 
        chkElem(xdoc, "//BODY/LIBRARY", dartEntity.getDirPath(), true, true); 

        if (XMLUtil.isExistsElement("//BODY/COVER", xdoc)) {
            int coverContSn = dartTbPaDartCover.xmlToDb(XMLUtil.getSingleElement("//BODY/COVER", xdoc), xdoc, dartEntity, histEnt, docEnt);
            docBodyEnt.setCoverContentSn(coverContSn);            
        }

        if (XMLUtil.isExistsElement("//BODY/TOC", xdoc)) {
            int tocContSn = dartTbPaDartToc.xmlToDb(XMLUtil.getSingleElement("//BODY/TOC", xdoc), xdoc, dartEntity, histEnt, docEnt);
            docBodyEnt.setTocContentSn(tocContSn);        
        }
        
        // content 저장 
        String xmlStr = XMLUtil.getContentsFromElem(XMLUtil.getSingleElement("//BODY",xdoc), "TITLE");
        if (xmlStr.trim().isEmpty() == false) {
            DartTbPaDartDocContentEntity contEnt = new DartTbPaDartDocContentEntity();   

            contEnt.setJurirno(docEnt.getJurirno());
            contEnt.setDataSeCode(docEnt.getDataSeCode());
            contEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
            
            contEnt.setTitle(XMLUtil.getSingleElement("//BODY", xdoc).getChildText("TITLE"));
            contEnt.setContent(xmlStr);
            dartTbPaDartDocContentRepository.save(contEnt);
            docBodyEnt.setContentSn(contEnt.getContentSn());
        }
        
        dartTbPaDartDocBodyRepository.save(docBodyEnt);
        
        if (XMLUtil.isExistsElement("//BODY/INSERTION", xdoc)) {
            List<Element> insertionList = XMLUtil.getMultiElements("//BODY/INSERTION", xdoc);
            for(Element insElem : insertionList) {
                instEnt = dartTbPaDartInsertion.xmlToDb(insElem, null, null, null, null, xdoc, dartEntity, histEnt, docEnt);  
            }            
        }

        // PART
        if (XMLUtil.isExistsElement("//BODY/PART", xdoc)) {
            List<Element> partList = XMLUtil.getMultiElements("//BODY/PART", xdoc);
            for(Element partElem : partList) {
                dartTbPaDartPart.xmlToDb(partElem, null, xdoc, dartEntity, histEnt, docEnt);
            }       
        }
        
        // SECTION-1
        if (XMLUtil.isExistsElement("//BODY/SECTION-1", xdoc)) {
            List<Element> sectionList = XMLUtil.getMultiElements("//BODY/SECTION-1", xdoc);
            for(Element sectionElem : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-1", sectionElem, null, null, null, xdoc, dartEntity, histEnt, docEnt);
            }
            
        }
        
        // LIBRARY
        if (XMLUtil.isExistsElement("//BODY/LIBRARY", xdoc)) {
            List<Element> libraryList = XMLUtil.getMultiElements("//BODY/LIBRARY", xdoc);
            for(Element libElem : libraryList) {
                dartTbPaDartInsertionLibrary.xmlToDb(libElem, instEnt, xdoc, dartEntity, histEnt, docEnt);
            }
        }
         
        dartTbPaDartDocBodyRepository.save(docBodyEnt);
    }
}
