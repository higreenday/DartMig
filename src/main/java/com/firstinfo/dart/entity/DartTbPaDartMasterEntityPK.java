package com.firstinfo.dart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

@Data
public class DartTbPaDartMasterEntityPK implements Serializable {

    @Id
    @Column(name="jurirno", length=13, nullable=false) 
    private String jurirno; 

    @Id
    @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
    private String dataSeCode;

    @Id
    @Column(name="pblntf_data_sn")
    int pblntfDataSn;
}