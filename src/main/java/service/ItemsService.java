package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Items;
import repositories.ItemsRepository;

@Service
public class ItemsService {
	@Autowired
	private ItemsRepository itemsRepository;
	
	//find and return all items on the menu, with attributes
	public List<Items> findAllItems() {
		return itemsRepository.findAll();
	}
	
	//find items by id
	public Items findItemById(int id) {
		Optional<Items> item = itemsRepository.findById(id);
		return item.get();
	}
	
	//add new items
	public Items addNewItem(Items itemsEntity) {
		return itemsRepository.save(itemsEntity);
	}
	
	//remove item
	public void deleteItem(Items item) {
		itemsRepository.delete(item);
	}
	
	//update item
	public Items updateItem(Items item) {
		return itemsRepository.save(item);
	}
	
	//find item by name
	public Items findByItemName(String name) {
		Optional<Items> item = itemsRepository.findByName(name);
		return item.get();
	}
}
