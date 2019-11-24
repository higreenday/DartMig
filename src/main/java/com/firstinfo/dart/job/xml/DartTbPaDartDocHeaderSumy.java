package com.firstinfo.dart.job.xml;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocHeaderSumyEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocHeaderSumyRepository;

@Service
public class DartTbPaDartDocHeaderSumy {

    @Autowired
    DartTbPaDartDocHeaderSumyRepository dartTbPaDartDocHeaderSumyRepository;

    public void xmlToDb(List<Element> summaryList, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {
        
        for(Element summaryElm : summaryList) {
            DartTbPaDartDocHeaderSumyEntity summaryEnt = new DartTbPaDartDocHeaderSumyEntity();

            summaryEnt.setJurirno(docEnt.getJurirno());
            summaryEnt.setDataSeCode(docEnt.getDataSeCode());
            summaryEnt.setPblntfDataSn(docEnt.getPblntfDataSn());
            summaryEnt.setAtchFileSn(docEnt.getAtchFileSn());

            summaryEnt.setExtraction(summaryElm.getText());
            summaryEnt.setAcode(XMLUtil.getAttrStr("ACODE", summaryElm));
            summaryEnt.setAfeature(XMLUtil.getAttrStr("AFEATURE", summaryElm));
            dartTbPaDartDocHeaderSumyRepository.save(summaryEnt);
        }
        
    }
}
