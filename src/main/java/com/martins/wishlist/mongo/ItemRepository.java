package com.martins.wishlist.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.martins.wishlist.models.Item;

public interface ItemRepository extends MongoRepository<Item, String> {
    
    @Query(value="{achived:'?0'}", fields="{'name' : 1, 'achived' : 1}")
    List<Item> findAllAchived(Boolean achived);
    
    @Query("{name:'?0'}")
    Item findSingleItemByName(String name);
    
    @Query("{name:'?0'}")
    List<Item> findItemsByName(String name);
    
    @Query("{id:'?0'}")
    List<Item> findItemsById(String name);
    
    public long count();
    


}
