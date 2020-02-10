package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.UserEntity;
import service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	//get all user details
	@GetMapping("/users")
	@ModelAttribute("users")
	public List<UserEntity> all() {
		return userService.findAllUserDetails();
	}
	
	//get user details by id
	/*@GetMapping("/users/{id}")
	public UserEntity getDetails(@PathVariable int id) {
		return userService.findUserById(id);
	}*/
	
	//add new user
	@PostMapping("/users/new")
	public UserEntity addNewUser(@RequestBody UserEntity newUser) {
		return userService.addNewUser(newUser);
	}
	
}
