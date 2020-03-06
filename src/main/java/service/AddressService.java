package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.AddressDTO;
import entities.Address;
import exceptions.RecordNotFoundException;
import repositories.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	//return all addresses
	public List<AddressDTO> findAddress() {
		List<Address> address = addressRepository.findAll();
		List<AddressDTO> addressDto = null;
		BeanUtils.copyProperties(address, addressDto);
		return addressDto;
	}
	
	//finding address by id
	@SuppressWarnings("null")
	public AddressDTO findById(int id) throws RecordNotFoundException {
		Optional<Address> address =  addressRepository.findById(id);
		Optional<AddressDTO> addressDto = null;
		BeanUtils.copyProperties(address, addressDto);
		if (addressDto.isPresent()) {
			return addressDto.get();
		}
		else {
			throw new RecordNotFoundException("Address not found!");
		}
	}
	
	//find address by user id
	@SuppressWarnings("null")
	public AddressDTO findByUserID(int userid) throws RecordNotFoundException {
		Optional<Address> address = addressRepository.findByUserId(userid);
		Optional<AddressDTO> addressDto = null;
		BeanUtils.copyProperties(address, addressDto);
		if(addressDto.isPresent()) {
			return addressDto.get();
		}
		else {
			throw new RecordNotFoundException("Address not found!");
		}
	}
	
	//new address
	@SuppressWarnings("null")
	public Address addOrUpdateAddress(Address addressEntity) {
		Optional<Address> address = addressRepository.findById(addressEntity.getAddress());
		Optional<AddressDTO> addressDto = null;
		BeanUtils.copyProperties(address, addressDto);
		AddressDTO addressBean = new AddressDTO();
		BeanUtils.copyProperties(addressEntity, addressBean);
		if(addressDto.isPresent()) {
			AddressDTO updatedAddress = addressDto.get();
			updatedAddress.setLocation(addressBean.getLocation());
			Address updateAddress = new Address();
			BeanUtils.copyProperties(updatedAddress, updateAddress);
			return addressRepository.save(updateAddress);
		}
		else 
			return addressRepository.save(addressEntity);
	}
}
