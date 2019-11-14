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
public class DartTbPaDartDocHeaderSumyEntityPK implements Serializable {
 
    @Id
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 

    @Id
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;

    @Id
    @Column(name="pblntf_data_sn")
    int pblntfDataSn;

    @Id
    @Column(name="atch_file_sn")
    int atchFileSn; 
    
    @Id
    @Column(name="summary_sn")
    int summarySn;
 
}
