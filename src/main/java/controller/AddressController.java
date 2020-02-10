package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.AddressEntity;
import service.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	//find all addresses
	@GetMapping("/address/all")
	public List<AddressEntity> all() {
		return addressService.findAddress();
	}
	
	//find address by id
	@GetMapping("/address/{id}")
	public AddressEntity findById(int id) {
		return addressService.findById(id);
	}
	
	//add new address 
	@PostMapping("/address/new")
	public AddressEntity addNewAddress(@RequestBody AddressEntity ae) {
		return addressService.addNewAddress(ae);
	}
}
