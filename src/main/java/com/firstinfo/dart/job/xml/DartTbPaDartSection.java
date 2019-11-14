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
            contEnt.setTitle("");
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
            dartTbPaDartSection.xmlToDb("SECTION-2", sectionElm.getChild("SECTION-2"), null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
        }

        // SECTION-3
        if (sectionCode.equals("SECTION-2") && sectionElm.getChild("SECTION-3") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-3", sectionElm.getChild("SECTION-3"), null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
        }

        // SECTION-4
        if (sectionCode.equals("SECTION-3") && sectionElm.getChild("SECTION-4") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-4", sectionElm.getChild("SECTION-4"), null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
        }

        // SECTION-5
        if (sectionCode.equals("SECTION-4") && sectionElm.getChild("SECTION-5") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-5", sectionElm.getChild("SECTION-5"), null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
        }

        // SECTION-6
        if (sectionCode.equals("SECTION-5") && sectionElm.getChild("SECTION-6") != null) {
            dartTbPaDartSection.xmlToDb("SECTION-6", sectionElm.getChild("SECTION-6"), null, sectionEnt, null, xdoc, dartEntity, histEnt, docEnt);
        }
        
        return sectionEnt;
    }
}
