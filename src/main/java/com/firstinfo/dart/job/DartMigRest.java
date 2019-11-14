package com.firstinfo.dart.job;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstinfo.dart.CD;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.exception.CustException;
import com.firstinfo.dart.lib.Util;
import com.firstinfo.dart.repo.DartTbPaDartMigHistRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@RestController
public class DartMigRest {
    
    @Autowired
    DartMig dartMig;

    @Autowired
    DartTbPaDartMigHistRepository dartTbPaDartMigHistRepository;
    
    // 감사보고서
    @Value("${com.first.dart.path.audit.receive}")
    private String dartReceiveAuditPath;

    @Value("${com.first.dart.path.audit.receive_err}")
    private String dartReceiveErrAuditPath;

    @Value("${com.first.dart.path.audit.receive_ok}")
    private String dartReceiveOkAuditPath;

    @Value("${com.first.dart.path.audit.receive_ok_ext}")
    private String dartReceiveOkExtAuditPath;
    
    // 사업보고서
    @Value("${com.first.dart.path.business.receive}")
    private String dartReceiveBusinessPath;

    @Value("${com.first.dart.path.business.receive_err}")
    private String dartReceiveErrBusinessPath;

    @Value("${com.first.dart.path.business.receive_ok}")
    private String dartReceiveOkBusinessPath;

    @Value("${com.first.dart.path.business.receive_ok_ext}")
    private String dartReceiveOkExtBusinessPath;
    
    // 공시
    @Value("${com.first.dart.path.pub.receive}")
    private String dartReceivePubPath;

    @Value("${com.first.dart.path.pub.receive_err}")
    private String dartReceiveErrPubPath;

    @Value("${com.first.dart.path.pub.receive_ok}")
    private String dartReceiveOkPubPath;

    @Value("${com.first.dart.path.pub.receive_ok_ext}")
    private String dartReceiveOkExtPubPath;

    @Value("${com.first.dart.prod}")
    private String isProdYn;
    
