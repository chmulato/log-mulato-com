package com.mulato.log.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulato.log.model.Log;
import com.mulato.log.repository.LogRepository;

@Service
public class LogService {

	final private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	@Autowired
	private LogRepository logRepository;

	public List<Log> listAll() {
		return logRepository.findAll();
	}

	public void save(Log log) {
		logRepository.save(log);
	}
	
	public Log getLog(Log log) {
		return logRepository.findOne(log.getId());
	}

	public Timestamp converterTimestamp(String startDate) {
		Timestamp result = null;
		try {
	        Date data = formatter.parse(startDate);
	        result = new java.sql.Timestamp(data.getTime());
	    } catch (ParseException ex) {
	        ex.printStackTrace();
	    }
		return result;
	}
	
	public List<Log> orderList(List<Log> list) {
		List<Log> orders = list;
		Comparator<Log> comparator = (o1, o2) -> o1.getIp().compareTo(o2.getIp());
		comparator.thenComparing((o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
		orders.sort(comparator);
		return orders;
	}
}	
	
