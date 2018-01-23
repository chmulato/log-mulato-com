package com.mulato.log.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "The date/hour is required!")
	private String date;
	
	@NotNull(message = "The date/hour is required!")
	private Timestamp startDate;
	
	@NotNull(message = "The IP number is required!")
	private String ip;
	
	@NotNull(message = "The GET is required!")
	private String getHttp;
	
	@NotNull
	private Integer status;
	
	@NotNull(message = "The type of the client is required!")
	private String client;

	public Log() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getGetHttp() {
		return getHttp;
	}

	public void setGetHttp(String getHttp) {
		this.getHttp = getHttp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
