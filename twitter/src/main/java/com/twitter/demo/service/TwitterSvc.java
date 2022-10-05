package com.twitter.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
		newTwitterMSG.setLocalDateTimeCreated(time());
		newTwitterMSG.setTag(twitterMsg.getTag());
		newTwitterMSG.setReplies(new ArrayList<TwitterMSG>());
		
		TwitterMSG save = twitterRepository.save(newTwitterMSG);
		return save;
	}

	private String time() {
		 LocalDateTime now = LocalDateTime.now();
		 
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("KK:mm a dd-MMM-yyyy");  
		 String format = dtf.format(now);
		return format.toString();
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
			return updateTwitterMsg.getLikes()+1;
		}

		return oldTwitterMSG.getLikes();

	}
	
	public TwitterMSG replyTwitter(TwitterMSG updateTwitterMsg, String id) {
		User user = userRepository.findById(updateTwitterMsg.getUserId()).get();
		TwitterMSG oldTwitterMSG = twitterRepository.findById(id).get();
		List<TwitterMSG> newRepliesLst =new ArrayList<>(oldTwitterMSG.getReplies()) ;
		TwitterMSG newTwitterMSG=new TwitterMSG(); 
		newTwitterMSG.setMessage(updateTwitterMsg.getMessage());
		newTwitterMSG.setUserId(updateTwitterMsg.getUserId());
		newTwitterMSG.setName(user.getUsername());
		newTwitterMSG.setLocalDateTimeCreated(time());
		newRepliesLst.add(newTwitterMSG);		
		oldTwitterMSG.setReplies(newRepliesLst);
		
		return twitterRepository.save(oldTwitterMSG);
	}

	public List<TwitterMSG> getAllTweets() {
		List<TwitterMSG> findAll = twitterRepository.findAll();
		Collections.reverse(findAll);
		return findAll;
	}

	public String deleteTwitter(String id) {
		twitterRepository.deleteById(id);
		return "deleted Successfully" ;
	}

	public List<TwitterMSG> getAllTweetsOfUser(String userId) {
		List<TwitterMSG> findByuserId = twitterRepository.findByUserId(userId);
		Collections.reverse(findByuserId);
		return findByuserId;
	}

	public TwitterMSG getOneTweetsOfUser(String id) {
		TwitterMSG oldTwitterMSG = twitterRepository.findById(id).get();
		
		List<TwitterMSG> replies = oldTwitterMSG.getReplies();
		Collections.reverse(replies);
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
