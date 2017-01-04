package com.apusic.ecc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apusic.ecc.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	User findByUserName(String userName);
}
