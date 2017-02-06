package com.apusic.ecc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apusic.ecc.entity.ActiveFlow;
import com.apusic.ecc.repository.ActiveFlowRepository;

@RestController
@RequestMapping("/activeFlow")
public class ActiveFlowController {

	@Autowired
	private ActiveFlowRepository activeFlowRepository;
	
	@RequestMapping("/all/{flag}")
	public List<ActiveFlow> findAll(@PathVariable("flag") String flag){
		if("today".equals(flag)){
			return activeFlowRepository.findByRollingTimeBetweenOrderBySumBDesc(1483951462665L, 1483951462681L);
		}else{
		
			return activeFlowRepository.findByOrderBySumBDesc();
		}
	}
	
	@RequestMapping("/add")
	public String addList(){
		
		for(int i=0; i<100; i++){
			ActiveFlow flow = new ActiveFlow();
			flow.setRollingTime(new Date().getTime());
			flow.setDestination("192.168.2." + (int)(200 * Math.random()));
			flow.setSource("192.168.2."+ (int)(200 * Math.random()));
			flow.setSumB(new Long(i*10000));
			flow.setSumP(new Long(i*100));
			activeFlowRepository.save(flow);
		}
		return "ok";
	}
	
}
