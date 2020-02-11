package service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.User;
import repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//find and return all user details
	public List<User> findAllUserDetails() {
		return userRepository.findAll();
	}
	
	//find user details by email
	public User findUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return user.get();
	}
	
	//find user by phone number
	public User findUserByPhno(String phno) {
		Optional<User> user = userRepository.findByPhno(phno);
		return user.get();
	}
	
	//check if user exists by phno
	public Boolean checkByPhno(String phno) {
		return userRepository.existsByPhno(phno);
	}
	
	//check if user exists by email
		public Boolean checkByEmail(String email) {
			return userRepository.existsByEmail(email);
		}
	
	//add new user
	public User addNewUser(User userEntity) {
		return userRepository.save(userEntity);
	}
}