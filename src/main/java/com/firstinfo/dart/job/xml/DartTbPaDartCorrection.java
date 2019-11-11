package com.firstinfo.dart.job.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocBodyEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocContentEntity;
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
public class DartTbPaDartCorrection {

    @Autowired
    DartTbPaDartDocContentRepository dartTbPaDartDocContentRepository;

    
    public int xmlToDb(Element corrElm, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartMasterEntity masterEnt) throws Exception {
         
        DartTbPaDartDocContentEntity corrContEnt = new DartTbPaDartDocContentEntity();            
        String xmlStr = XMLUtil.getContentsFromElem(corrElm, "TITLE");

        corrContEnt.setJurirno(masterEnt.getJurirno());
        corrContEnt.setDataSeCode(masterEnt.getDataSeCode());
        corrContEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
        
        corrContEnt.setTitle(XMLUtil.getChildText("TITLE", corrElm));
        corrContEnt.setContent(xmlStr);
        dartTbPaDartDocContentRepository.save(corrContEnt);
        
        return corrContEnt.getContentSn();
    }
}
