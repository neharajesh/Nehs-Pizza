package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.ItemsEntity;
import service.ItemsService;

@RestController
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	//all items
	@GetMapping("/items/all")
	public List<ItemsEntity> all() {
		return itemsService.findAllItems();
	}
	
	//items by id
	@GetMapping("/items/{id}")
	public ItemsEntity byId(int id) {
		return itemsService.findItemById(id);
	}
	
	//add new item
	@PostMapping("/items/new")
	public ItemsEntity newItem(@RequestBody ItemsEntity ie) {
		return itemsService.addNewItem(ie);
	}
	
	
}
