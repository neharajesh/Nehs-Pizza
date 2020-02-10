package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.AddressEntity;
import repositories.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public List<AddressEntity> findAddress() {
		return addressRepository.findAll();
	}
	
	//finding address by id
	public AddressEntity findById(int id) {
		Optional<AddressEntity> address =  addressRepository.findById(id);
		return address.get();
	}
	
	//new address
	public AddressEntity addNewAddress(AddressEntity addressEntity) {
		return addressRepository.save(addressEntity);
	}
}
