package com.martins.wishlist.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.martins.wishlist.models.users.User;

import net.minidev.json.JSONObject;

@Service
public class UserService {

	public String filterUserNames(JSONObject users) {

		StringBuilder builder = new StringBuilder("");

		//ArrayList<User> userList = users.getUsers();
		/*
		for(int i =0;i<userList.size();i++) {
			builder.append(userList.get(i).getName());
			
			//Do not add comma after last name in the list.
			if(i!=userList.size()-1) {
				builder.append(", ");
			}
		}
*/
		return builder.toString();
	}
}
