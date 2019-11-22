package com.firstinfo.dart.job;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.jdom2.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstinfo.dart.entity.DartTbPaDartDocEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocSubFileEntity;
import com.firstinfo.dart.entity.DartTbPaDartMasterEntity;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartTbPaDartReceiptEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.entity.xml.DOCUMENT;
import com.firstinfo.dart.exception.CustException;
import com.firstinfo.dart.job.xml.DartTbPaDartBody;
import com.firstinfo.dart.job.xml.DartTbPaDartDocHeader;
import com.firstinfo.dart.lib.XMLUtil;
import com.firstinfo.dart.repo.DartTbPaDartDocRepository;
import com.firstinfo.dart.repo.DartTbPaDartDocSubFileRepository;
import com.firstinfo.dart.repo.DartTbPaDartMasterRepository;
import com.firstinfo.dart.repo.DartTbPaDartReceiptRepository;

@Service
public class DartMig {

    @Autowired
    DartTbPaDartMasterRepository dartTbPaDartMasterRepository;

    @Autowired
    DartTbPaDartDocRepository dartTbPaDartDocRepository;

    @Autowired
    DartTbPaDartDocSubFileRepository dartTbPaDartDocSubFileRepository;

    @Autowired
    DartTbPaDartReceiptRepository dartTbPaDartReceiptRepository;

    @Autowired
    DartTbPaDartDocHeader dartTbPaDartDocHeader;
    
    @Autowired
    DartTbPaDartBody dartTbPaDartBody;
    

    @Transactional(rollbackFor=Exception.class)
    public void mig(DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt) throws Exception {

        // master 테이블 저장
        DartTbPaDartMasterEntity masterEnt = regTbPaDartMaster(dartEntity, histEnt);
        
        // doc 테이블 저장
        ArrayList<DartTbPaDartDocEntity> docEntArr = regTbPaDartDoc(dartEntity, histEnt, masterEnt);
        
        // receipt 테이블 저장
        DartTbPaDartReceiptEntity receiptEnt = regTbPaDartReceipt(dartEntity, histEnt, masterEnt);
        
        for(int i=0; i < dartEntity.getXmlCnt(); i++) {

            File xmlFile = dartEntity.getMainXmlFile(i);
            DartTbPaDartDocEntity docEnt = null;
            for(int j=0; j < docEntArr.size(); j++) {
                if (docEntArr.get(j).getFileNm().equalsIgnoreCase(xmlFile.getName())) {
                    docEnt = docEntArr.get(j);
                    break;
                }
            }
            
            // xml validation 체크
            boolean isValidXml = xmlValidation(xmlFile.getAbsolutePath()); 
            if (isValidXml == false) {
                throw new CustException(String.format("[%s]XML이 유효하지 않습니다.", xmlFile.getName()));
            }
            
            Document xdoc = XMLUtil.loadXmlDocument(xmlFile.getAbsolutePath());
            dartTbPaDartDocHeader.xmlToDb(xdoc, dartEntity, histEnt, docEnt);
            dartTbPaDartBody.xmlToDb(xdoc, dartEntity, histEnt, docEnt); 
        }
        
    }
    
    public DartTbPaDartMasterEntity regTbPaDartMaster(DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt) throws Exception {
         
        DartTbPaDartMasterEntity masterEnt = new DartTbPaDartMasterEntity();
        
        masterEnt.setJurirno(dartEntity.getReceiptJurirno());
        masterEnt.setDataSeCode(dartEntity.getDataSeCode());
        masterEnt.setSendDe(dartEntity.getSendDe());
        masterEnt.setDataSn(dartEntity.getDataSn());
        masterEnt.setMrktSe(dartEntity.getMrktSe());
        masterEnt.setMigHistSn(histEnt.getMigHistSn());
        masterEnt.setPblntfTy(dartEntity.getPblntfTy());
        masterEnt.setReachNo(dartEntity.getReachNo());
        masterEnt.setReportCode(dartEntity.getReportCode());

        Integer nextSn = dartTbPaDartMasterRepository.getNextPblntfDataSn(masterEnt.getJurirno(), masterEnt.getDataSeCode());
        masterEnt.setPblntfDataSn(nextSn.intValue());
        
        dartTbPaDartMasterRepository.save(masterEnt);
        return masterEnt;
    }
    
