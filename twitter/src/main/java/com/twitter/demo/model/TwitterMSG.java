package com.twitter.demo.model;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Document(collection= "student")
public class TwitterMSG {

	@Id
	private String id;
	private String userId;
	private String name;
	private String message;
	private String localDateTimeCreated;
	
	private Integer likes;
	private List<String> tag=null;
	
	private List<TwitterMSG> replies =null;
	
	
	public TwitterMSG(){
		
	}
	
	
	public TwitterMSG(String id, String userId, String name, String message, String localDateTimeCreated,
			Integer likes, List<String> tag, List<TwitterMSG> replies) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.message = message;
		this.localDateTimeCreated = localDateTimeCreated;
		this.likes = likes;
		this.tag = tag;
		this.replies = replies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLocalDateTimeCreated() {
		return localDateTimeCreated;
	}

	public void setLocalDateTimeCreated(String localDateTimeCreated) {
		this.localDateTimeCreated = localDateTimeCreated;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public List<TwitterMSG> getReplies() {
		return replies;
	}

	public void setReplies(List<TwitterMSG> replies) {
		this.replies = replies;
	}
	
	
	
	

}
