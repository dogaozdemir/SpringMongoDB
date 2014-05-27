package com.dogaozdemir.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.dogaozdemir.www.model.User;
import com.dogaozdemir.www.service.UserService;
	//Requests first comes here, and then process goes to RequestMapping's value.
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String getUserList(ModelMap model){
		model.addAttribute("userList", userService.listUser());
		return "output";
	
	}
		
	
	@RequestMapping(value="/user/save", method=RequestMethod.POST)
	public View createUser(@ModelAttribute User user , ModelMap model){
		
	         userService.addUser(user);
		
	        return new RedirectView("/SpringMongo/user");  
	}
	
	
	@RequestMapping(value="/user/delete",method=RequestMethod.GET)
	public View deleteUser(@RequestParam String id,ModelMap model){
		
		
		User user=userService.getUser(id);
		userService.deleteUser(user);
		return new RedirectView("/SpringMongo/user");
	}
	

	
	 @RequestMapping(value = "/user/update", method = RequestMethod.GET)  
	    public View updateUser(@RequestParam String id,@RequestParam String name,@RequestParam String surname,@RequestParam String phone, ModelMap model) {
		 
		 User user=userService.getUser(id);
		 user.setUserName(name);
		 user.setSurName(surname);
		 user.setPhoneNumber(phone);
		 userService.updateUser(user);
	      
	        return new RedirectView("/SpringMongo/user");  
	    }
	

	
}
