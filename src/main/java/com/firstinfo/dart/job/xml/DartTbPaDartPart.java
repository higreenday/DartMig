package com.firstinfo.dart.job.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocBodyEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocContentEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocInstEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocInstLibEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocPartEntity;
import com.firstinfo.dart.entity.DartTbPaDartMasterEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocSectionEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocBodyRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocContentRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocInstRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocPartRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocSectionRepository;

import oracle.net.aso.p;

@Service
public class DartTbPaDartPart {

    @Autowired
    DartTbPaDartDocPartRepository dartTbPaDartDocPartRepository;

    @Autowired
    DartTbPaDartDocContentRepository dartTbPaDartDocContentRepository;

    
    @Autowired
    DartTbPaDartInsertion dartTbPaDartInsertion;
    
    @Autowired
    DartTbPaDartSection dartTbPaDartSection;
    
    public DartTbPaDartDocPartEntity xmlToDb(Element partElm, DartTbPaDartDocInstLibEntity instLibEnt, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {

        DartTbPaDartDocPartEntity partEnt = new DartTbPaDartDocPartEntity();

        partEnt.setJurirno(docEnt.getJurirno());
        partEnt.setDataSeCode(docEnt.getDataSeCode());
        partEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
        partEnt.setAtchFileSn(docEnt.getAtchFileSn());
 
        String xmlStr = XMLUtil.getContentsFromElem(partElm, "TITLE");
        if (xmlStr.trim().isEmpty() == false) {
            DartTbPaDartDocContentEntity contEnt = new DartTbPaDartDocContentEntity();   

            contEnt.setJurirno(docEnt.getJurirno());
            contEnt.setDataSeCode(docEnt.getDataSeCode());
            contEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
            contEnt.setAtchFileSn(docEnt.getAtchFileSn());
            contEnt.setTitle("");
            contEnt.setContent(xmlStr);
            dartTbPaDartDocContentRepository.save(contEnt);
            partEnt.setContentSn(contEnt.getContentSn());
        } 

        if (instLibEnt != null) {
            partEnt.setPLibSn(instLibEnt.getLibSn());
        }
        
        partEnt.setAid(XMLUtil.getAttrStr("AID", partElm));
        partEnt.setAclass(XMLUtil.getAttrStr("ACLASS", partElm));
        partEnt.setApartsource(XMLUtil.getAttrStr("APARTSOURCE", partElm));
        partEnt.setApartinfo(XMLUtil.getAttrStr("APARTINFO", partElm)); 
        
        dartTbPaDartDocPartRepository.save(partEnt);

        
        // SECTION-1
        if (partElm.getChild("SECTION-1") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-1", partElm.getChild("SECTION-1"), partEnt, null, null, xdoc, dartEntity, histEnt, docEnt);
        }

        // INSERTION
        if (partElm.getChild("INSERTION") != null) {
            dartTbPaDartInsertion.xmlToDb(partElm.getChild("INSERTION"), null, null, partEnt, null, xdoc, dartEntity, histEnt, docEnt);
        }
        
        return partEnt;
    }
}
