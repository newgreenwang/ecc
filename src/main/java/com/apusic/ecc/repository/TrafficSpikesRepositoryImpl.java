package com.apusic.ecc.repository;

import java.util.List;

import com.apusic.ecc.entity.TrafficSpikes;

/**
 * 已弃用
 * create by wangfan on 2017年1月11日下午3:12:14
 **/

public class TrafficSpikesRepositoryImpl implements TrafficSpikesOptions{
//
//	@Autowired
//	private MongoDatabase mongo;
	
	@Override
	public List<TrafficSpikes> findTraffic() {
//		BasicQuery query = new BasicQuery("{}","{'traffic':1,'id':0}");
//		MongoCollection<Document> dbcoll = mongo.getCollection("trafficSpikes");
//		Document cursor = dbcoll.find().projection(new BasicDBObject().append("traffic", 1)).first();
//		System.out.println(cursor.toJson());
		return null;
	}

}
