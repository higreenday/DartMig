package com.firstinfo.dart.job.xml;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstinfo.dart.entity.DartTbPaDartDocEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocFileEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocHeaderEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocInstLibEntity;
import com.firstinfo.dart.entity.DartTbPaDartMasterEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocFileRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocHeaderRepository;
import com.firstinfo.dart.repo.DartTbPaDartMasterRepository;

@Service
public class DartTbPaDartDocFile {

    @Autowired
    DartTbPaDartDocFileRepository dartTbPaDartDocFileRepository;

    
    public void xmlToDb(List<Element> fileNameList, DartTbPaDartDocInstLibEntity instLibEnt, Document xdoc, DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartDocEntity docEnt) throws Exception {
        
        for(Element fileElm : fileNameList) {
            DartTbPaDartDocFileEntity fileEnt = new DartTbPaDartDocFileEntity();
            fileEnt.setPLibSn(instLibEnt.getLibSn());
            fileEnt.setFileNm(fileElm.getText());
            fileEnt.setFileAtype(XMLUtil.getAttrStr("ATYPE", fileElm));
            dartTbPaDartDocFileRepository.save(fileEnt);
        }
        
    }
}
