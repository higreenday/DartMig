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
@Table(name="TB_PA_DART_DOC_INST") 
public class DartTbPaDartDocInstEntity implements Serializable {

    @Id
    @Column(name="insertion_sn")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TB_PA_DART_DOC_INST")
    @SequenceGenerator(name="SEQ_TB_PA_DART_DOC_INST", sequenceName="SEQ_TB_PA_DART_DOC_INST") 
    private int insertionSn;
    
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 
 
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;
 
    @Column(name="pblntf_data_sn")
    private int pblntfDataSn; 
 
    @Column(name="atch_file_sn")
    int atchFileSn; 
    
    @Column(name="p_insertion_sn")
    private int pInsertionSn; 
 
    @Column(name="p_lib_sn")
    private int pLibSn; 
 
    @Column(name="p_part_sn")
    private int pPartSn; 
 
    @Column(name="p_section_sn")
    private int pSectionSn; 
    
    @Column(name="abasisnumber") 
    private String abasisnumber; 
    
    @Column(name="afrequency") 
    private String afrequency; 

    @Column(name="aduplication", length=1, columnDefinition="CHAR")
    private String aduplication;
    
    @Column(name="icomment") 
    private String icomment; 
    
    @Column(name="librarylist") 
    private String librarylist; 
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
