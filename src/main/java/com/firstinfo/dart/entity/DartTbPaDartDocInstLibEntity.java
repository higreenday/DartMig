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
@Table(name="TB_PA_DART_DOC_INST_LIB") 
public class DartTbPaDartDocInstLibEntity implements Serializable {

    @Id
    @Column(name="lib_sn")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TB_PA_DART_DOC_INST_LIB")
    @SequenceGenerator(name="SEQ_TB_PA_DART_DOC_INST_LIB", sequenceName="SEQ_TB_PA_DART_DOC_INST_LIB") 
    private int libSn;
    
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 
 
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;
 
    @Column(name="pblntf_data_sn")
    private int pblntfDataSn; 
 
    @Column(name="content_sn")
    private int contentSn; 
    
    @Column(name="correction_content_sn") 
    private int correctionContentSn; 

    @Column(name="aid")
    private String aid;
    
    @Column(name="aclass")
    private String aclass;
    
    @Column(name="apartsource")
    private String apartsource;
    
    @Column(name="apartinfo")
    private String apartinfo;

    @Column(name="p_insertion_sn")
    private int pInsertionSn; 
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
