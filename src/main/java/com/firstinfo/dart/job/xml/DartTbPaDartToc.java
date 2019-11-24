package com.firstinfo.dart.job.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class DartTbPaDartToc {

    @Autowired
    DartTbPaDartDocContentRepository dartTbPaDartDocContentRepository;

    public int xmlToDb(Element tocElm, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {
        
        String xmlStr = XMLUtil.getContentsFromElem(tocElm, "TITLE");
        DartTbPaDartDocContentEntity tocContEnt = new DartTbPaDartDocContentEntity();
        
        tocContEnt.setJurirno(docEnt.getJurirno());
        tocContEnt.setDataSeCode(docEnt.getDataSeCode());
        tocContEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
        tocContEnt.setAtchFileSn(docEnt.getAtchFileSn());
        
        tocContEnt.setTitle(XMLUtil.getChildText("TITLE", tocElm));
        tocContEnt.setTitleAclass(XMLUtil.getChildAttrStr("TITLE", "ACLASS", tocElm));
        tocContEnt.setTitleAtoc(XMLUtil.getChildAttrStr("TITLE", "ATOC", tocElm));
        tocContEnt.setTitleAassocnote(XMLUtil.getChildAttrStr("TITLE", "AASSOCNOTE", tocElm));
        tocContEnt.setTitleAunit(XMLUtil.getChildAttrStr("TITLE", "AUNIT", tocElm));
        tocContEnt.setTitleAunitvalue(XMLUtil.getChildAttrStr("TITLE", "AUNITVALUE", tocElm));
        tocContEnt.setPgbrk(XMLUtil.getChildAttrStr("TITLE", "PGBRK", tocElm));
        tocContEnt.setPgbrkAnumber(XMLUtil.getChildAttrStr("TITLE", "PGBRK_ANUMBER", tocElm));
        tocContEnt.setContent(xmlStr);
        dartTbPaDartDocContentRepository.save(tocContEnt);

        return tocContEnt.getContentSn();
    }
}
