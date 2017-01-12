package com.apusic.ecc.controller.response;

import java.util.List;

/**
 * create by wangfan on 2017年1月11日上午11:03:36
 **/

public class TrafficSpickesResponse extends CodedResponse{

	private List<String> timeList;
	private List<Long> trafficList;
	
	public List<String> getTimeList() {
		return timeList;
	}
	public void setTimeList(List<String> timeList) {
		this.timeList = timeList;
	}
	public List<Long> getTrafficList() {
		return trafficList;
	}
	public void setTrafficList(List<Long> trafficList) {
		this.trafficList = trafficList;
	}
	
}
