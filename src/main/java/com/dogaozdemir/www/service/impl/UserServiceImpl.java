package com.dogaozdemir.www.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dogaozdemir.www.dao.UserDao;
import com.dogaozdemir.www.model.User;
import com.dogaozdemir.www.service.UserService;

	// 

@Repository
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	
	public void addUser(User user){
		
		userDao.addUser(user);
	}
	
	public List<User> listUser(){
		return userDao.listUser();
	}
	
	public void deleteUser(User user){
		userDao.deleteUser(user);
	}
	
	public void updateUser(User user){
	userDao.updateUser(user);
	}
	
	public User getUser(String id){
		 return userDao.getUser(id);
	}
}
