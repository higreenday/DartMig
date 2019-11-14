package com.firstinfo.dart.job.xml;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocEntity;
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

    @Autowired
    DartTbPaDartDocHeaderSumy dartTbPaDartDocHeaderSumy;

    
    public void xmlToDb(Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {
        DartTbPaDartDocHeaderEntity docHeaderEnt = new DartTbPaDartDocHeaderEntity();
        
        docHeaderEnt.setJurirno(docEnt.getJurirno());
        docHeaderEnt.setDataSeCode(docEnt.getDataSeCode());
        docHeaderEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
        docHeaderEnt.setAtchFileSn(docEnt.getAtchFileSn());
        
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
            docHeaderEnt.setCompanyNameAaccounttype(XMLUtil.getChildAttrStr("COMPANY-NAME", "AACCOUNTTYPE", docHeaderElm));
            
            // summary 저장
            if (docHeaderElm.getChild("SUMMARY") != null) {
                List<Element> summaryList = docHeaderElm.getChildren("SUMMARY");
                dartTbPaDartDocHeaderSumy.xmlToDb(summaryList, xdoc, dartEntity, histEnt, docEnt);
            }
        }
        
        
        dartTbPaDartDocHeaderRepository.save(docHeaderEnt);
    }
}
