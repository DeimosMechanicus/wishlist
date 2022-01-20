package com.martins.wishlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.martins.wishlist.models.Item;
import com.martins.wishlist.mongo.ItemRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
@EnableMongoRepositories
public class WishlistApplication implements CommandLineRunner {

	@Autowired
	ItemRepository ItemRepo;

	public static void main(String[] args) {
		/*
		 * Hardcoded connection test String comString =
		 * "mongodb+srv://martinsWishlist:wishlist2022@cluster0.ital5.mongodb.net/test?authSource=admin&replicaSet=atlas-b3ntkg-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true";
		 * String conString =
		 * "mongodb+srv://martinsWishlist:wishlist2022@cluster0.ital5.mongodb.net/wishlists?retryWrites=true&w=majority";
		 * String plsWork =
		 * "mongodb://martinsWishlist:wishlist2022@cluster0-shard-00-00.ital5.mongodb.net:27017,cluster0-shard-00-01.ital5.mongodb.net:27017,cluster0-shard-00-02.ital5.mongodb.net:27017/wishlists?ssl=true&replicaSet=atlas-b3ntkg-shard-0&authSource=admin&retryWrites=true&w=majority";
		 * ConnectionString connectionString = new ConnectionString(plsWork);
		 * 
		 * MongoClientSettings settings = MongoClientSettings.builder()
		 * .applyConnectionString(connectionString) .build();
		 * 
		 * MongoClient mongoClient = MongoClients.create(settings);
		 * 
		 * MongoDatabase database = mongoClient.getDatabase("wishlists");
		 */

		SpringApplication.run(WishlistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//runDemo();
	}

	void createItems() {
		System.out.println("Data creation started...");

		//ItemRepo.save(new Items("Whole Wheat Biscuit", false, "Whole Wheat Biscuit"));
		ItemRepo.save(new Item("Bike riding", false, "XYZ Kodo Millet healthy"));
		//ItemRepo.save(new Items("Heilung concert", false, "Dried Whole Red Chilli"));
		//ItemRepo.save(new Items("Patagonia", false, "Healthy Pearl Millet"));
		//ItemRepo.save(new Items("Visit NZ", false, "Bonny Cheese Crackers Plain"));

		System.out.println("Data creation complete...");
	}

	// 1. Show all the data
	public void showAllItems() {

		ItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
	}

	// 2. Get items by name
	public void getItemByName(String name) {
		System.out.println("Getting item by name: " + name);
		List<Item> item = ItemRepo.findItemsByName(name);
		System.out.println(getItemDetails(item));
	}

	// 3. Get name and quantity of a all items of a particular category
	public void getItemsByAchived(Boolean achived) {
		System.out.println("Getting items for the achived " + achived);
		List<Item> list = ItemRepo.findAllAchived(achived);

		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Achived: " + item.isAchived()));
	}

	// 4. Get count of documents in the collection
	public void findCountOfItems() {
		long count = ItemRepo.count();
		System.out.println("Number of documents in the collection: " + count);
	}

	public String getItemIdByName(String name) {

		List<Item> list = ItemRepo.findItemsByName(name);

		String currId = null;

		for (Item itm : list) {
			return itm.getId();
		}

		return currId;
	}

	public void updateWishAchived(String name) {

		List<Item> list = ItemRepo.findItemsByName(name);

		list.forEach(item -> {
			item.setAchived(true);
		});

		// Save all the items in database
		List<Item> itemsUpdated = ItemRepo.saveAll(list);

		if (itemsUpdated != null) {
			System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
		}
	}

	public void deleteItem(String id) {
		ItemRepo.deleteById(id);
		System.out.println("Item with id " + id + " deleted...");
	}

	public void runDemo() {
		System.out.println("------------- ITEM START -------------------------------\n");

		findCountOfItems();

		System.out.println("-------------CREATE ITEMS-------------------------------\n");

		createItems();

		System.out.println("\n----------------SHOW ALL ITEMS---------------------------\n");

		showAllItems();

		System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");

		getItemByName("Whole Wheat Biscuit");

		System.out.println("\n-----------GET ITEMS BY ACHIVED---------------------------------\n");

		getItemsByAchived(true);

		System.out.println("\n-----------UPDATE ACHIVED OF Whole Wheat Biscuit----------------\n");

		updateWishAchived("Whole Wheat Biscuit");

		System.out.println("\n----------DELETE A ITEM----------------------------------\n");

		String id = getItemIdByName("Bike riding");
		deleteItem(id);
		
		System.out.println("\n----------------SHOW ALL ITEMS---------------------------\n");

		showAllItems();

		System.out.println("\n------------FINAL COUNT OF ITEMS-------------------------\n");

		findCountOfItems();

		System.out.println("\n-------------------Item End---------------------------");
	}

	public String getItemDetails(Item item) {

		System.out.println("Wish Name: " + item.getName() + ", \nAchived: " + item.isAchived() + ", \nAlphabet: "
				+ item.getAlphabet());

		return "";
	}

	public String getItemDetails(List<Item> items) {

		for (Item wish : items) {
			System.out.println("Wish Name: " + wish.getName() + ", \nAchived: " + wish.isAchived() + ", \nAlphabet: "
					+ wish.getAlphabet());
		}

		return "";
	}

}
