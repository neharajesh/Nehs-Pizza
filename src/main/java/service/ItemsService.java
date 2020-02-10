package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.ItemsEntity;
import repositories.ItemsRepository;

@Service
public class ItemsService {
	@Autowired
	private ItemsRepository itemsRepository;
	
	//find and return all items on the menu, with attributes
	public List<ItemsEntity> findAllItems() {
		return itemsRepository.findAll();
	}
	
	//find items by id
	public ItemsEntity findItemById(int id) {
		Optional<ItemsEntity> item = itemsRepository.findById(id);
		return item.get();
	}
	
	//add new items
	public ItemsEntity addNewItem(ItemsEntity itemsEntity) {
		return itemsRepository.save(itemsEntity);
	}
}
