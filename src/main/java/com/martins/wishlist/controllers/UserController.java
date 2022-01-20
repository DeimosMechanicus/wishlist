package com.martins.wishlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.martins.wishlist.models.users.User;
import com.martins.wishlist.models.users.UserFilter;
import com.martins.wishlist.services.UserService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping(
		  value = "/api/user/", 
		  produces = "application/json", 
		  method = {RequestMethod.PUT})
public class UserController {

	@Autowired
	UserService uService;
	
	
	@GetMapping("/filter")
	public String userListFilter(String json) {
		System.out.print(json);
		ObjectMapper objectMapper = new ObjectMapper();
		UserFilter filter = null;
		try {
			filter = objectMapper.readValue(json, UserFilter.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(filter);
		
		return null;
		//return uService.filterUserNames(users);
	}
}
