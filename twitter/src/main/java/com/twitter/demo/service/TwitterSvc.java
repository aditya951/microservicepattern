package com.twitter.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.demo.model.TwitterMSG;
import com.twitter.demo.model.User;
import com.twitter.demo.repository.TwitterRepository;
import com.twitter.demo.repository.UserRepository;

@Service
public class TwitterSvc {

	@Autowired
	TwitterRepository twitterRepository;
	
	@Autowired
	UserRepository userRepository;

	public TwitterMSG createTwitter(TwitterMSG twitterMsg) {

		User findById = userRepository.findById(twitterMsg.getUserId()).get();
		
		TwitterMSG newTwitterMSG=new TwitterMSG(); 
		newTwitterMSG.setMessage(twitterMsg.getMessage());
		newTwitterMSG.setUserId(findById.getId());
		newTwitterMSG.setName(findById.getUsername());
		newTwitterMSG.setLikes(twitterMsg.getLikes());
		newTwitterMSG.setTag(twitterMsg.getTag());
		newTwitterMSG.setReplies(new ArrayList<TwitterMSG>());
		
		return twitterRepository.save(newTwitterMSG);
	}

	public TwitterMSG updateTwitter(TwitterMSG updateTwitterMsg, String id) {

		TwitterMSG oldTwitterMSG = twitterRepository.findById(id).get();
		TwitterMSG newTwitterMsg = new TwitterMSG(oldTwitterMSG.getId(), oldTwitterMSG.getUserId(),
				oldTwitterMSG.getName(), updateMessage(oldTwitterMSG, updateTwitterMsg),
				oldTwitterMSG.getLocalDateTimeCreated(), updateLikes(oldTwitterMSG, updateTwitterMsg), oldTwitterMSG.getTag(),
				oldTwitterMSG.getReplies());

		//oldTwitterMSG.setMessage(newTwitterMsg.getMessage());

		return twitterRepository.save(newTwitterMsg);
	}

	public String updateMessage(TwitterMSG oldTwitterMSG, TwitterMSG updateTwitterMsg) {

		if (updateTwitterMsg.getMessage() != null) {
			return updateTwitterMsg.getMessage();
		}

		return oldTwitterMSG.getMessage();

	}

	public Integer updateLikes(TwitterMSG oldTwitterMSG, TwitterMSG updateTwitterMsg) {

		if (updateTwitterMsg.getLikes() != null) {
			return updateTwitterMsg.getLikes();
		}

		return oldTwitterMSG.getLikes();

	}
	
	public TwitterMSG replyTwitter(TwitterMSG updateTwitterMsg, String id) {

		TwitterMSG oldTwitterMSG = twitterRepository.findById(id).get();
		List<TwitterMSG> newRepliesLst =new ArrayList<>(oldTwitterMSG.getReplies()) ;
		TwitterMSG newTwitterMSG=new TwitterMSG(); 
		newTwitterMSG.setMessage(updateTwitterMsg.getMessage());
		newTwitterMSG.setUserId(updateTwitterMsg.getUserId());
		
		newRepliesLst.add(newTwitterMSG);
		oldTwitterMSG.setReplies(newRepliesLst);
		
		//oldTwitterMSG.setMessage(newTwitterMsg.getMessage());

		return twitterRepository.save(oldTwitterMSG);
	}

	public List<TwitterMSG> getAllTweets() {
		List<TwitterMSG> findAll = twitterRepository.findAll();
		return findAll;
	}

	public String deleteTwitter(String id) {
		twitterRepository.deleteById(id);
		return "deleted Successfully" ;
	}

	public List<TwitterMSG> getAllTweetsOfUser(String userId) {
		List<TwitterMSG> findByuserId = twitterRepository.findByUserId(userId);
		return findByuserId;
	}

	public TwitterMSG getOneTweetsOfUser(String id) {
		TwitterMSG oldTwitterMSG = twitterRepository.findById(id).get();
		return oldTwitterMSG;
	}
	
//	public List<TwitterMSG> addReply(TwitterMSG oldTwitterMSG, TwitterMSG updateTwitterMsg) {
//
//		 List<TwitterMSG> newRepliesLst =new ArrayList<>(oldTwitterMSG.getReplies()) ;
//		
//		if (updateTwitterMsg.getReplies() != null && (!updateTwitterMsg.getReplies().isEmpty())) {
//			
//			newRepliesLst.add(updateTwitterMsg);
//			return newRepliesLst;
//			
//		}
//
//		return newRepliesLst;
//
//	}

}
