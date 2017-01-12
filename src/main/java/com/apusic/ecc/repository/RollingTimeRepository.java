package com.apusic.ecc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apusic.ecc.entity.RollingTime;

public interface RollingTimeRepository extends MongoRepository<RollingTime, String>{

}
