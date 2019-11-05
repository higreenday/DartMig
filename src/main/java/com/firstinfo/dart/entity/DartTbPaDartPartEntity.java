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
@Table(name="TB_PA_DART_PART") 
public class DartTbPaDartPartEntity implements Serializable {

    @Id
    @Column(name="part_sn")
    int partSn; 
     
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 
 
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;
 
    @Column(name="pblntf_data_sn")
    int pblntfDataSn; 
    
    @Column(name="part_se_code")
    private String partSeCode;
    
    @Column(name="aid")
    private String aid;
    
    @Column(name="aclass")
    private String aclass;
    
    @Column(name="apartsource")
    private String apartsource;
    
    @Column(name="apartinfo")
    private String apartinfo;
    
    @Column(name="title")
    private String title;
    
    @Column(name="title_aclass")
    private String titleAclass;
    
    @Column(name="title_atoc")
    private String titleAtoc;
    
    @Column(name="title_aassocnote")
    private String titleAassocnote;
    
    @Column(name="title_aunit")
    private String titleAunit;
    
    @Column(name="title_aunitvalue")
    private String titleAunitvalue;
    
    @Column(name="subtitle")
    private String subtitle;
     
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
