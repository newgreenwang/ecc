package com.apusic.ecc.entity;

import org.springframework.data.annotation.Id;

public class TrafficSpikes {

	@Id
	private String id;
	
	private Long rollingTime;
	
	private String time;
	
	private Long traffic;
	
	private String trafficDirection;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getRollingTime() {
		return rollingTime;
	}

	public void setRollingTime(Long rollingTime) {
		this.rollingTime = rollingTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getTraffic() {
		return traffic;
	}

	public void setTraffic(Long traffic) {
		this.traffic = traffic;
	}

	public String getTrafficDirection() {
		return trafficDirection;
	}

	public void setTrafficDirection(String trafficDirection) {
		this.trafficDirection = trafficDirection;
	}
	
	
}
