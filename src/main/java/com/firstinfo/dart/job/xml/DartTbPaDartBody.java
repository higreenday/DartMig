package com.firstinfo.dart.job.xml;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocBodyEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocContentEntity;
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
 
    public void xmlToDb(Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartMasterEntity masterEnt) throws Exception {
        DartTbPaDartDocBodyEntity docBodyEnt = new DartTbPaDartDocBodyEntity();
        DartTbPaDartDocInstEntity instEnt = new DartTbPaDartDocInstEntity();
        DartTbPaDartDocSectionEntity sec1Ent = new DartTbPaDartDocSectionEntity();
        DartTbPaDartDocContentEntity sec1ContEnt = new DartTbPaDartDocContentEntity(); 
        
        docBodyEnt.setJurirno(masterEnt.getJurirno());
        docBodyEnt.setDataSeCode(masterEnt.getDataSeCode());
        docBodyEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
        
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
            System.out.println(dartEntity.getMainXmlFile().getAbsolutePath());
            System.out.println("===================================================");
            
        }

        if (XMLUtil.isExistsElement("//BODY/CORRECTION", xdoc)) {
            int corrContSn = dartTbPaDartCorrection.xmlToDb(XMLUtil.getSingleElement("//BODY/CORRECTION", xdoc), xdoc, dartEntity, histEnt, masterEnt);
            docBodyEnt.setCorrectionContentSn(corrContSn);
        }

        if (XMLUtil.isExistsElement("//BODY/COVER", xdoc)) {
            int coverContSn = dartTbPaDartCover.xmlToDb(XMLUtil.getSingleElement("//BODY/COVER", xdoc), xdoc, dartEntity, histEnt, masterEnt);
            docBodyEnt.setCoverContentSn(coverContSn);            
        }

        if (XMLUtil.isExistsElement("//BODY/TOC", xdoc)) {
            int tocContSn = dartTbPaDartToc.xmlToDb(XMLUtil.getSingleElement("//BODY/TOC", xdoc), xdoc, dartEntity, histEnt, masterEnt);
            docBodyEnt.setTocContentSn(tocContSn);        
        }
        
        // content 저장 
        String xmlStr = XMLUtil.getContentsFromElem(XMLUtil.getSingleElement("//BODY",xdoc), "TITLE");
        if (xmlStr.trim().isEmpty() == false) {
            DartTbPaDartDocContentEntity contEnt = new DartTbPaDartDocContentEntity();   

            contEnt.setJurirno(masterEnt.getJurirno());
            contEnt.setDataSeCode(masterEnt.getDataSeCode());
            contEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
            
            contEnt.setTitle("");
            contEnt.setContent(xmlStr);
            dartTbPaDartDocContentRepository.save(contEnt);
            docBodyEnt.setContentSn(contEnt.getContentSn());
        }
        
        dartTbPaDartDocBodyRepository.save(docBodyEnt);
        
        if (XMLUtil.isExistsElement("//BODY/INSERTION", xdoc)) {
            instEnt = dartTbPaDartInsertion.xmlToDb(XMLUtil.getSingleElement("//BODY/INSERTION", xdoc), null, null, null, xdoc, dartEntity, histEnt, masterEnt);            
        }

        // PART
        if (XMLUtil.isExistsElement("//BODY/PART", xdoc)) {
            dartTbPaDartPart.xmlToDb(XMLUtil.getSingleElement("//BODY/PART", xdoc), null, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // SECTION-1
        if (XMLUtil.isExistsElement("//BODY/SECTION-1", xdoc)) {
            dartTbPaDartSection.xmlToDb("SECTION-1", XMLUtil.getSingleElement("//BODY/SECTION-1", xdoc), null, null, null, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // LIBRARY
        if (XMLUtil.isExistsElement("//BODY/LIBRARY", xdoc)) {
            List<Element> libraryList = XMLUtil.getMultiElements("//BODY/LIBRARY", xdoc);
            for(Element libElem : libraryList) {
                dartTbPaDartInsertionLibrary.xmlToDb(libElem, instEnt, xdoc, dartEntity, histEnt, masterEnt);
            }
        }
         
        dartTbPaDartDocBodyRepository.save(docBodyEnt);
    }
}
