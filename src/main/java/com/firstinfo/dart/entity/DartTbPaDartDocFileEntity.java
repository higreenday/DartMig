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
@Table(name="TB_PA_DART_DOC_FILE") 
public class DartTbPaDartDocFileEntity implements Serializable {

    @Id
    @Column(name="file_sn")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TB_PA_DART_DOC_FILE")
    @SequenceGenerator(name="SEQ_TB_PA_DART_DOC_FILE", sequenceName="SEQ_TB_PA_DART_DOC_FILE") 
    private int insertionSn;
     
    @Column(name="p_lib_sn")
    int pLibSn;
    
    @Column(name="file_nm") 
    private String fileNm; 
    
    @Column(name="file_atype") 
    private String fileAtype; 
     
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
