package com.firstinfo.dart.job.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.firstinfo.dart.entity.DartTbPaDartDocHeaderEntity;
import com.firstinfo.dart.entity.DartTbPaDartMasterEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocHeaderRepository;
import com.firstinfo.dart.repo.DartTbPaDartMasterRepository;

@Service
public class DartTbPaDartDocHeader {

    @Autowired
    DartTbPaDartDocHeaderRepository dartTbPaDartDocHeaderRepository;

    
    public void xmlToDb(Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartMasterEntity masterEnt) throws Exception {
        DartTbPaDartDocHeaderEntity docHeaderEnt = new DartTbPaDartDocHeaderEntity();
        
        docHeaderEnt.setJurirno(masterEnt.getJurirno());
        docHeaderEnt.setDataSeCode(masterEnt.getDataSeCode());
        docHeaderEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
        
        if (XMLUtil.isExistsElement("//DOCUMENT-HEADER", xdoc)) {
            Element docHeaderElm = XMLUtil.getSingleElement("//DOCUMENT-HEADER", xdoc);
            docHeaderEnt.setAextClass(XMLUtil.getAttrStr("AEXT-CLASS", docHeaderElm));
            docHeaderEnt.setDocumentName(XMLUtil.getChildText("DOCUMENT-NAME", docHeaderElm));
            docHeaderEnt.setDocumentNameAcode(XMLUtil.getChildAttrStr("DOCUMENT-NAME", "ACODE", docHeaderElm));
            docHeaderEnt.setFomulaVersion(XMLUtil.getChildText("FORMULA-VERSION", docHeaderElm));
            docHeaderEnt.setFomulaVersionAdate(XMLUtil.getChildAttrStr("FORMULA-VERSION", "ADATE", docHeaderElm));
            docHeaderEnt.setFomulaVersionSubver(XMLUtil.getChildAttrStr("FORMULA-VERSION", "SUBVER", docHeaderElm));
            docHeaderEnt.setCompanyName(XMLUtil.getChildText("COMPANY-NAME", docHeaderElm));
            docHeaderEnt.setCompanyNameAregcik(XMLUtil.getChildAttrStr("COMPANY-NAME", "AREGCIK", docHeaderElm));
            docHeaderEnt.setCompanynameAaccounttype(XMLUtil.getChildAttrStr("COMPANY-NAME", "AACCOUNTTYPE", docHeaderElm));
            docHeaderEnt.setExtraction(XMLUtil.getChildText("EXTRACTION", docHeaderElm));
            docHeaderEnt.setExtractionAcode(XMLUtil.getChildAttrStr("EXTRACTION", "ACODE", docHeaderElm));
            docHeaderEnt.setExtractionAfeature(XMLUtil.getChildAttrStr("EXTRACTION", "AFEATURE", docHeaderElm));
        }
        
        
        dartTbPaDartDocHeaderRepository.save(docHeaderEnt);
    }
}
