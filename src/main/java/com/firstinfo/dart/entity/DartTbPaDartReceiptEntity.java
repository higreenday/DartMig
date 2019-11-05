

package com.firstinfo.dart.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity.DartTbPaDartMigHistEntityBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_PA_DART_RECEIPT")
@IdClass(DartTbPaDartReceiptEntityPK.class)
public class DartTbPaDartReceiptEntity implements Serializable {

    @Id
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 

    @Id
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;

    @Id
    @Column(name="pblntf_data_sn")
    int pblntfDataSn;
    
    @Column(name="presentn_se", length=1, nullable=false, columnDefinition="CHAR")
    String presentnSe;
    
    @Column(name="job_begin_no")
    private String jobBeginNo;
    
    @Column(name="rcept_no")
    private String rceptNo;
    
    @Column(name="reach_no")
    private String reachNo;
    
    @Column(name="job_code")
    private String jobCode;
    
    @Column(name="report_code")
    private String reportCode;
     
    @Column(name="pblntf_trget_cmpny_esntl_no") 
    private String pblntfTrgetCmpnyEsntlNo;
 
    @Column(name="presentn_esntl_no") 
    private String presentnEsntlNo; 
 
    @Column(name="rcept_dt") 
    private String rceptDt; 
 
    @Column(name="updt_trget_rcept_dt") 
    private String updtTrgetRceptDt; 
    
    @Column(name="today_rcept_se", length=1, nullable=false, columnDefinition="CHAR")
    String todayRceptSe;
    
    @Column(name="cdpny_pblntf_se", length=1, nullable=false, columnDefinition="CHAR")
    String cdpnyPblntfSe;
 
    @Column(name="adit_reprt_nm") 
    private String aditReprtNm; 
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
 
}