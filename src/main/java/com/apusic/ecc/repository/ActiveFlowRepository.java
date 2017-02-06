package com.apusic.ecc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apusic.ecc.entity.ActiveFlow;

public interface ActiveFlowRepository extends MongoRepository<ActiveFlow, String>{

	List<ActiveFlow> findByRollingTimeBetweenOrderBySumBDesc(long start, long end);
	
	List<ActiveFlow> findByOrderBySumBDesc();
}
