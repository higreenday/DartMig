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
@Table(name="TB_PA_DART_INST") 
public class DartTbPaDartInstEntity implements Serializable {

    @Id
    @Column(name="insertion_sn")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PA_DART_INST_SEQ")
    @SequenceGenerator(name="TB_PA_DART_INST_SEQ", sequenceName="TB_PA_DART_INST_SEQ") 
    private int insertionSn;
    
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 
 
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;
 
    @Column(name="pblntf_data_sn")
    int pblntfDataSn;
    
    @Column(name="insertion_se_code") 
    private String insertionSeCode; 
    
    @Column(name="insertion_abasisnumber") 
    private String insertionAbasisnumber; 
    
    @Column(name="insertion_afrequency") 
    private String insertionAfrequency; 

    @Column(name="insertion_aduplication", length=1, columnDefinition="CHAR")
    private String insertionAduplication;
    
    @Column(name="insertion_comment") 
    private String insertionComment; 
    
    @Column(name="insertion_labrarylist") 
    private String insertionLabrarylist; 
    
    @Column(name="aid") 
    private String aid; 
    
    @Column(name="aclass") 
    private String aclass; 
    
    @Column(name="apartsource") 
    private String apartsource; 
    
    @Column(name="apartinfo") 
    private String apartinfo; 
     
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
