package com.firstinfo.dart.job.xml;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
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
 
    public void xmlToDb(Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {
        DartTbPaDartDocBodyEntity docBodyEnt = new DartTbPaDartDocBodyEntity();
        DartTbPaDartDocInstEntity instEnt = new DartTbPaDartDocInstEntity();
        DartTbPaDartDocSectionEntity sec1Ent = new DartTbPaDartDocSectionEntity();
        DartTbPaDartDocContentEntity sec1ContEnt = new DartTbPaDartDocContentEntity(); 
        
        docBodyEnt.setJurirno(docEnt.getJurirno());
        docBodyEnt.setDataSeCode(docEnt.getDataSeCode());
        docBodyEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
        docBodyEnt.setAtchFileSn(docEnt.getAtchFileSn());
        
        if (XMLUtil.isExistsElement("//BODY/TITLE", xdoc)
                || XMLUtil.isExistsElement("//BODY/SUBTITLE", xdoc)
                || XMLUtil.isExistsElement("//BODY/CAUTION", xdoc)
                || XMLUtil.isExistsElement("//BODY/WARNING", xdoc)
                || XMLUtil.isExistsElement("//BODY/PART", xdoc)
                || XMLUtil.isExistsElement("//BODY/P", xdoc)
                || XMLUtil.isExistsElement("//BODY/TABLE-GROUP", xdoc)
                || XMLUtil.isExistsElement("//BODY/TITLE", xdoc)
                || XMLUtil.isExistsElement("//BODY/IMAGE", xdoc)
                || XMLUtil.isExistsElement("//BODY/APPENDIX", xdoc)
                || XMLUtil.isExistsElement("//BODY/LIBRARY", xdoc)) {
            System.out.println("===================================================");
            System.out.println(dartEntity.getDirPath());
            System.out.println("===================================================");
            
        }

        if (XMLUtil.isExistsElement("//BODY/CORRECTION", xdoc)) { 
            int corrContSn = dartTbPaDartCorrection.xmlToDb(XMLUtil.getSingleElement("//BODY/CORRECTION", xdoc), xdoc, dartEntity, histEnt, docEnt);
            docBodyEnt.setCorrectionContentSn(corrContSn);
        }

        if (XMLUtil.isExistsElement("//BODY/COVER", xdoc)) {
            int coverContSn = dartTbPaDartCover.xmlToDb(XMLUtil.getSingleElement("//BODY/COVER", xdoc), xdoc, dartEntity, histEnt, docEnt);
            docBodyEnt.setCoverContentSn(coverContSn);            
        }

        if (XMLUtil.isExistsElement("//BODY/TOC", xdoc)) {
            int tocContSn = dartTbPaDartToc.xmlToDb(XMLUtil.getSingleElement("//BODY/TOC", xdoc), xdoc, dartEntity, histEnt, docEnt);
            docBodyEnt.setTocContentSn(tocContSn);        
        }
        
        // content 저장 
//        String xmlStr = XMLUtil.getContentsFromElem(XMLUtil.getSingleElement("//BODY",xdoc), "TITLE");
//        if (xmlStr.trim().isEmpty() == false) {
//            DartTbPaDartDocContentEntity contEnt = new DartTbPaDartDocContentEntity();   
//
//            contEnt.setJurirno(docEnt.getJurirno());
//            contEnt.setDataSeCode(docEnt.getDataSeCode());
//            contEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
//            
//            contEnt.setTitle("");
//            contEnt.setContent(xmlStr);
//            dartTbPaDartDocContentRepository.save(contEnt);
//            docBodyEnt.setContentSn(contEnt.getContentSn());
//        }
        
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
