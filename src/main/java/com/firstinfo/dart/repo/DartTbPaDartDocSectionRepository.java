package com.firstinfo.dart.repo;

import org.jdom2.Element;
import org.springframework.data.jpa.repository.JpaRepository;

import com.firstinfo.dart.entity.DartTbPaDartDocSectionEntity;
import com.firstinfo.dart.lib.XMLUtil;

public interface DartTbPaDartDocSectionRepository extends JpaRepository<DartTbPaDartDocSectionEntity, Integer> {
//    Element sec1Elm = XMLUtil.getSingleElement("//BODY/SECTION-1", xdoc);
//    String xmlStr = XMLUtil.getXmlString(sec1Elm);
//    
//    sec1ContEnt.setTitle(XMLUtil.getChildText("TITLE", sec1Elm));
//    sec1ContEnt.setContent(xmlStr);
//    sec1ContEnt.setJurirno(masterEnt.getJurirno());
//    sec1ContEnt.setDataSeCode(masterEnt.getDataSeCode());
//    sec1ContEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
//    dartTbPaDartDocContentRepository.save(sec1ContEnt);
//
//    sec1Ent.setJurirno(masterEnt.getJurirno());
//    sec1Ent.setDataSeCode(masterEnt.getDataSeCode());
//    sec1Ent.setPblntfDataSn(masterEnt.getPblntfDataSn());
//
//    sec1Ent.setSectionCode("SECTION-1"); 
//    sec1Ent.setUpperSectionSn(-1);
//    sec1Ent.setContentSn(sec1ContEnt.getContentSn());
//    sec1Ent.setSectionAid(XMLUtil.getAttrStr("AID", sec1Elm));
//    sec1Ent.setSectionAclass(XMLUtil.getAttrStr("ACLASS", sec1Elm));
//    sec1Ent.setSectionApartsource(XMLUtil.getAttrStr("APARTSOURCE", sec1Elm));
//    sec1Ent.setSectionApartinfo(XMLUtil.getAttrStr("APARTINFO", sec1Elm));
//    // TODO : content sn 을 Content_SN만 저장하면 될것 같음
////    sec1Ent.setPgbrk(XMLUtil.getChildText("PBBRK", sec1Elm));
////    sec1Ent.setPgbrkAnumber(XMLUtil.getChildAttrStr("PBBRK", "ANUMBER", sec1Elm));
//    
//    // TODO : SECTION-2와 INSERTION이 들어올 수 있음
//
//    dartTbPaDartSectionRepository.save(sec1Ent);
}
