package com.firstinfo.dart.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_PA_DART_DOC")
@IdClass(DartTbPaDartDocEntityPK.class)
public class DartTbPaDartDocEntity implements Serializable {

    @Id
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 

    @Id
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;

    @Id
    @Column(name="pblntf_data_sn")
    int pblntfDataSn;

    @Id
    @Column(name="atch_file_sn")
    int atchFileSn;
 
    @Column(name="reprt_ty", length=1, columnDefinition="CHAR") 
    private String reprtTy;
    
    @Column(name="pblntf_cmpny_esntl_no")
    private String pblntfCmpnyEsntlNo;
 
    @Column(name="refrn_at", length=1, columnDefinition="CHAR")
    private String refrnAt;
    
    @Column(name="refrn_rcept_no")
    private String refrnRceptNo;
    
    @Column(name="cnnc_at", length=1, columnDefinition="CHAR")
    private String cnncAt;
    
    @Column(name="bsns_year")
    private String bsnsYear;
 
    @Column(name="doc_code") 
    private String docCode;
 
    @Column(name="file_nm") 
    private String fileNm;
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        
}

