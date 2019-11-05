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
@Table(name="TB_PA_DART_DOC_HEADER")
@IdClass(DartTbPaDartDocHeaderEntityPK.class)
public class DartTbPaDartDocHeaderEntity implements Serializable {
 
    @Id
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 

    @Id
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;

    @Id
    @Column(name="pblntf_data_sn")
    int pblntfDataSn;
    
    @Column(name="aext_class", length=1, columnDefinition="CHAR")
    private String aextClass;
    
    @Column(name="document_name")
    private String documentName;
    
    @Column(name="document_name_acode")
    private String documentNameAcode;
    
    @Column(name="fomula_version")
    private String fomulaVersion;
    
    @Column(name="fomula_version_adate")
    private String fomulaVersionAdate;
    
    @Column(name="fomula_version_subver")
    private String fomulaVersionSubver;
    
    @Column(name="company_name")
    private String companyName;
    
    @Column(name="company_name_aregcik")
    private String companyNameAregcik;
    
    @Column(name="companyname_aaccounttype")
    private String companynameAaccounttype;
    
    @Column(name="extraction")
    private String extraction;
    
    @Column(name="extraction_acode")
    private String extractionAcode;
    
    @Column(name="extraction_afeature")
    private String extractionAfeature;
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
