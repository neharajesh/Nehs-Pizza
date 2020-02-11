package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Address;
import repositories.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public List<Address> findAddress() {
		return addressRepository.findAll();
	}
	
	//finding address by id
	public Address findById(int id) {
		Optional<Address> address =  addressRepository.findById(id);
		return address.get();
	}
	
	//new address
	public Address addNewAddress(Address addressEntity) {
		return addressRepository.save(addressEntity);
	}
}
