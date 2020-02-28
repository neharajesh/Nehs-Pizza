package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Address;
import exceptions.RecordNotFoundException;
import repositories.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public List<Address> findAddress() {
		return addressRepository.findAll();
	}
	
	//finding address by id
	public Address findById(int id) throws RecordNotFoundException {
		Optional<Address> address =  addressRepository.findById(id);
		if (address.isPresent()) {
			return address.get();
		}
		else {
			throw new RecordNotFoundException("Address not found!");
		}
	}
	
	//find address by user id
	public Address findByUserID(int userid) throws RecordNotFoundException {
		Optional<Address> address = addressRepository.findByUserId(userid);
		if(address.isPresent()) {
			return address.get();
		}
		else {
			throw new RecordNotFoundException("Address not found!");
		}
	}
	
	//new address
	public Address addOrUpdateAddress(Address addressEntity) {
		Optional<Address> address = addressRepository.findById(addressEntity.getAddress());
		if(address.isPresent()) {
			Address updatedAddress = address.get();
			updatedAddress.setLocation(addressEntity.getLocation());
			
			return addressRepository.save(updatedAddress);
		}
		else 
			return addressRepository.save(addressEntity);
	}
}
