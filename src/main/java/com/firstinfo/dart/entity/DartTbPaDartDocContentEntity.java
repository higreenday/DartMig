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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PA_DART_DOC_CONTENT_SEQ")
    @SequenceGenerator(name="TB_PA_DART_DOC_CONTENT_SEQ", sequenceName="TB_PA_DART_DOC_CONTENT_SEQ") 
    private int contentSn;
     
    @Column(name="title")
    private String title;

    @Column(name="content", columnDefinition="CLOB")
    private String content;
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
