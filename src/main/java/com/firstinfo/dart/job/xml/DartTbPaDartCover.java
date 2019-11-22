package com.firstinfo.dart.job.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocBodyEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocContentEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocInstEntity;
import com.firstinfo.dart.entity.DartTbPaDartMasterEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocSectionEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocBodyRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocContentRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocInstRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocSectionRepository;

@Component
public class DartTbPaDartCover {

    @Autowired
    DartTbPaDartDocContentRepository dartTbPaDartDocContentRepository;
 
    @Autowired
    ClobUpdate clobUpdate; 
    
    public int xmlToDb(Element coverElm, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {
        
        String xmlStr = XMLUtil.getContentsFromElem(coverElm, "COVER-TITLE");
        DartTbPaDartDocContentEntity coverContEnt = new DartTbPaDartDocContentEntity();

        coverContEnt.setJurirno(docEnt.getJurirno());
        coverContEnt.setDataSeCode(docEnt.getDataSeCode());
        coverContEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
        coverContEnt.setAtchFileSn(docEnt.getAtchFileSn());
        
        coverContEnt.setTitle(XMLUtil.getChildText("COVER-TITLE", coverElm));
        coverContEnt.setTitleAclass(XMLUtil.getChildAttrStr("COVER-TITLE", "ACLASS", coverElm));
        coverContEnt.setTitleAtoc(XMLUtil.getChildAttrStr("COVER-TITLE", "ATOC", coverElm));
        coverContEnt.setTitleAassocnote(XMLUtil.getChildAttrStr("COVER-TITLE", "AASSOCNOTE", coverElm));
        coverContEnt.setTitleAunit(XMLUtil.getChildAttrStr("COVER-TITLE", "AUNIT", coverElm));
        coverContEnt.setTitleAunitvalue(XMLUtil.getChildAttrStr("COVER-TITLE", "AUNITVALUE", coverElm));
        coverContEnt.setPgbrk(XMLUtil.getChildAttrStr("COVER-TITLE", "PGBRK", coverElm));
        coverContEnt.setPgbrkAnumber(XMLUtil.getChildAttrStr("COVER-TITLE", "PGBRK_ANUMBER", coverElm));
        //coverContEnt.setContent(xmlStr);
        dartTbPaDartDocContentRepository.save(coverContEnt);

        clobUpdate.updateClob(xmlStr, coverContEnt.getContentSn());
        
        return coverContEnt.getContentSn();
    }
}
