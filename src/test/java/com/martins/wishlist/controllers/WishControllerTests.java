package com.martins.wishlist.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.martins.wishlist.models.Item;

@SpringBootTest
public class WishControllerTests {

	@Autowired
	private WishController wContr;

	private static String defaultTestName = "Integration Test Name";
	private static String defaultTestAlphabet = "Some Long text in intem aphabet field";
	private static Boolean defaultIsAchived = false;
	private static String defaultTestRename = "Integration Test RENAME to this";

	@Test
	public void testWishItemtCRUD() {
		Item newItem = new Item(defaultTestName, defaultIsAchived, defaultTestAlphabet);

		// Test Add
		Item testAdd = wContr.addWish(newItem);

		assertEquals(newItem.getName(), testAdd.getName());
		assertEquals(newItem.isAchived(), testAdd.isAchived());
		assertEquals(newItem.getAlphabet(), testAdd.getAlphabet());

		// Test get
		Item testGet = wContr.getWish(defaultTestName);

		assertEquals(defaultTestName, testGet.getName());
		assertEquals(defaultIsAchived, testGet.isAchived());
		assertEquals(defaultTestAlphabet, testGet.getAlphabet());

		Item testUpdateGet = wContr.getWish(defaultTestName);
		testUpdateGet.setName(defaultTestRename);

		// Test update
		List<Item> testUpdate = wContr.updateWish(testUpdateGet);

		assertNotEquals(0, testUpdate.size());

		if (testUpdate.size() > 0) {
			assertEquals(defaultTestRename, testUpdate.get(0).getName());
		}

		// Test delete
		boolean wasItemDeleted = wContr.deleteWish(defaultTestRename, null);

		assertTrue(wasItemDeleted);

	}

	@Test
	public void getAllWishes() {
		// Test if get all works
		List<Item> allWishList = wContr.getWishList();

		// There might be a problem if there are no items in DB
		assertNotEquals(0, allWishList.size());
	}
}
