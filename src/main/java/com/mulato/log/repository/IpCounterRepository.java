package com.mulato.log.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mulato.log.model.IpCounter;
import com.mulato.log.model.Log;

public interface IpCounterRepository extends JpaRepository<Log, Long> {
	
	@Query(value = "SELECT new com.mulato.log.model.IpCounter(l.ip, count(l)) FROM Log l WHERE l.startDate BETWEEN ?1 AND ?2 GROUP BY l.ip")
	List<IpCounter> counterIpByDatePeriod(Timestamp beginDate, Timestamp endDate);


}
