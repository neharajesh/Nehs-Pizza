package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Address;
import service.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	//find all addresses
	@GetMapping("/address/all")
	public String all(Model model) {
		List<Address> addressList = addressService.findAddress();
		model.addAttribute("addressList", addressList);
		return "alladdresses";
	}
	
	//find address by id
	@GetMapping("/address/{id}")
	public String findById(@RequestParam int id, Model model) {
		Address address = addressService.findById(id);
		model.addAttribute("address", address);
		return "addressById";
	}
	
	//find address by user id
	@ModelAttribute("address/{userId}")
	public String findByUser(@RequestParam int userId, Model model) {
		Address address = addressService.findByUserID(userId);
		model.addAttribute("address", address);
		return "addressByUserId";
	}
	
	//add new address 
	@PostMapping("/address/new")
	public Address addNewAddress(@RequestBody Address ae) {
		return addressService.addNewAddress(ae);
	}
}
