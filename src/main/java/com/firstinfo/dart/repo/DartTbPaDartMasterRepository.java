package com.firstinfo.dart.repo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.firstinfo.dart.entity.DartTbPaDartMasterEntity;
import com.firstinfo.dart.entity.DartTbPaDartMasterEntityPK;
import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;

public interface DartTbPaDartMasterRepository extends JpaRepository<DartTbPaDartMasterEntity, DartTbPaDartMasterEntityPK> {
    
    @Query(value = "select nvl(max(pblntf_data_sn),0) + 1 as next_sn "
                 + "  from TB_PA_DART_MASTR t1"
                 + " where t1.jurirno = ?1"
                 + "   and t1.data_se_code = ?2", nativeQuery = true)
    public Integer getNextPblntfDataSn(String jurirno, String dataSeCode);
}
