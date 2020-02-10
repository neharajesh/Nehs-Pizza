package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.AddressEntity;
import repositories.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	//find and return address of user
	//mostly we've to add fk to users table.
	//fk to user id
	public List<AddressEntity> findAddress() {
		/*Iterable<AddressEntity> it = addressRepository.findAll();
		ArrayList<AddressEntity> address = new ArrayList<AddressEntity>();
		for(AddressEntity a : it) {
			address.add(a);
		}
		return address;*/
		return addressRepository.findAll();
	}
	
	//finding address by id
	//so add address id as fk to user table
	public AddressEntity findById(int id) {
		return addressRepository.findById(id).get();
	}
	
	//new address
	public AddressEntity addNewAddress(AddressEntity ae) {
		return addressRepository.save(ae);
	}
}
