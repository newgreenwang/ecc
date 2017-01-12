package com.apusic.ecc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.apusic.ecc.entity.TrafficSpikes;

public interface TrafficSpikesRepository extends MongoRepository<TrafficSpikes, String>{

	@Query(value="{}",fields="{'traffic':1,'id':0, 'time':1}")
	List<TrafficSpikes> findMapData();

}
