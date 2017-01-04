package com.apusic.ecc.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class ActiveFlow {

	@Id
	private String id;

	private Date activeFlowTime;
	
	private String source;
	
	private String destination;
	
	private Long sumB;
	
	private Long sumP;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getActiveFlowTime() {
		return activeFlowTime;
	}

	public void setActiveFlowTime(Date activeFlowTime) {
		this.activeFlowTime = activeFlowTime;
	}

	public Long getSumB() {
		return sumB;
	}

	public void setSumB(Long sumB) {
		this.sumB = sumB;
	}

	public Long getSumP() {
		return sumP;
	}

	public void setSumP(Long sumP) {
		this.sumP = sumP;
	}
}
