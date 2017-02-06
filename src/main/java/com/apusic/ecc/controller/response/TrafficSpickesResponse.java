package com.apusic.ecc.controller.response;

import java.util.List;

/**
 * create by wangfan on 2017年1月11日上午11:03:36
 **/

public class TrafficSpickesResponse extends CodedResponse{

	private List<String> timeList;
	private List<Long> trafficOutList;
	private List<Long> trafficInList;
	
	public List<String> getTimeList() {
		return timeList;
	}
	public void setTimeList(List<String> timeList) {
		this.timeList = timeList;
	}
	public List<Long> getTrafficOutList() {
		return trafficOutList;
	}
	public void setTrafficOutList(List<Long> trafficOutList) {
		this.trafficOutList = trafficOutList;
	}
	public List<Long> getTrafficInList() {
		return trafficInList;
	}
	public void setTrafficInList(List<Long> trafficInList) {
		this.trafficInList = trafficInList;
	}
}
