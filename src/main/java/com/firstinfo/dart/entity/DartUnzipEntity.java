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
    String receiptJobName;
    String receiptReportCode;
    String receiptReportName;
    String receiptPblntfTrgetCmpnyEsntlNo;
    String receiptJurirno;
    String receiptCompanyName;
    String receiptPresentnName;
    String receiptPresentnEsntlNo;
    String receiptRceptDt;
    String receiptUpdtTrgetRceptDt;
    String receiptTodayRceptSe;
    String receiptCdpnyPblntfSe;
    String receiptAditReprtNm;
    
    String dirPath;
    File[] files;
    String mainXmlFileNm;
    
    ArrayList<String> xmlFiles = new ArrayList<String>();
    
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
        if (receptCont.indexOf("||") > 0) {
            String[] receptArr = receptCont.split("\\|\\|");
            this.receiptPresentnSe = receptArr[0];                  // 제출구분
            this.receiptJobBeginNo = receptArr[1];                  // 업무시작번호
            this.receiptRceptNo = receptArr[2];                  // 접수번호
            this.receiptReachNo = receptArr[3];                  // 도달번호
            this.receiptJobCode = receptArr[4];                  // 업무코드
            this.receiptJobName = receptArr[5];                  // 업무명
            this.receiptReportCode = receptArr[6];                  // 보고서코드
            this.receiptReportName = receptArr[7];                  // 보고서명
            this.receiptPblntfTrgetCmpnyEsntlNo = receptArr[8];                  // 공시대상회사 고유번호
            this.receiptJurirno = receptArr[9];                  // 법인등록번호
            this.receiptCompanyName = receptArr[10];                  // 회사명
            this.receiptPresentnName = receptArr[11];                  // 제출인명
            this.receiptRceptDt = receptArr[12];                  // 접수일시
            this.receiptUpdtTrgetRceptDt = receptArr[13];                  // 정정대상 접수번호
            this.receiptTodayRceptSe = receptArr[14];                  // 당일접수여부
            this.receiptCdpnyPblntfSe = receptArr[15];                  // 자회사공시여부
            if (receptArr.length > 16) {
                this.receiptAditReprtNm = receptArr[16];                  // 추가보고서명
            }

        } else {
            this.receiptPresentnSe = receptCont.substring(0,1).trim();                      // 제출구분
            this.receiptJobBeginNo = receptCont.substring(1,15).trim();                     // 업무시작번호
            this.receiptRceptNo = receptCont.substring(15,29).trim();                       // 접수번호
            this.receiptReachNo = receptCont.substring(29,43).trim();                       // 도달번호
            this.receiptJobCode = receptCont.substring(43,48).trim();                       // 업무코드
            this.receiptReportCode = receptCont.substring(48,53).trim();                    // 보고서코드
            this.receiptPblntfTrgetCmpnyEsntlNo = receptCont.substring(53,61).trim();       // 공시대상회사 고유번호
            this.receiptJurirno = receptCont.substring(61,74).trim();                       // 법인등록번호
            this.receiptPresentnEsntlNo = receptCont.substring(74,82).trim();               // 제출인 고유번호
            this.receiptRceptDt = receptCont.substring(82,96).trim();                       // 접수일시
            this.receiptUpdtTrgetRceptDt = receptCont.substring(96,110).trim();             // 정정대상 접수번호
            this.receiptTodayRceptSe = receptCont.substring(110,111).trim();                // 당일접수여부
            this.receiptCdpnyPblntfSe = receptCont.substring(111,112).trim();               // 자회사공시여부
            this.receiptAditReprtNm = receptCont.substring(112).trim();                     // 추가보고서명
        }
        
        getDocumentFileList();
        
    }
    
    public File[] getFiles() {
        return files;
    }
    
    public File getMainXmlFile(int idx) {
        File f = null;
        for(File file : files) {
            if (file.getName().toLowerCase().equals(xmlFiles.get(idx).toLowerCase())) {
                f = file;
            }
        }
        return f;
    }
    
    public ArrayList<String> getXmlFiles() {
        return xmlFiles;
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
    
    public int getXmlCnt() {
        return xmlFiles.size();
    }
    
    public String getXmlCont(int idx) throws Exception { 
      return FileUtils.getContentsAsString(getMainXmlFile(idx), "UTF-8");
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
        xmlFiles.clear();
        try {
            String cont = getDocumentCont();
            String[] contArr = cont.split("\n");
            if (contArr.length >= 2) {
                for(int i=1; i < contArr.length; i++) {
                    String[] fileArr = contArr[i].split("/");
                    fileList.add(fileArr[7]);
                    if (fileArr[7].toLowerCase().endsWith("xml") && ( fileArr[0].trim().equals("M") || fileArr[0].trim().equals("A")) ) {
                        //mainXmlFileNm = fileArr[7].trim();
                        xmlFiles.add(fileArr[7]);
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
        } else if (xmlFiles == null || xmlFiles.size() == 0) {
            throw new CustException("xml file이 없습니다.");
//        } else if (getMainXmlFile().exists() == false) {
//            throw new CustException("xml file이 없습니다.");
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
