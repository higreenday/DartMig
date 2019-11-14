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
@IdClass(DartTbPaDartDocHeaderSumyEntityPK.class)
public class DartTbPaDartDocHeaderSumyEntity implements Serializable {
 
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
    
    @Id
    @Column(name="summary_sn")
    int summarySn;
    
    @Column(name="extraction")
    private String extraction;
    
    @Column(name="acode")
    private String acode;
    
    @Column(name="afeature")
    private String afeature;
      
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
