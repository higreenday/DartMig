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
import com.firstinfo.dart.repo.DartTbPaDartDocSectionRepository;

import oracle.net.aso.p;

@Service
public class DartTbPaDartInsertion {

    @Autowired
    DartTbPaDartDocInstRepository dartTbPaDartDocInstRepository;

    @Autowired
    DartTbPaDartInsertionLibrary dartTbPaDartInsertionLibrary;
    
    public DartTbPaDartDocInstEntity xmlToDb(Element instElm, DartTbPaDartDocInstEntity pInstEnt, DartTbPaDartDocInstLibEntity instLibEnt, DartTbPaDartDocPartEntity partEnt, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {

        DartTbPaDartDocInstEntity instEnt = new DartTbPaDartDocInstEntity();
        
        instEnt.setJurirno(docEnt.getJurirno());
        instEnt.setDataSeCode(docEnt.getDataSeCode());
        instEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
        instEnt.setAtchFileSn(docEnt.getAtchFileSn());

        if (pInstEnt != null) {
            instEnt.setPInsertionSn(pInstEnt.getInsertionSn());
        }
        
        if (instLibEnt != null) {
            instEnt.setPLibSn(instLibEnt.getLibSn());
        }
        
        if (partEnt != null) {
            instEnt.setPPartSn(partEnt.getPartSn());
        }
         
        instEnt.setAbasisnumber(XMLUtil.getAttrStr("ABASISNUMBER", instElm));
        instEnt.setAfrequency(XMLUtil.getAttrStr("AFREQUENCY", instElm));
        instEnt.setAduplication(XMLUtil.getAttrStr("ADUPLICATION", instElm));
        instEnt.setIcomment(XMLUtil.getChildText("COMMENT", instElm));
        instEnt.setLibrarylist(XMLUtil.getChildText("LIBRARYLIST", instElm)); 

        dartTbPaDartDocInstRepository.save(instEnt);

        if (instElm.getChild("LIBRARY") != null) {
            List<Element> libraryList = instElm.getChildren("LIBRARY");
            for(Element libElem : libraryList) {
                dartTbPaDartInsertionLibrary.xmlToDb(libElem, instEnt, xdoc, dartEntity, histEnt, docEnt);
            }
        }
        return instEnt;
    }
}
