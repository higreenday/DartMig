package com.firstinfo.dart.entity;

import java.io.File;
import java.util.ArrayList;

import javax.persistence.Entity;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.firstinfo.dart.exception.CustException;
import com.mchange.io.FileUtils;
 
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString 
public class DartUnzipEntity {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger("biz");

    String fileNm;
    String dataSeCode;
    String sendDe;
    String dataSn;
    String mrktSe;
    String pblntfTy;
    String reachNo;
    String reportCode;
    
    String receiptPresentnSe;
    String receiptJobBeginNo;
    String receiptRceptNo; 
    String receiptReachNo;
    String receiptJobCode;
    String receiptReportCode;
    String receiptPblntfTrgetCmpnyEsntlNo;
    String receiptJurirno;
    String receiptPresentnEsntlNo;
    String receiptRceptDt;
    String receiptUpdtTrgetRceptDt;
    String receiptTodayRceptSe;
    String receiptCdpnyPblntfSe;
    String receiptAditReprtNm;
    
    String dirPath;
    File[] files;
    String mainXmlFileNm;
    
    public DartUnzipEntity(String dataSeCode, File[] files, String dirPath) throws Exception {
        this.dataSeCode = dataSeCode;
        this.fileNm = (new File(dirPath)).getName();
        this.sendDe = fileNm.substring(0,8).trim();
        this.dataSn = fileNm.substring(8,13).trim();
        this.mrktSe = fileNm.substring(13,14).trim();
        this.pblntfTy = fileNm.substring(14,15).trim();
        this.reachNo = fileNm.substring(15,29).trim();
        this.reportCode = fileNm.substring(29,34).trim();
        
        this.files = files;
        this.dirPath = dirPath;
        if (log.isDebugEnabled()) {
            try {
                for (File f : getFiles()) {
                    log.debug(f.getAbsolutePath());
                }
                log.debug(getDocumentCont());
                log.debug(getReceiptCont());
            } catch (Exception ex) {
                log.debug(ExceptionUtils.getMessage(ex));
            }
        }
        
        String receptCont = this.getReceiptCont();
        this.receiptPresentnSe = receptCont.substring(0,1).trim();
        this.receiptJobBeginNo = receptCont.substring(1,15).trim();
        this.receiptRceptNo = receptCont.substring(15,29).trim();
        this.receiptReachNo = receptCont.substring(29,43).trim();
        this.receiptJobCode = receptCont.substring(43,48).trim();
        this.receiptReportCode = receptCont.substring(48,53).trim();
        this.receiptPblntfTrgetCmpnyEsntlNo = receptCont.substring(53,61).trim();
        this.receiptJurirno = receptCont.substring(61,74).trim();
        this.receiptPresentnEsntlNo = receptCont.substring(74,82).trim();
        this.receiptRceptDt = receptCont.substring(82,96).trim();
        this.receiptUpdtTrgetRceptDt = receptCont.substring(96,110).trim();
        this.receiptTodayRceptSe = receptCont.substring(110,111).trim();
        this.receiptCdpnyPblntfSe = receptCont.substring(111,112).trim();
        this.receiptAditReprtNm = receptCont.substring(112).trim();
        
        getDocumentFileList();
        
    }
    
    public File[] getFiles() {
        return files;
    }
    
    public File getMainXmlFile() {
        File f = null;
        for(File file : files) {
            if (file.getName().toLowerCase().equals(mainXmlFileNm.toLowerCase())) {
                f = file;
            }
        }
        return f;
    }
    
    public File getDocumentFile() {
        File f = null;
        for(File file : files) {
            if (file.getName().toLowerCase().equals("document")) {
                f = file;
            }
        }
        return f;
    }
    
    public File getReceiptFile() {
        File f = null;
        for(File file : files) {
            if (file.getName().toLowerCase().equals("receipt")) {
                f = file;
            }
        }
        return f;
    }
    
    public String getDocumentCont() throws Exception {
        
        return FileUtils.getContentsAsString(getDocumentFile(), "EUC-KR");
    }
    
    public String getReceiptCont() throws Exception {
        
        return FileUtils.getContentsAsString(getReceiptFile(), "EUC-KR");
    }
    
    public String getXmlCont() throws Exception {
        
        return FileUtils.getContentsAsString(getMainXmlFile(), "UTF-8");
    }
    
    public  int getDocumentFileCnt() throws CustException {
        int fileCnt = 0;
        try {
            String cont = getDocumentCont();
            String[] contArr = cont.split("\n");
            if (contArr.length >= 2) {
                fileCnt = Integer.parseInt(contArr[0].trim());
            }
        } catch (NumberFormatException ex) {
            throw new CustException("document 파일 갯수 오류");
        } catch (Exception ex) {
            log.error(ExceptionUtils.getMessage(ex));
        }
        return fileCnt;
    }
    
    public  ArrayList<String> getDocumentFileList() throws CustException {
        ArrayList<String> fileList = new ArrayList<String>();
        try {
            String cont = getDocumentCont();
            String[] contArr = cont.split("\n");
            if (contArr.length >= 2) {
                for(int i=1; i < contArr.length; i++) {
                    String[] fileArr = contArr[i].split("/");
                    fileList.add(fileArr[fileArr.length-1]);
                    if (fileArr[0].trim().equals("M")) {
                        mainXmlFileNm = fileArr[fileArr.length-1].trim();
                    }
                }
            }
        } catch (NumberFormatException ex) {
            throw new CustException("document 파일 갯수 오류");
        } catch (Exception ex) {
            log.error(ExceptionUtils.getMessage(ex));
        }
        return fileList;
    }
    
    public boolean validate() throws CustException{
        boolean rtn = false;
        if (getDocumentFile().exists() == false) {
            throw new CustException("document file이 없습니다.");
        } else if (getReceiptFile().exists() == false) {
            throw new CustException("receipt file이 없습니다.");
        } else if (getMainXmlFile().exists() == false) {
            throw new CustException("xml file이 없습니다.");
        } 
        
        int fileCnt = getDocumentFileCnt();
        if (fileCnt < 1) {
            throw new CustException("document 파일 갯수 오류");
        }
        ArrayList<String> docFileList = getDocumentFileList();
        for(String docFile : docFileList) { 
            if ((new File(dirPath + "/" + docFile)).exists() == false) {
                log.debug(docFile + "/" + docFile);
                throw new CustException(String.format("document [%s] file을 찾을 수 없습니다.", docFile));
            }
        }
        return rtn;
    }
}
