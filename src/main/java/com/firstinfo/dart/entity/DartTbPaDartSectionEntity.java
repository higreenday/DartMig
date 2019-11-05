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
@Table(name="TB_PA_DART_SECTION") 
public class DartTbPaDartSectionEntity implements Serializable {


    @Id
    @Column(name="section_sn")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PA_DART_SECTION_SEQ")
    @SequenceGenerator(name="TB_PA_DART_SECTION_SEQ", sequenceName="TB_PA_DART_SECTION_SEQ") 
    private int sectionSn;
     
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 
 
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;
 
    @Column(name="pblntf_data_sn")
    int pblntfDataSn;
    
    @Column(name="section_code")
    private String sectionCode;
    
    @Column(name="section_se_code")
    private String sectionSeCode;
    
    @Column(name="upper_section_sn")
    private int upperSectionSn;
    
    @Column(name="content_sn")
    private int contentSn;
    
    @Column(name="section_aid")
    private String sectionAid;
    
    @Column(name="section_aclass")
    private String sectionAclass;
    
    @Column(name="section_apartsource")
    private String sectionApartsource;
    
    @Column(name="section_apartinfo")
    private String sectionApartinfo;
    
    @Column(name="section_content_sn")
    private int sectionContentSn;
    
    @Column(name="section_pgbrk")
    private String sectionPgbrk;
    
    @Column(name="section_pgbrk_anumber")
    private String sectionPgbrkAnumber; 
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
