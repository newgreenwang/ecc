package com.apusic.ecc.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class ActiveFlowTime {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getActive_flow_time() {
		return active_flow_time;
	}

	public void setActive_flow_time(Date active_flow_time) {
		this.active_flow_time = active_flow_time;
	}

	@Id
	private String id;
	
	private Date active_flow_time;
}
