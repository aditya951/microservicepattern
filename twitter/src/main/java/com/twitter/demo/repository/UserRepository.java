package com.twitter.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.twitter.demo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

	public User findByUsername(String username);
	
}
