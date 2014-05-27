package com.dogaozdemir.www.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dogaozdemir.www.dao.UserDao;
import com.dogaozdemir.www.model.User;
	//basic DB processes (add-list-delete-update-get)
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "user";

	public void addUser(User user){
		
		if(!mongoTemplate.collectionExists(User.class))
			mongoTemplate.createCollection(User.class);
		
		user.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(user,COLLECTION_NAME);
	}
	
	public List<User> listUser(){
		return mongoTemplate.findAll(User.class,COLLECTION_NAME);
	}
	
	public void deleteUser(User user){
		 mongoTemplate.remove(user,COLLECTION_NAME);
	}
	
	public void updateUser(User user){
		Query query3 = new Query();
		query3.addCriteria(Criteria.where("id").is(user.getId()));
		Update update3 = new Update();
		update3.set("userName", user.getUserName());
		update3.set("surName", user.getSurName());
		update3.set("phoneNumber", user.getPhoneNumber());
		 mongoTemplate.updateFirst(query3, update3, COLLECTION_NAME);
	}
	
	public User getUser(String id){
		 return mongoTemplate.findById(id,User.class);
	}
}
