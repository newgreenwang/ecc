package com.apusic.ecc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apusic.ecc.controller.response.TrafficSpickesResponse;
import com.apusic.ecc.entity.TrafficSpikes;
import com.apusic.ecc.repository.TrafficSpikesRepository;

@RestController
@RequestMapping("/traffic")
public class TrafficSpikesController {

	@Autowired
	public TrafficSpikesRepository trafficSpikesRepository;
	
	@RequestMapping("/add")
	public String addData(){
		for(int i=0; i<100; i++){
			TrafficSpikes t = new TrafficSpikes();
			t.setRollingTime(new Date().getTime());
			t.setTraffic(new Long((int)(Math.random()*1000)));
			t.setTrafficDirection(new Random().nextInt(2)==1?"in":"out");
			SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm");
			t.setTime(format.format(new Date((new Date().getTime())+(long)(Math.random()*3600000*24))));
			trafficSpikesRepository.save(t);
		}
		return "ok";
	}
	
	@RequestMapping("/map")
	public TrafficSpickesResponse getMapData(){
		TrafficSpickesResponse response = new TrafficSpickesResponse();
		List<TrafficSpikes> list = trafficSpikesRepository.findMapData();
		List<Long> traffics = new ArrayList<Long>();
		List<String> times = new ArrayList<String>();
		for(TrafficSpikes ts : list){
			traffics.add(ts.getTraffic());
			times.add(ts.getTime());
		}
		response.setTimeList(times);
		response.setTrafficList(traffics);
		return response;
	}
	
	@RequestMapping("/all")
	public List<TrafficSpikes> findAll(){
		return trafficSpikesRepository.findAll();
	}
	
	private long random(long begin,long end){  
		long rtn = begin + (long)(Math.random() * (end - begin));  
		//如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
		if(rtn == begin || rtn == end){  
		    return random(begin,end);  
		}  
		    return rtn;  
		}
}
