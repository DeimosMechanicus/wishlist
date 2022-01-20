package com.martins.wishlist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.martins.wishlist.models.users.User;
import com.martins.wishlist.models.users.UserList;

@Service
public class UserService {

	/**
	 * Goes thru user list and gets all usernames and adds them in single comma separated string
	 * @param userList
	 * @return String
	 */
	public String filterUserNames(UserList userList) {

		StringBuilder builder = new StringBuilder("");

		List<User> users = userList.getUsers();
		
		for(int i =0;i<users.size();i++) {
			builder.append(users.get(i).getName());
			
			//Do not add comma after last name in the list.
			if(i!=users.size()-1) {
				builder.append(", ");
			}
		}

		return builder.toString();
	}
}
