package com.firstinfo.dart.job;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.firstinfo.dart.CD;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartUnzipEntity;
import com.firstinfo.dart.exception.CustException;
import com.firstinfo.dart.lib.Util;
import com.firstinfo.dart.repo.DartTbPaDartMigHistRepository;

import lombok.extern.slf4j.Slf4j; 

@Slf4j
@Component
public class DartJob { 
    
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
    
    //@Scheduled(cron ="${com.first.dart.job_cron}")
    @Scheduled(fixedRateString ="${com.first.dart.job_period}", initialDelayString="${com.first.dart.job_delay}")
    public void run() {
        // 감사보고서
        DartFileMig("AUDIT", "A", dartReceiveAuditPath, dartReceiveOkAuditPath, dartReceiveOkExtAuditPath, dartReceiveErrAuditPath);
        
        // 사업보고서
        DartFileMig("BUSINESS", "B", dartReceiveBusinessPath, dartReceiveOkBusinessPath, dartReceiveOkExtBusinessPath, dartReceiveErrBusinessPath);
        
        // 공시
        DartFileMig("PUB", "P", dartReceivePubPath, dartReceiveOkPubPath, dartReceiveOkExtPubPath, dartReceiveErrPubPath);
    }
    
    public void DartFileMig(String migSeGbn, String migSeCode, String dartReceivePath, String dartReceiveOkPath, String dartReceiveOkExtPath, String dartReceiveErrPath) {
        try {
            
            // 파일 목록 조회
            File[] receiveFiles = (new File(dartReceivePath)).listFiles(new FilenameFilter() {     
                @Override 
                public boolean accept(File dir, String name) { 
                     return name.endsWith("zip"); 
                }
            });
 
            if (receiveFiles != null) {
                for(File receiveFile : receiveFiles) {
                    String extractFolderNm = receiveFile.getName().substring(0, receiveFile.getName().indexOf("."));
                    DartTbPaDartMigHistEntity histEnt = new DartTbPaDartMigHistEntity("C",migSeCode,"S");
                    try {
                        CD.bizlog.info(migSeGbn + " MIG START : " + receiveFile.getName());
                        
                        // 마이그레이션 시작 디비 저장
                        DartUnzipEntity dartUnzipEntity = Util.getDartEntity(migSeCode, receiveFile);
                        dartUnzipEntity.validate(); 
                        dartTbPaDartMigHistRepository.save(histEnt);
                        
                        dartMig.mig(dartUnzipEntity, histEnt);
                        
                        histEnt.setMigResultCode("1");
                        //FileUtils.moveFile(receiveFile, new File(dartReceiveOkPath + "/" + receiveFile.getName()));
                        //FileUtils.moveDirectory(new File(dartReceivePath + "/" + extractFolderNm), new File(dartReceiveOkExtPath + "/" + extractFolderNm));
                        CD.bizlog.info(migSeGbn + " MIG SUCCESS : " + receiveFile.getName());
                    } catch (CustException ex) {
                        histEnt.setMigResultCode("0");
                        histEnt.setErrorCn(ExceptionUtils.getFullStackTrace(ex));
                        CD.bizlog.info(migSeGbn + " MIG ERROR : " + receiveFile.getName() +"\n" + ExceptionUtils.getFullStackTrace(ex));
                        //FileUtils.moveFile(receiveFile, new File(dartReceiveErrPath + "/" + receiveFile.getName()));
                        //FileUtils.deleteDirectory(new File(dartReceivePath + "/" + extractFolderNm));
                    } catch (Exception ex) {
                        histEnt.setMigResultCode("0");
                        histEnt.setErrorCn(ExceptionUtils.getFullStackTrace(ex));
                        CD.bizlog.info(migSeGbn + " MIG ERROR : " + receiveFile.getName() +"\n" + ExceptionUtils.getFullStackTrace(ex));
                        //FileUtils.moveFile(receiveFile, new File(dartReceiveErrPath + "/" + receiveFile.getName()));
                        //FileUtils.deleteDirectory(new File(dartReceivePath + "/" + extractFolderNm));
                    } finally { 
                        // 마이그레이션 결과 디비 저장
                        dartTbPaDartMigHistRepository.save(histEnt);
                    }
                } 
            }
        } catch (Exception e) {
            CD.bizlog.error(ExceptionUtils.getFullStackTrace(e));
        }
    } 
    
} 
