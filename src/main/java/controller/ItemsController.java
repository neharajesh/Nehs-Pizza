package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import beans.ItemsDTO;
import entities.Items;
import exceptions.RecordNotFoundException;
import service.ItemsService;

@RestController
@RequestMapping(ItemsController.BASE_URL)
public class ItemsController {
	static final String BASE_URL = "/api/auth/items";
	@Autowired
	private ItemsService itemsService;
	
	//all items
	@GetMapping()
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String all(Model model) {
		List<ItemsDTO> item = itemsService.findAllItems();
		model.addAttribute("itemlist", item);
		return "items";
	}
	
	//items by id
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String byId(@RequestParam int id, Model model) throws RecordNotFoundException{
		ItemsDTO item =  itemsService.findItemById(id);
		model.addAttribute("item", item);
		return "itembyid";
	}
	
	//add new item
	@PostMapping("/new")
	@PreAuthorize("hasRole('MANAGER')")
	public String newItem(@RequestBody Items item, Model model) throws RecordNotFoundException{
		//Items item = itemsService.addNewItem(item);
		model.addAttribute("item", item);
		return "addnewitem";
	}
	
	//remove an item
	@PreAuthorize("hasRole('MANAGER')")
	@DeleteMapping("/delete/{id}")
	public void deleteItem(@RequestBody Items item) throws RecordNotFoundException{
		itemsService.deleteItem(item);
	}
	
	//find item by name
	@GetMapping("/{name}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public ItemsDTO findByName(@RequestParam String name, Model model)throws RecordNotFoundException{
		ItemsDTO item = itemsService.findByItemName(name);
		model.addAttribute("result", item);
		return item;
	}
	
	//update item
	@PostMapping("/update/{id}")
	public String updateItemDetails(@RequestBody Items updatingItem, Model model) throws RecordNotFoundException{
		Items updated = itemsService.addOrUpdateItem(updatingItem);
		model.addAttribute("updated", updated);
		return "updatedItem";
		
		//or return find item by id page by passing this id 
	}
}
