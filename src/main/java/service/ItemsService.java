package service;

import java.util.ArrayList;
import java.util.List;

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
		/*Iterable<ItemsEntity> it = itemsRepo.findAll();
		ArrayList<ItemsEntity> items = new ArrayList<ItemsEntity>();
		for(ItemsEntity a : it) {
			items.add(a);
		}
		return items;*/
		return itemsRepository.findAll();
	}
	
	//find items by id
	public ItemsEntity findItemById(int id) {
		return itemsRepository.findById(id).get();
	}
	
	//add new items
	public ItemsEntity addNewItem(ItemsEntity ie) {
		return itemsRepository.save(ie);
	}
}
