package com.firstinfo.dart.job.xml;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
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
public class DartTbPaDartSection {

    @Autowired
    DartTbPaDartDocSectionRepository dartTbPaDartDocSectionRepository;

    @Autowired
    DartTbPaDartDocContentRepository dartTbPaDartDocContentRepository;
    
    @Autowired
    DartTbPaDartSection dartTbPaDartSection;
    
    @Autowired
    DartTbPaDartInsertion dartTbPaDartInsertion;

    @Autowired
    private EntityManager entityManager;
    
    public DartTbPaDartDocSectionEntity xmlToDb(String sectionCode, Element sectionElm, DartTbPaDartDocPartEntity pPartEnt, DartTbPaDartDocSectionEntity pSectionEnt, DartTbPaDartDocInstLibEntity pInstLibEnt, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {

        DartTbPaDartDocSectionEntity sectionEnt = new DartTbPaDartDocSectionEntity();
         
        sectionEnt.setJurirno(docEnt.getJurirno());
        sectionEnt.setDataSeCode(docEnt.getDataSeCode());
        sectionEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
        sectionEnt.setAtchFileSn(docEnt.getAtchFileSn());
        sectionEnt.setSectionCode(sectionCode);
        
        if (pPartEnt != null) {
            sectionEnt.setPPartSn(pPartEnt.getPartSn());
        }
        if (pSectionEnt != null) {
            sectionEnt.setPSectionSn(pSectionEnt.getSectionSn());
        }
        if (pInstLibEnt != null) {
            sectionEnt.setPLibSn(pInstLibEnt.getLibSn());
        }
        
        String xmlStr = XMLUtil.getContentsFromElem(sectionElm, "TITLE");
        if (xmlStr.trim().isEmpty() == false) {
            DartTbPaDartDocContentEntity contEnt = new DartTbPaDartDocContentEntity();   

            contEnt.setJurirno(docEnt.getJurirno());
            contEnt.setDataSeCode(docEnt.getDataSeCode());
            contEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
            contEnt.setAtchFileSn(docEnt.getAtchFileSn());
            contEnt.setTitle(XMLUtil.getChildText("TITLE", sectionElm));
            contEnt.setContent(xmlStr);
            dartTbPaDartDocContentRepository.save(contEnt);
            sectionEnt.setContentSn(contEnt.getContentSn());
             
        } 

        sectionEnt.setAid(XMLUtil.getAttrStr("AID", sectionElm));
        sectionEnt.setAclass(XMLUtil.getAttrStr("ACLASS", sectionElm));
        sectionEnt.setApartsource(XMLUtil.getAttrStr("APARTSOURCE", sectionElm));
        sectionEnt.setApartinfo(XMLUtil.getAttrStr("APARTINFO", sectionElm)); 
        
        dartTbPaDartDocSectionRepository.save(sectionEnt);
        
        // SECTION-2
        if (sectionCode.equals("SECTION-1") && sectionElm.getChild("SECTION-2") != null) {
            List<Element> sectionList = sectionElm.getChildren("SECTION-2");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-2", secElm, null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
            }             
        }

        // SECTION-3
        if (sectionCode.equals("SECTION-2") && sectionElm.getChild("SECTION-3") != null) {
            List<Element> sectionList = sectionElm.getChildren("SECTION-3");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-3", secElm, null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
            }             
        }

        // SECTION-4
        if (sectionCode.equals("SECTION-3") && sectionElm.getChild("SECTION-4") != null) {
            List<Element> sectionList = sectionElm.getChildren("SECTION-4");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-4", secElm, null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
            }             
        }

        // SECTION-5
        if (sectionCode.equals("SECTION-4") && sectionElm.getChild("SECTION-5") != null) {
            List<Element> sectionList = sectionElm.getChildren("SECTION-5");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-5", secElm, null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
            }             
        }

        // SECTION-6
        if (sectionCode.equals("SECTION-5") && sectionElm.getChild("SECTION-6") != null) {
            List<Element> sectionList = sectionElm.getChildren("SECTION-6");
            for(Element secElm : sectionList) {
                dartTbPaDartSection.xmlToDb("SECTION-6", secElm, null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
            }             
        }

        // INSERTION
        if (sectionElm.getChild("INSERTION") != null) {
            List<Element> insertionList = sectionElm.getChildren("INSERTION");
            for(Element insElem : insertionList) {
                dartTbPaDartInsertion.xmlToDb(insElem, null, null, null, sectionEnt, xdoc, dartEntity, histEnt, docEnt);       
            }             
        } 
        
        return sectionEnt;
    }
}
