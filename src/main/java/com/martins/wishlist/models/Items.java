package com.martins.wishlist.models;

import java.util.List;

/**
 * Data Object for Jackson object parsing, used in WishService for processing lists of Items
 * @author martins
 *
 */
public class Items {
	List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
