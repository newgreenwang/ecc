package com.apusic.ecc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apusic.ecc.entity.ActiveFlowTime;

public interface ActiveFlowTimeRepository extends MongoRepository<ActiveFlowTime, String>{

}
