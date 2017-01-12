package com.apusic.ecc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * 已弃用
 * create by wangfan on 2017年1月11日下午2:45:33
 **/

@Configuration
public class MongoConfig {

	@Bean
	public MongoClient mongo(){
		MongoClient mongo = new MongoClient("192.168.2.89",27017);
		return mongo;
	}
	
	@Bean
	public MongoDatabase mongoDatabase(MongoClient mongo){
		return mongo.getDatabase("mydata");
	}
}
