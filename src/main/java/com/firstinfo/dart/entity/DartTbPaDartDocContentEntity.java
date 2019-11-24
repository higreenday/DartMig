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
@Table(name="TB_PA_DART_DOC_CONTENT")
public class DartTbPaDartDocContentEntity implements Serializable {

    @Id
    @Column(name="content_sn")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TB_PA_DART_DOC_CONTENT")
    @SequenceGenerator(name="SEQ_TB_PA_DART_DOC_CONTENT", sequenceName="SEQ_TB_PA_DART_DOC_CONTENT") 
    private int contentSn;
 
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 
 
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;
 
    @Column(name="pblntf_data_sn")
    int pblntfDataSn; 
 
    @Column(name="atch_file_sn")
    int atchFileSn; 
    
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
    
    @Column(name="pgbrk")
    private String pgbrk;
    
    @Column(name="pgbrk_anumber")
    private String pgbrkAnumber;

    @Column(name="content", length=365600, columnDefinition="CLOB")
    @Lob
    private String content;
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
