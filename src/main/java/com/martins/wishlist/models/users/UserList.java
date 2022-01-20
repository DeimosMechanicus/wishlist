package com.martins.wishlist.models.users;

import java.util.List;

/**
 * Data Object for Jackson object parsing, used in UserSercice for processing lists of Users
 * @author martins
 *
 */
public class UserList {
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
