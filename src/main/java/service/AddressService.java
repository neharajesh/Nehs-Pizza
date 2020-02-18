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
	
	//find address by user id
	public Address findByUserID(int userid) {
		Optional<Address> address = addressRepository.findByUserId(userid);
		return address.get();
	}
	
	//new address
	public Address addOrUpdateAddress(Address addressEntity) {
		Optional<Address> address = addressRepository.findById(addressEntity.getId());
		if(address.isPresent()) {
			Address updatedAddress = address.get();
			//updatedAddress.setUser(addressEntity.getUser());
			updatedAddress.setLocation(addressEntity.getLocation());
			
			return addressRepository.save(updatedAddress);
		}
		else 
			return addressRepository.save(addressEntity);
	}
}
