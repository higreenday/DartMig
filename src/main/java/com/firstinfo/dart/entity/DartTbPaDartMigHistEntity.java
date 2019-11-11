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
@Table(name="TB_PA_DART_MIG_HIST")
public class DartTbPaDartMigHistEntity implements Serializable {

        @Id
        @Column(name="mig_hist_sn")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TB_PA_DART_MIG_HIST")
        @SequenceGenerator(name="SEQ_TB_PA_DART_MIG_HIST", sequenceName="SEQ_TB_PA_DART_MIG_HIST") 
        private int migHistSn;
        
        @Column(name="mig_se_code", length=1, nullable=false, columnDefinition="CHAR")
        private String migSeCode;
        
        @Column(name="data_se_code", length=1, nullable=false, columnDefinition="CHAR")
        private String dataSeCode;
        
        @Column(name="recptn_pblntf_name")
        private String recptnPblntfName;
        
        @Column(name="mig_result_code", length=1, nullable=false, columnDefinition="CHAR")
        private String migResultCode;
        
        @Column(name="error_cn", columnDefinition="CLOB")
        private String errorCn;
        
        @Column(name="regist_dt")
        private java.time.LocalDateTime registDt;
        

        @Builder
        public DartTbPaDartMigHistEntity(String migSeCode, String dataSeCode, String migResultCode) {
            this.migSeCode = migSeCode;
            this.dataSeCode = dataSeCode;
            this.migResultCode = migResultCode;
            this.registDt = LocalDateTime.now();
        }
}
