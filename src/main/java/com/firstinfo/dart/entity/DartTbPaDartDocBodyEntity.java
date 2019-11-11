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
    
    @Column(name="correction_content_sn")
    private int correctionContentSn;
    
    @Column(name="cover_content_sn")
    private int coverContentSn;
    
    @Column(name="toc_content_sn")
    private int tocContentSn;
    
    @Column(name="content_sn")
    private int contentSn;
    
    @Column(name="appendix_atype")
    private String appendixAtype;
    
    @Column(name="appendix_comment")
    private String appendixComment;
     
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
