package com.firstinfo.dart.repo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.firstinfo.dart.entity.DartTbPaDartMigHistEntity;
import com.firstinfo.dart.entity.DartTbPaDartReceiptEntity;
import com.firstinfo.dart.entity.DartTbPaDartReceiptEntityPK;

public interface DartTbPaDartReceiptRepository extends JpaRepository<DartTbPaDartReceiptEntity, DartTbPaDartReceiptEntityPK> {

}
