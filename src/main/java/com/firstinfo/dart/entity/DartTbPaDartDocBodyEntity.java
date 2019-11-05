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
@Table(name="TB_PA_DART_DOC_BODY")
@IdClass(DartTbPaDartDocBodyEntityPK.class)
public class DartTbPaDartDocBodyEntity implements Serializable {
 
    @Id
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 

    @Id
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;

    @Id
    @Column(name="pblntf_data_sn")
    int pblntfDataSn; 
    
    @Column(name="pbrbk")
    private String pbrbk;
    
    @Column(name="pbrbk_anumber")
    private String pbrbkAnumber;
    
    @Column(name="cover_title")
    private String coverTitle;
    
    @Column(name="cover_title_aclass")
    private String coverTitleAclass;
    
    @Column(name="cover_title_atoc")
    private String coverTitleAtoc;
    
    @Column(name="cover_title_aassocnote")
    private String coverTitleAassocnote;
    
    @Column(name="cover_title_aunit")
    private String coverTitleAunit;
    
    @Column(name="cover_title_aunitvalue")
    private String coverTitleAunitvalue;
    
    @Column(name="correction_sn")
    private int correctionSn;
    
    @Column(name="cover_title_pgbrk")
    private String coverTitlePgbrk;
    
    @Column(name="cover_title_pgbrk_anumber")
    private String coverTitlePgbrkAnumber;
    
    @Column(name="toc_title")
    private String tocTitle;
    
    @Column(name="toc_title_aclass")
    private String tocTitleAclass;
    
    @Column(name="toc_title_atoc")
    private String tocTitleAtoc;
    
    @Column(name="toc_title_aassocnote")
    private String tocTitleAassocnote;
    
    @Column(name="toc_title_aunit")
    private String tocTitleAunit;
    
    @Column(name="toc_title_aunitvalue")
    private String tocTitleAunitvalue;
    
    @Column(name="toc_pgbrk")
    private String tocPgbrk;
    
    @Column(name="toc_pgbrk_anumber")
    private String tocPgbrkAnumber;
    
    @Column(name="appendix_atype")
    private String appendixAtype;
    
    @Column(name="appendix_comment")
    private String appendixComment;
     
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
