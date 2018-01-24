package com.mulato.log.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IpCounter {
	
	@Id
	private long id;

	private String ip;
	
	private long total;

	public IpCounter() {
		super();
	}
	
	public IpCounter(String ip, long total) {
		super();
		this.ip = ip;
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	public String getTotalText() {
		return String.valueOf(total);
	}

}
