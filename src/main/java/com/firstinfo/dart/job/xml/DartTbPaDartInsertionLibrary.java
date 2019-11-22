package com.firstinfo.dart.job.xml;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocContentEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocInstEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocInstLibEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocContentRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocInstLibRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocInstRepository;

@Service
public class DartTbPaDartInsertionLibrary {

    @Autowired
    DartTbPaDartDocInstLibRepository dartTbPaDartDocInstLibRepository;
    
    @Autowired
    DartTbPaDartDocInstRepository dartTbPaDartInstRepository;

    @Autowired
    DartTbPaDartDocContentRepository dartTbPaDartDocContentRepository;

    @Autowired
    DartTbPaDartCorrection dartTbPaDartCorrection;
    
    @Autowired
    DartTbPaDartDocFile dartTbPaDartDocFile;
    
    @Autowired
    DartTbPaDartInsertion dartTbPaDartInsertion;
    
    @Autowired
    DartTbPaDartSection dartTbPaDartSection;
    
    @Autowired
    DartTbPaDartPart dartTbPaDartPart;

    
    public DartTbPaDartDocInstLibEntity xmlToDb(Element instLibElm, DartTbPaDartDocInstEntity instEnt, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {

        DartTbPaDartDocInstLibEntity instLibEnt = new DartTbPaDartDocInstLibEntity();
        
        instLibEnt.setJurirno(docEnt.getJurirno());
        instLibEnt.setDataSeCode(docEnt.getDataSeCode());
        instLibEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
        instLibEnt.setAtchFileSn(docEnt.getAtchFileSn());
 
        String xmlStr = XMLUtil.getContentsFromElem(instLibElm, "TITLE");
        if (xmlStr.trim().isEmpty() == false) {
            DartTbPaDartDocContentEntity contEnt = new DartTbPaDartDocContentEntity();   

            contEnt.setJurirno(docEnt.getJurirno());
            contEnt.setDataSeCode(docEnt.getDataSeCode());
            contEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
            contEnt.setAtchFileSn(docEnt.getAtchFileSn());
            contEnt.setTitle(XMLUtil.getChildText("TITLE", instLibElm));
            contEnt.setContent(xmlStr);
            dartTbPaDartDocContentRepository.save(contEnt);
            instLibEnt.setContentSn(contEnt.getContentSn());
        }
        instLibEnt.setPInsertionSn(instEnt.getInsertionSn());
         
        instLibEnt.setAid(XMLUtil.getAttrStr("AID", instLibElm));
        instLibEnt.setAclass(XMLUtil.getAttrStr("ACLASS", instLibElm));
        instLibEnt.setApartsource(XMLUtil.getAttrStr("APARTSOURCE", instLibElm));
        instLibEnt.setApartinfo(XMLUtil.getAttrStr("APARTINFO", instLibElm)); 

        dartTbPaDartDocInstLibRepository.save(instLibEnt);
        
        // FILENAME
        if (instLibElm.getChild("FILENAME") != null) {
            dartTbPaDartDocFile.xmlToDb(instLibElm.getChildren("FILENAME"), instLibEnt, xdoc, dartEntity, histEnt, docEnt);
        }
        
        // PART
        if (instLibElm.getChild("PART") != null) {
            dartTbPaDartPart.xmlToDb(instLibElm.getChild("PART"), instLibEnt, xdoc, dartEntity, histEnt, docEnt);
        }
        
        // SECTION-1
        if (instLibElm.getChild("SECTION-1") != null) {
            List<Element> sectionList = instLibElm.getChildren("SECTION-1");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-1", secElm, null, null, instLibEnt, xdoc, dartEntity, histEnt, docEnt);
            }              
        }
        
        // SECTION-2
        if (instLibElm.getChild("SECTION-2") != null) {
            List<Element> sectionList = instLibElm.getChildren("SECTION-2");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-2", secElm, null, null, instLibEnt, xdoc, dartEntity, histEnt, docEnt);
            }              
        }
        
        // SECTION-3
        if (instLibElm.getChild("SECTION-3") != null) {
            List<Element> sectionList = instLibElm.getChildren("SECTION-3");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-3", secElm, null, null, instLibEnt, xdoc, dartEntity, histEnt, docEnt);
            }              
        }
        
        // SECTION-4
        if (instLibElm.getChild("SECTION-4") != null) {
            List<Element> sectionList = instLibElm.getChildren("SECTION-4");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-4", secElm, null, null, instLibEnt, xdoc, dartEntity, histEnt, docEnt);
            }              
        }
        
        // SECTION-5
        if (instLibElm.getChild("SECTION-5") != null) {
            List<Element> sectionList = instLibElm.getChildren("SECTION-5");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-5", secElm, null, null, instLibEnt, xdoc, dartEntity, histEnt, docEnt);
            }              
        }
        
        // SECTION-6
        if (instLibElm.getChild("SECTION-6") != null) {
            List<Element> sectionList = instLibElm.getChildren("SECTION-6");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-6", secElm, null, null, instLibEnt, xdoc, dartEntity, histEnt, docEnt);
            }              
        }
        
        // CORRECTION
        if (instLibElm.getChild("CORRECTION") != null) {
            int corrContSn = dartTbPaDartCorrection.xmlToDb(instLibElm.getChild("CORRECTION"), xdoc, dartEntity, histEnt, docEnt);
            instLibEnt.setCorrectionContentSn(corrContSn);
            dartTbPaDartDocInstLibRepository.save(instLibEnt);
        }
        
        // INSERTION
        if (instLibElm.getChild("INSERTION") != null) {
            List<Element> insertionList = instLibElm.getChildren("INSERTION");
            for(Element insElem : insertionList) {
                instEnt = dartTbPaDartInsertion.xmlToDb(insElem, null, instLibEnt, null, null, xdoc, dartEntity, histEnt, docEnt);
            }             
        }
        
        return instLibEnt;
    }
}
