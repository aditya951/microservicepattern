package com.twitter.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.twitter.demo.model.TwitterMSG;

@Repository
public interface TwitterRepository extends MongoRepository<TwitterMSG,String>{
	
	
	public List<TwitterMSG> findByUserId(String userId);

}
