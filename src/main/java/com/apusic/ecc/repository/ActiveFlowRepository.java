package com.apusic.ecc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apusic.ecc.entity.ActiveFlow;

public interface ActiveFlowRepository extends MongoRepository<ActiveFlow, String>{

}
