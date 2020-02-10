package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.UserEntity;
import repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//find and return all user details
	public List<UserEntity> findAllUserDetails() {
		return userRepository.findAll();
	}
	
	//find user details by id
	public UserEntity findUserById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	//add new user
	public UserEntity addNewUser(UserEntity ue) {
		return userRepository.save(ue);
	}
}