package com.firstinfo.dart.repo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;

public interface DartTbPaDartMigHistRepository extends JpaRepository<DartTbPaDartMigHistEntity, Integer> {

}
