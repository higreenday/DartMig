package com.firstinfo.dart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstinfo.dart.entity.DartTbPaDartDocHeaderEntity;
import com.firstinfo.dart.entity.DartTbPaDartDocHeaderEntityPK;

public interface DartTbPaDartDocHeaderRepository extends JpaRepository<DartTbPaDartDocHeaderEntity, DartTbPaDartDocHeaderEntityPK> {
    
}
