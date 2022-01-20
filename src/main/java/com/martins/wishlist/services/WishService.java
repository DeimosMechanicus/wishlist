package com.martins.wishlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martins.wishlist.models.Item;
import com.martins.wishlist.mongo.ItemRepository;

@Service
public class WishService {
	
	@Autowired
	ItemRepository ItemRepo;
	
	public Item addSingleWishItem(Item item) {
		
		return ItemRepo.save(item);
	}
	
	public Item addMultipleWishItems(String itemName) {
		Item item = ItemRepo.findSingleItemByName(itemName);
		
		return item;
	}
	
	public Item getSingleWishItem(String itemName) {
		Item item = ItemRepo.findSingleItemByName(itemName);
		
		return item;
	}
	
	public List<Item> getAllWishes() {
		
		return ItemRepo.findAll();
		
	}

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

	public void deleteWishItem(String id) {
		
		ItemRepo.deleteById(id);
		
	}
	
	


}
