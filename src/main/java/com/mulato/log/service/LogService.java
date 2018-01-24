package com.mulato.log.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulato.log.model.IpCounter;
import com.mulato.log.model.Log;
import com.mulato.log.repository.IpCounterRepository;
import com.mulato.log.repository.LogRepository;

@Service
public class LogService {

	final private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	@Autowired
	private LogRepository logRepository;

	@Autowired
	private IpCounterRepository ipCounterRepository;

	public List<Log> listAll() {
		return logRepository.findAll();
	}

	public void save(Log log) {
		logRepository.save(log);
	}
	
	public Log getLog(Log log) {
		return logRepository.findOne(log.getId());
	}

	public Timestamp converterTimestamp(String strDate) {
		Timestamp result = null;
		try {
	        Date date = formatter.parse(strDate);
	        result = new java.sql.Timestamp(date.getTime());
	    } catch (ParseException ex) {
	        ex.printStackTrace();
	    }
		return result;
	}

	public Date converterDate(String strDate) {
		Date result = null;
		try {
	        result = formatter.parse(strDate);
	    } catch (ParseException ex) {
	        ex.printStackTrace();
	    }
		return result;
	}

	public Timestamp converterTimestamp(Date date) {
		return new java.sql.Timestamp(date.getTime());
	}
	
	public List<Log> orderList(List<Log> list) {
		List<Log> orders = list;
		Comparator<Log> comparator = (o1, o2) -> o1.getIp().compareTo(o2.getIp());
		comparator.thenComparing((o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
		orders.sort(comparator);
		return orders;
	}
	
	public List<Log> getListByPediod(Date beginDate, Date endDate) {
		Timestamp beginTimestamp = converterTimestamp(beginDate);
		Timestamp endTimestamp = converterTimestamp(endDate);
		return logRepository.getListBetweenPeriodOrderByIpAndStartDate(beginTimestamp, endTimestamp);
	}
	
	public List<Log> getListAllOrderByIpAndStartDate() {
		return logRepository.getListAll();
	}
	
	public List<IpCounter> getCounter(Date beginDate, Date endDate) {
		Timestamp beginTimestamp = converterTimestamp(beginDate);
		Timestamp endTimestamp = converterTimestamp(endDate);
		return ipCounterRepository.counterIpByDatePeriod(beginTimestamp, endTimestamp);
	}
	
	public List<IpCounter> orderListIp(List<IpCounter> list) {
		List<IpCounter> orders = list;
		Comparator<IpCounter> comparator = (o1, o2) -> o1.getTotalText().compareTo(o2.getTotalText());
		list.sort(comparator);
		return orders;
	}
	
}	
	
