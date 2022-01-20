package com.martins.wishlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.martins.wishlist.models.users.UserList;
import com.martins.wishlist.services.UserService;

@RestController
@RequestMapping(
		  value = "/api/user/", 
		  produces = "application/json", 
		  method = {RequestMethod.PUT})
public class UserController {

	@Autowired
	UserService uService;
	
	
	@GetMapping("/filter")
	public String userListFilter(@RequestBody UserList userList) {
		
		return uService.filterUserNames(userList);
	}
}
