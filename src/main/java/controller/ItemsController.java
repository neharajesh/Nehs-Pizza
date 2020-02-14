package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Items;
import entities.User;
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
	public String byId(@RequestParam int id, Model model) {
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
	@PostMapping("/items/delete/{id}")
	public void deleteItem(@RequestBody Items item) {
		itemsService.deleteItem(item);
	}
	
	//find item by name
	@PostMapping("/items/{name}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public Items findByName(@RequestParam String name, Model model) {
		Items item = itemsService.findByItemName(name);
		model.addAttribute("result", item);
		return item;
	}
	
	//update item
	@PostMapping("/items/update/{id}")
	public String updateItemDetails(@RequestBody Items updatingItem, Model model) {
		Items updated = itemsService.updateItem(updatingItem);
		model.addAttribute("updated", updated);
		return "updatedItem";
		
		//or return find item by id page by passing this id 
	}
}
