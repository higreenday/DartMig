package com.firstinfo.dart.job.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocBodyEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocContentEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocInstEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocInstLibEntity;
import com.firstinfo.dart.entity.DartTbPaDartMasterEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocSectionEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocBodyRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocContentRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocInstLibRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocInstRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocSectionRepository;

import oracle.net.aso.p;

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

    
    public DartTbPaDartDocInstLibEntity xmlToDb(Element instLibElm, DartTbPaDartDocInstEntity instEnt, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartMasterEntity masterEnt) throws Exception {

        DartTbPaDartDocInstLibEntity instLibEnt = new DartTbPaDartDocInstLibEntity();
        
        instLibEnt.setJurirno(masterEnt.getJurirno());
        instLibEnt.setDataSeCode(masterEnt.getDataSeCode());
        instLibEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
 
        String xmlStr = XMLUtil.getContentsFromElem(instLibElm, "TITLE");
        if (xmlStr.trim().isEmpty() == false) {
            DartTbPaDartDocContentEntity contEnt = new DartTbPaDartDocContentEntity();   

            contEnt.setJurirno(masterEnt.getJurirno());
            contEnt.setDataSeCode(masterEnt.getDataSeCode());
            contEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
            contEnt.setTitle("");
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
            dartTbPaDartDocFile.xmlToDb(instLibElm.getChildren("FILENAME"), instLibEnt, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // PART
        if (instLibElm.getChild("PART") != null) {
            dartTbPaDartPart.xmlToDb(instLibElm.getChild("PART"), instLibEnt, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // SECTION-1
        if (instLibElm.getChild("SECTION-1") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-1", instLibElm.getChild("SECTION-1"), null, null, instLibEnt, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // SECTION-2
        if (instLibElm.getChild("SECTION-2") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-2", instLibElm.getChild("SECTION-2"), null, null, instLibEnt, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // SECTION-3
        if (instLibElm.getChild("SECTION-3") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-3", instLibElm.getChild("SECTION-3"), null, null, instLibEnt, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // SECTION-4
        if (instLibElm.getChild("SECTION-4") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-4", instLibElm.getChild("SECTION-4"), null, null, instLibEnt, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // SECTION-5
        if (instLibElm.getChild("SECTION-5") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-5", instLibElm.getChild("SECTION-5"), null, null, instLibEnt, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // SECTION-6
        if (instLibElm.getChild("SECTION-6") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-6", instLibElm.getChild("SECTION-6"), null, null, instLibEnt, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        // CORRECTION
        if (instLibElm.getChild("CORRECTION") != null) {
            int corrContSn = dartTbPaDartCorrection.xmlToDb(instLibElm.getChild("CORRECTION"), xdoc, dartEntity, histEnt, masterEnt);
            instLibEnt.setCorrectionContentSn(corrContSn);
            dartTbPaDartDocInstLibRepository.save(instLibEnt);
        }
        
        // INSERTION
        if (instLibElm.getChild("INSERTION") != null) {
            dartTbPaDartInsertion.xmlToDb(instLibElm.getChild("INSERTION"), null, instLibEnt, null, xdoc, dartEntity, histEnt, masterEnt);
        }
        
        return instLibEnt;
    }
}
