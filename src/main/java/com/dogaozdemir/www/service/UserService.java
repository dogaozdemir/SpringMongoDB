package com.dogaozdemir.www.service;

import java.util.List;

import com.dogaozdemir.www.model.User;
	
public interface UserService {
	public void addUser(User user);
	public List<User> listUser(); 
	public void deleteUser(User user);
	public void updateUser(User user);
	public User getUser(String id);
	
}
