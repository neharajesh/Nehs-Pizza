package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@PostMapping("/items")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String all(Model model) {
		List<Items> item = itemsService.findAllItems();
		model.addAttribute("itemlist", item);
		return "items";
	}
	
	//items by id
	@GetMapping("/items/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String byId(@PathVariable int id, Model model) {
		Items item =  itemsService.findItemById(id);
		model.addAttribute("item", item);
		return "itembyid";
	}
	
	//add new item
	@PostMapping("/items/new")
	@PreAuthorize("hasRole('MANAGER')")
	public String newItem(@RequestBody Items item, Model model) {
		//Items item = itemsService.addNewItem(item);
		model.addAttribute("item", item);
		return "addnewitem";
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
