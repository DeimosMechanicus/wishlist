package com.martins.wishlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martins.wishlist.models.Item;
import com.martins.wishlist.models.Items;
import com.martins.wishlist.mongo.ItemRepository;

@Service
public class WishService {
	
	@Autowired
	ItemRepository ItemRepo;
	
	/**
	 * Adds a single, given Item to DB
	 * @param item
	 * @return Item
	 */
	public Item addSingleWishItem(Item item) {
		
		return ItemRepo.save(item);
	}
	
	/**
	 * Saves all given Items in to DB
	 * @param items
	 * @return List<Item>
	 */
	public List<Item> addMultipleWishItems(Items items) {

		List<Item> itemsSaved = ItemRepo.saveAll(items.getItems());
		
		return itemsSaved;
	}
	
	/**
	 * Returns Single item by name or Id
	 * @param nameOrId
	 * @return Item
	 */
	public Item getSingleWishItem(String nameOrId) {
		
		Item foundItem = ItemRepo.findItemById(nameOrId);
		
		if(foundItem==null) {
			foundItem = ItemRepo.findSingleItemByName(nameOrId);
		}
		
		return foundItem;
	}
	
	/**
	 * Returns all items from DB
	 * @return List<Item>
	 */
	public List<Item> getAllWishes() {
		
		return ItemRepo.findAll();
		
	}

	/**
	 * Find items with given id and update them.
	 * @param item
	 * @return List<Item>
	 */
	public List<Item> updateWishItem(Item item) {
		
		List<Item>updatableItems = ItemRepo.findItemsById(item.getId());

		updatableItems.forEach(upd -> {
			upd.setAchived(item.isAchived());
			upd.setName(item.getName());
			upd.setAlphabet(item.getAlphabet());
		});

		// Save all the items in database
		List<Item> itemsUpdated = ItemRepo.saveAll(updatableItems);

		return itemsUpdated;
	}

	/**
	 * Deletes Wish list item by id or if no id given by item name
	 * @param item
	 */
	public boolean deleteWishItem(String name, String id) {
		//Do not do any unnecessary DB operations
		boolean itemDeleted = false;
		if(id!=null) {
			itemDeleted=true;
			deleteItemById(id);
			
		}	
		if(!itemDeleted&&name!=null) {

			deleteItemByName(name);
		}
		
		return true;
		
	}
	
	//Delete item by id
	private void deleteItemById(String id) {
		ItemRepo.deleteById(id);
	}
	
	//Find all items with given name and then delete them
	private void deleteItemByName(String name) {
		List<Item> itemList = ItemRepo.findItemsByName(name);
		for(Item item : itemList) {
			ItemRepo.deleteById(item.getId());
		}
	}


}
