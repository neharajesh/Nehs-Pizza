package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.Address;
import service.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	//find all addresses
	@GetMapping("/address/all")
	public List<Address> all() {
		return addressService.findAddress();
	}
	
	//find address by id
	@GetMapping("/address/{id}")
	public Address findById(int id) {
		return addressService.findById(id);
	}
	
	//find address by user id
	@ModelAttribute("useraddress")
	public Address findByUser(int id) {
		return addressService.findByUserID(id);
	}
	
	//add new address 
	@PostMapping("/address/new")
	public Address addNewAddress(@RequestBody Address ae) {
		return addressService.addNewAddress(ae);
	}
}
