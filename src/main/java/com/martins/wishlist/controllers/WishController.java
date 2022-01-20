package com.martins.wishlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.martins.wishlist.models.Item;
import com.martins.wishlist.models.Items;
import com.martins.wishlist.services.WishService;

@RestController
@RequestMapping(
		  value = "/api/wish/", 
		  produces = "application/json", 
		  method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class WishController {
	
	@Autowired
	WishService wService;
	
	@GetMapping("/add")
	public Item addWish(@RequestBody Item item) {
		
		return  wService.addSingleWishItem(item);
		
	}
	
	@GetMapping("/addList")
	public List<Item> addWish(@RequestBody Items items) {

		return  wService.addMultipleWishItems(items);
		
	}
	
	@GetMapping("/update")
	public List<Item> updateWish(@RequestBody Item item) {
		
		return wService.updateWishItem(item);
		
	}
	
	@GetMapping("/delete")
	public boolean deleteWish(@RequestParam(required = false) String name,@RequestParam(required = false) String id) {
		
		return wService.deleteWishItem(name,id);
		
	}
	
	@GetMapping("/get")
	public Item getWish(@RequestParam String nameOrId) {
		
		return wService.getSingleWishItem(nameOrId);
		
	}
	
	@GetMapping("/allWishes")
	public List<Item> getWishList() {
		
		return  wService.getAllWishes();
		
	}
	
	
	
	

}
