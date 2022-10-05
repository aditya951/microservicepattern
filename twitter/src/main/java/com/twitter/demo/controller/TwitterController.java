package com.twitter.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.demo.model.TwitterMSG;
import com.twitter.demo.service.TwitterSvc;

@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins="*")
public class TwitterController {

	@Autowired
	TwitterSvc twittersvc;

	@GetMapping("/all")
	public List<TwitterMSG> getAllTweets() {
		return twittersvc.getAllTweets();
	}
	
	@GetMapping("/{userId}")
	public List<TwitterMSG> getAllTweet( @PathVariable String userId) {
		return twittersvc.getAllTweetsOfUser(userId);
	}
	@GetMapping("/tweet/{id}")
	public TwitterMSG getOneTweet( @PathVariable String id) {
		return twittersvc.getOneTweetsOfUser(id);
	}

	@PostMapping("{userId}/add")
	public TwitterMSG createTwitter(@RequestBody TwitterMSG twittermsg, @PathVariable String userId) {

		twittermsg.setUserId(userId);
		return twittersvc.createTwitter(twittermsg);
	}

	@PutMapping("{userId}/update/{id}")
	public TwitterMSG updateTwitter(@RequestBody TwitterMSG twittermsg, @PathVariable String userId,
			@PathVariable String id) {

		twittermsg.setUserId(userId);
		return twittersvc.updateTwitter(twittermsg, id);
	}

	@PostMapping("{userId}/reply/{id}")
	public TwitterMSG replyTwitter(@RequestBody TwitterMSG twittermsg, @PathVariable String userId,
			@PathVariable String id) {

		twittermsg.setUserId(userId);
		return twittersvc.replyTwitter(twittermsg, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> deleteTwitter(@PathVariable String id) {
		twittersvc.deleteTwitter(id);
		return new ResponseEntity<String>("Record deleted", HttpStatus.NO_CONTENT);
	}
	

}