    /**
     * post로 2개의 파라미터를 받아 처리함
     * zip_path, mig_se_code
     * @param request
     * @param response
     */
    @PostMapping("/api/v1/rest/dart_mig")
    public void dartMig(HttpServletRequest request, HttpServletResponse response) { 
        String zipPath = cleanXSS(request.getParameter("zip_path"));        // 압축파일 경로
        String migSeCode = cleanXSS(request.getParameter("mig_se_code"));   // A : 감사보고서, B : 사업보고서, P : 공시
        
        String dartReceivePath = "";
        String dartReceiveOkPath = ""; 
        String dartReceiveOkExtPath = ""; 
        String dartReceiveErrPath  = "";
        
        String migSeGbn = "";
        JsonObject jsonObj = new JsonObject();
        try {
            if (migSeCode.equals("A")) {
                migSeGbn = "AUDIT";
                dartReceivePath = dartReceiveAuditPath;
                dartReceiveOkPath = dartReceiveOkAuditPath;
                dartReceiveOkExtPath = dartReceiveOkExtAuditPath; 
                dartReceiveErrPath  = dartReceiveErrAuditPath;
            } else if (migSeCode.equals("B")) {
                migSeGbn = "BUSINESS";
                dartReceivePath = dartReceiveBusinessPath;
                dartReceiveOkPath = dartReceiveOkBusinessPath;
                dartReceiveOkExtPath = dartReceiveOkExtBusinessPath; 
                dartReceiveErrPath  = dartReceiveErrBusinessPath;
            } else if (migSeCode.equals("P")) {
                migSeGbn = "PUB";
                dartReceivePath = dartReceivePubPath;
                dartReceiveOkPath = dartReceiveOkPubPath;
                dartReceiveOkExtPath = dartReceiveOkExtPubPath; 
                dartReceiveErrPath  = dartReceiveErrPubPath;
            } else {
                throw new Exception("유효하지 않은 mig_se_code");
            }
            
            String copyFilePath = dartReceivePath + "/" + (new File(zipPath)).getName();
            FileUtils.copyFile(new File(zipPath), new File(copyFilePath));
            File receiveFile = new File(copyFilePath);
            String extractFolderNm = receiveFile.getName().substring(0, receiveFile.getName().indexOf("."));
            DartTbPaDartMigHistEntity histEnt = new DartTbPaDartMigHistEntity("R",migSeCode,"S");
            
            try {
                CD.bizlog.info(migSeGbn + " REST MIG START : " + receiveFile.getName());
                
                // 마이그레이션 시작 디비 저장
                DartUnzipEntity dartUnzipEntity = Util.getDartEntity(migSeCode, receiveFile);
                dartUnzipEntity.validate(); 
                histEnt.setRecptnPblntfName(receiveFile.getName());
                dartTbPaDartMigHistRepository.save(histEnt);
                
                dartMig.mig(dartUnzipEntity, histEnt);
                
                histEnt.setMigResultCode("1");
                if (isProdYn.equals("Y")) {
                    FileUtils.moveFile(receiveFile, new File(dartReceiveOkPath + "/" + receiveFile.getName()));
                    FileUtils.moveDirectory(new File(dartReceivePath + "/" + extractFolderNm), new File(dartReceiveOkExtPath + "/" + extractFolderNm));
                }
                CD.bizlog.info(migSeGbn + " REST MIG SUCCESS : " + receiveFile.getName());
                jsonObj.addProperty("isOk", "Y");
            } catch (CustException ex) {
                histEnt.setMigResultCode("0");
                histEnt.setErrorCn(ExceptionUtils.getFullStackTrace(ex));
                CD.bizlog.info(migSeGbn + " REST MIG ERROR : " + receiveFile.getName() +"\n" + ExceptionUtils.getFullStackTrace(ex));
                if (isProdYn.equals("Y")) {
                    FileUtils.moveFile(receiveFile, new File(dartReceiveErrPath + "/" + receiveFile.getName()));
                    FileUtils.deleteDirectory(new File(dartReceivePath + "/" + extractFolderNm));
                }
                jsonObj.addProperty("isOk", "N");
                jsonObj.addProperty("errMsg", ex.getMessage());
            } catch (Exception ex) {
                histEnt.setMigResultCode("0");
                histEnt.setErrorCn(ExceptionUtils.getFullStackTrace(ex));
                CD.bizlog.info(migSeGbn + " REST MIG ERROR : " + receiveFile.getName() +"\n" + ExceptionUtils.getFullStackTrace(ex));
                if (isProdYn.equals("Y")) {
                    FileUtils.moveFile(receiveFile, new File(dartReceiveErrPath + "/" + receiveFile.getName()));
                    FileUtils.deleteDirectory(new File(dartReceivePath + "/" + extractFolderNm));
                }
                jsonObj.addProperty("isOk", "N");
                jsonObj.addProperty("errMsg", ex.getMessage());
            } finally { 
                // 마이그레이션 결과 디비 저장
                dartTbPaDartMigHistRepository.save(histEnt);
            }
        } catch (Exception e) {
            CD.bizlog.error(ExceptionUtils.getFullStackTrace(e));
        } finally {
            try {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                response.setStatus(200);
                response.setContentType("text/html;charset=utf-8");
                response.setContentType("application/json");
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
                PrintWriter pr = response.getWriter();

                pr.write(gson.toJson(jsonObj));
                pr.close();
            } catch (IOException ex) {
                CD.bizlog.info(migSeGbn + " REST MIG ERROR :" + ExceptionUtils.getFullStackTrace(ex));
            } 
        }
    }
    

    private String cleanXSS(String value) {
        if (value == null) {
            return "";
        } else {
            value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
            value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
            value = value.replaceAll("'", "& #39;");
            value = value.replaceAll("eval\\((.*)\\)", "");
            value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
            value = value.replaceAll("script", "");
            return value;
        }
    }
}
