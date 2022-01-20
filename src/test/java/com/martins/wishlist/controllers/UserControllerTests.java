package com.martins.wishlist.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.martins.wishlist.models.users.User;
import com.martins.wishlist.models.users.UserList;

@SpringBootTest
public class UserControllerTests {
	
	@Autowired
	private UserController uContr;

	
	@Test
	public void userListFilter() {
		
		UserList userFilterData = new UserList();

		User user1 = new User("someAnnaType", Long.valueOf(1),"Anna", "someAnnaEmail");
		User user2 = new User("someBobType", Long.valueOf(2),"Bob", "someBobEmail");
		User user3 = new User("someCharlyType", Long.valueOf(3),"Charly", "someCharlyEmail");
		User user4 = new User("someDanType", Long.valueOf(4),"Dan", "someDanEmail");
		
		String expectedResult = "Anna, Bob, Charly, Dan";
		
		List<User> testData = Arrays.asList(user1, user2, user3, user4);
		
		userFilterData.setUsers(testData);
		
		String filteredControllerData = uContr.userListFilter(userFilterData);

		assertEquals(expectedResult, filteredControllerData);
	}
}
