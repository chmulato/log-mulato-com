package com.mulato.log.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulato.log.model.Log;
import com.mulato.log.repository.LogRepository;

@Service
public class LogService {

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
	
}	
	
