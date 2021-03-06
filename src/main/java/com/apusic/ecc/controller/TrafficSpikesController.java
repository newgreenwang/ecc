package com.apusic.ecc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<Long> ins = new ArrayList<Long>();
		List<Long> outs = new ArrayList<Long>();
		List<String> times = new ArrayList<String>();
		for(TrafficSpikes ts : list){
			if("in".equals(ts.getTrafficDirection())){
				ins.add(ts.getTraffic());
			}else{
				outs.add(ts.getTraffic());
			}
			times.add(ts.getTime());
		}
		response.setTimeList(times);
		response.setTrafficInList(ins);
		response.setTrafficOutList(outs);
		return response;
	}
	
	@RequestMapping(value = "/all/{flag}", method=GET)
	public List<TrafficSpikes> findAll(@PathVariable("flag") String flag){
		if("today".equals(flag)){
			return trafficSpikesRepository.findByRollingTimeBetween(1484206131874L, 1484206131888L);
			
		}else{
			return trafficSpikesRepository.findAll();
		}
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
