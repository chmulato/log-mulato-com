package com.mulato.log.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private String startDate;
	
	@NotNull(message = "The IP number is required!")
	private String ip;
	
	@NotNull(message = "The GET is required!")
	private String getHttp;
	
	private Integer state;
	
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	public Date getDate() {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.mmm");
	    String dateInString = getStartDate();
	    try {
	        date = formatter.parse(dateInString);
	        System.out.println(date);
	        System.out.println(formatter.format(date));
	    } catch (ParseException ex) {
	        ex.printStackTrace();
	    }
		return date;
	}

}
