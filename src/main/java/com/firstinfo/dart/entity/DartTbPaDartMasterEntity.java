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
@Table(name="TB_PA_DART_MASTR")
@IdClass(DartTbPaDartMasterEntityPK.class)
public class DartTbPaDartMasterEntity implements Serializable {
 
    @Id
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 

    @Id
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;

    @Id
    @Column(name="pblntf_data_sn")
    int pblntfDataSn;
 
    @Column(name="mig_hist_sn") 
    private int migHistSn;
    
    @Column(name="send_de")
    private String sendDe;

    @Id
    @Column(name="data_sn") 
    private String dataSn;
    
    @Column(name="mrkt_se", length=1, nullable=false, columnDefinition="CHAR")
    private String mrktSe;
    
    @Column(name="pblntf_ty", length=1, columnDefinition="CHAR")
    private String pblntfTy;
 
    @Column(name="reach_no") 
    private String reachNo;
 
    @Column(name="report_code") 
    private String reportCode;
    
    @Column(name="regist_dt")
    private java.time.LocalDateTime registDt = LocalDateTime.now();
        

}
