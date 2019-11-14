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
@Table(name="TB_PA_DART_DOC_PART") 
public class DartTbPaDartDocPartEntity implements Serializable {

    @Id
    @Column(name="part_sn")
    int partSn; 
     
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 
 
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;
 
    @Column(name="pblntf_data_sn")
    private int pblntfDataSn; 
 
    @Column(name="atch_file_sn")
    int atchFileSn; 
    
    @Column(name="p_lib_sn")
    private int pLibSn; 
    
    @Column(name="aid")
    private String aid;
    
    @Column(name="aclass")
    private String aclass;
    
    @Column(name="apartsource")
    private String apartsource;
    
    @Column(name="apartinfo")
    private String apartinfo;
 
    @Column(name="content_sn")
    private int contentSn;  
     
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
