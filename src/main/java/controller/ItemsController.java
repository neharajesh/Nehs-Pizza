package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.Items;
import service.ItemsService;

@RestController
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	//all items
	@GetMapping("allitems")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public List<Items> all() {
		return itemsService.findAllItems();
	}
	
	//items by id
	@GetMapping("/items/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public Items byId(int id) {
		return itemsService.findItemById(id);
	}
	
	//add new item
	@PostMapping("/items/new")
	@PreAuthorize("hasRole('MANAGER')")
	public Items newItem(@RequestBody Items item) {
		return itemsService.addNewItem(item);
	}
	
	//remove an item
	@PreAuthorize("hasRole('MANAGER')")
	public void deleteItem(@RequestBody Items item) {
		itemsService.deleteItem(item);
	}
	
	//find item by name
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public Items findByName(@RequestBody String name, Model model) {
		Items item = itemsService.findByItemName(name);
		model.addAttribute("result", item);
		return item;
	}
}