    public ArrayList<DartTbPaDartDocEntity> regTbPaDartDoc(DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartMasterEntity masterEnt) throws Exception {

        ArrayList<DartTbPaDartDocEntity> docEntArr = new ArrayList<DartTbPaDartDocEntity>();
        
        String strDoc = dartEntity.getDocumentCont();
        
        String[] docs = strDoc.split("\n");
        for(int i=1; i < docs.length; i++) {
            String[] docArr = docs[i].split("/");
            DartTbPaDartDocEntity docEnt = new DartTbPaDartDocEntity();
            docEnt.setJurirno(dartEntity.getReceiptJurirno());
            docEnt.setDataSeCode(dartEntity.getDataSeCode());
            docEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
            docEnt.setAtchFileSn(i);
            docEnt.setReprtTy(docArr[0].trim());
            docEnt.setPblntfCmpnyEsntlNo(docArr[1].trim());
            docEnt.setRefrnAt(docArr[2].trim());
            docEnt.setRefrnRceptNo(docArr[3].trim());
            docEnt.setCnncAt(docArr[4].trim());
            docEnt.setBsnsYear(docArr[5].trim());
            docEnt.setDocCode(docArr[6].trim());
            docEnt.setFileNm(docArr[7].trim());
            docEntArr.add(docEnt);
            dartTbPaDartDocRepository.save(docEnt);
            if (docArr.length > 7) {
                for(int j=0; j < ((docArr.length-7)/2); j++) {
                    // 서브 파일 목록 저장
                    String fileNm = docArr[8+(j*2)].split("\\\\")[1];
                    String folderNm = docArr[8+(j*2)].split("\\\\")[0];
                    DartTbPaDartDocSubFileEntity subFileEnt = new DartTbPaDartDocSubFileEntity();
                    subFileEnt.setJurirno(dartEntity.getReceiptJurirno());
                    subFileEnt.setDataSeCode(dartEntity.getDataSeCode());
                    subFileEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
                    subFileEnt.setAtchFileSn(docEnt.getAtchFileSn());
                    subFileEnt.setFileNm(fileNm);
                    subFileEnt.setFolderNm(folderNm);
                    dartTbPaDartDocSubFileRepository.save(subFileEnt);
                }
            }
        }
        return docEntArr;
    }
    
    public DartTbPaDartReceiptEntity regTbPaDartReceipt(DartUnzipEntity dartEntity, DartTbPaDartMigHistEntity histEnt, DartTbPaDartMasterEntity masterEnt) throws Exception {
        DartTbPaDartReceiptEntity receiptEnt = new DartTbPaDartReceiptEntity();
        receiptEnt.setJurirno(dartEntity.getReceiptJurirno());
        receiptEnt.setDataSeCode(dartEntity.getDataSeCode());
        receiptEnt.setPblntfDataSn(masterEnt.getPblntfDataSn());
        
        receiptEnt.setPresentnSe(dartEntity.getReceiptPresentnSe());
        receiptEnt.setJobBeginNo(dartEntity.getReceiptJobBeginNo());
        receiptEnt.setRceptNo(dartEntity.getReceiptRceptNo()); 
        receiptEnt.setReachNo(dartEntity.getReceiptReachNo());
        receiptEnt.setJobCode(dartEntity.getReceiptJobCode());
        receiptEnt.setJobName(dartEntity.getReceiptJobName());
        receiptEnt.setReportCode(dartEntity.getReceiptReportCode());
        receiptEnt.setReportName(dartEntity.getReceiptReportName());
        receiptEnt.setPblntfTrgetCmpnyEsntlNo(dartEntity.getReceiptPblntfTrgetCmpnyEsntlNo()); 
        receiptEnt.setPresentnEsntlNo(dartEntity.getReceiptPresentnEsntlNo());
        receiptEnt.setPresentnName(dartEntity.getReceiptPresentnName());
        receiptEnt.setCompanyName(dartEntity.getReceiptCompanyName());
        receiptEnt.setRceptDt(dartEntity.getReceiptRceptDt());
        receiptEnt.setUpdtTrgetRceptDt(dartEntity.getReceiptUpdtTrgetRceptDt());
        receiptEnt.setTodayRceptSe(dartEntity.getReceiptTodayRceptSe());
        receiptEnt.setCdpnyPblntfSe(dartEntity.getReceiptCdpnyPblntfSe());
        receiptEnt.setAditReprtNm(dartEntity.getReceiptAditReprtNm());
        
        dartTbPaDartReceiptRepository.save(receiptEnt);
        return receiptEnt;
    }
    
    /**
     * xml 자료 validation
     * @param xmlFile
     * @return
     * @throws Exception
     */
    private boolean xmlValidation(String xmlPath) throws Exception {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File xsdFile = new File(DartJob.class.getClassLoader().getResource("xsd/Dart3.xsd").toURI());
        Schema schema = schemaFactory.newSchema(xsdFile);

        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new File(xmlPath)));
        return true;
    }
    
    private DOCUMENT getXmlToObject(String xmlPath) throws Exception {
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(DOCUMENT.class);             
     
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
     
        DOCUMENT doc = (DOCUMENT)jaxbUnmarshaller.unmarshal(new File(xmlPath));
         
        System.out.println(doc); 
        return doc;
    }
    
    private String getXmlString(JAXBElement<?> elm) {
        StringWriter sw = new StringWriter();
        JAXB.marshal(elm, sw);
        String xmlString = sw.toString();
        return xmlString;
    }
}
