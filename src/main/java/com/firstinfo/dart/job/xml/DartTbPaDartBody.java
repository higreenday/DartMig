package com.firstinfo.dart.job.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocBodyEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocContentEntity;
import com.firstinfo.dart.entity.DartTbPaDartInstEntity;
import com.firstinfo.dart.entity.DartTbPaDartMasterEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartTbPaDartSectionEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocBodyRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocContentRepository;
import com.firstinfo.dart.repo.DartTbPaDartInstRepository;
import com.firstinfo.dart.repo.DartTbPaDartSectionRepository;

@Service
public class DartTbPaDartBody {

    @Autowired
    DartTbPaDartDocBodyRepository dartTbPaDartDocBodyRepository;
    
    @Autowired
    DartTbPaDartInstRepository dartTbPaDartInstRepository;
    
    @Autowired
    DartTbPaDartDocContentRepository dartTbPaDartDocContentRepository;
    
    @Autowired
    DartTbPaDartSectionRepository dartTbPaDartSectionRepository;

    
    public void xmlToDb(Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartMasterEntity masterEnt) throws Exception {
        DartTbPaDartDocBodyEntity docBodyEnt = new DartTbPaDartDocBodyEntity();
        DartTbPaDartInstEntity instEnt = new DartTbPaDartInstEntity();
        DartTbPaDartSectionEntity sec1Ent = new DartTbPaDartSectionEntity();
        DartTbPaDartDocContentEntity sec1ContEnt = new DartTbPaDartDocContentEntity();
        
        docBodyEnt.setJurirno(masterEnt.getJurirno());
        docBodyEnt.setDataSeCode(masterEnt.getDataSeCode());
        docBodyEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());

        if (XMLUtil.isExistsElement("//BODY/CORRECTION", xdoc)) {
            Element corrElm = XMLUtil.getSingleElement("//BODY/CORRECTION", xdoc);
            DartTbPaDartDocContentEntity corrContEnt = new DartTbPaDartDocContentEntity();
            String xmlStr = XMLUtil.getXmlString(corrElm);
            
            corrContEnt.setTitle(XMLUtil.getChildText("TITLE", corrElm));
            corrContEnt.setContent(xmlStr);
            dartTbPaDartDocContentRepository.save(corrContEnt);
            
            docBodyEnt.setCorrectionSn(corrContEnt.getContentSn());
        }
        
        dartTbPaDartDocBodyRepository.save(docBodyEnt);
        
        if (XMLUtil.isExistsElement("//BODY/INSERTION", xdoc)) {
            Element instElm = XMLUtil.getSingleElement("//BODY/INSERTION", xdoc);

            instEnt.setJurirno(masterEnt.getJurirno());
            instEnt.setDataSeCode(masterEnt.getDataSeCode());
            instEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());

            // TODO : body와 통합해야 할듯
            instEnt.setInsertionSeCode("BODY"); // TODO: 사용안하는듯
            instEnt.setInsertionAbasisnumber(XMLUtil.getAttrStr("ABASISNUMBER", instElm));
            instEnt.setInsertionAfrequency(XMLUtil.getAttrStr("AFREQUENCY", instElm));
            instEnt.setInsertionAduplication(XMLUtil.getAttrStr("ADUPLICATION", instElm));
            instEnt.setInsertionComment(XMLUtil.getChildText("COMMENT", instElm));
            instEnt.setInsertionLabrarylist(XMLUtil.getChildText("LIBRARYLIST", instElm));
            instEnt.setAid("");
            instEnt.setApartsource("");
            instEnt.setApartinfo("");

            dartTbPaDartInstRepository.save(instEnt);
        }

//        if (XMLUtil.isExistsElement("//BODY/PART", xdoc)) {
//            Element instElm = XMLUtil.getSingleElement("//BODY/PART", xdoc);
//
//            instEnt.setJurirno(masterEnt.getJurirno());
//            instEnt.setDataSeCode(masterEnt.getDataSeCode());
//            instEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
//
//            // TODO : body와 통합해야 할듯
//            instEnt.setInsertionSeCode("BODY"); // TODO: 사용안하는듯
//            instEnt.setInsertionAbasisnumber(XMLUtil.getAttrStr("ABASISNUMBER", instElm));
//            instEnt.setInsertionAfrequency(XMLUtil.getAttrStr("AFREQUENCY", instElm));
//            instEnt.setInsertionAduplication(XMLUtil.getAttrStr("ADUPLICATION", instElm));
//            instEnt.setInsertionComment(XMLUtil.getChildText("COMMENT", instElm));
//            instEnt.setInsertionLabrarylist(XMLUtil.getChildText("LIBRARYLIST", instElm));
//            instEnt.setAid("");
//            instEnt.setApartsource("");
//            instEnt.setApartinfo("");
//
//            dartTbPaDartInstRepository.save(instEnt);
//        }

        if (XMLUtil.isExistsElement("//BODY/SECTION-1", xdoc)) {
            Element sec1Elm = XMLUtil.getSingleElement("//BODY/SECTION-1", xdoc);
            String xmlStr = XMLUtil.getXmlString(sec1Elm);
            
            sec1ContEnt.setTitle(XMLUtil.getChildText("TITLE", sec1Elm));
            sec1ContEnt.setContent(xmlStr);
            dartTbPaDartDocContentRepository.save(sec1ContEnt);

            sec1Ent.setJurirno(masterEnt.getJurirno());
            sec1Ent.setDataSeCode(masterEnt.getDataSeCode());
            sec1Ent.setPblntfDataSn(masterEnt.getPblntfDataSn());

            sec1Ent.setSectionCode("SECTION-1");
            sec1Ent.setSectionSeCode("BODY");
            sec1Ent.setUpperSectionSn(-1);
            sec1Ent.setContentSn(sec1ContEnt.getContentSn());
            sec1Ent.setSectionAid(XMLUtil.getAttrStr("AID", sec1Elm));
            sec1Ent.setSectionAclass(XMLUtil.getAttrStr("ACLASS", sec1Elm));
            sec1Ent.setSectionApartsource(XMLUtil.getAttrStr("APARTSOURCE", sec1Elm));
            sec1Ent.setSectionApartinfo(XMLUtil.getAttrStr("APARTINFO", sec1Elm));
            // TODO : content sn 을 Content_SN만 저장하면 될것 같음
            sec1Ent.setSectionPgbrk(XMLUtil.getChildText("PBBRK", sec1Elm));
            sec1Ent.setSectionPgbrkAnumber(XMLUtil.getChildAttrStr("PBBRK", "ANUMBER", sec1Elm));
            
            // TODO : SECTION-2와 INSERTION이 들어올 수 있음

            dartTbPaDartSectionRepository.save(sec1Ent);
        }
        
        // TODO : body 아래에 바로 html이 있는 경우가 있어보임

        dartTbPaDartDocBodyRepository.save(docBodyEnt);
    }
}
