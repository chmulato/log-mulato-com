package com.mulato.log.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mulato.log.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

	@Query(value="SELECT l FROM Log l WHERE l.startDate BETWEEN ?1 AND ?2 ORDER BY l.ip, l.startDate")
	List<Log> getListBetweenPeriodOrderByIpAndStartDate(Timestamp beginDate, Timestamp endDate);
	
	@Query(value="SELECT l FROM Log l ORDER BY l.ip, l.startDate")
	List<Log> getListAll();
	
}