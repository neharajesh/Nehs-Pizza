package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.User;
import service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	//get all user details
	@GetMapping("/users")
	@ModelAttribute("users")
	public List<User> all() {
		return userService.findAllUserDetails();
	}
	
	//get user details by id
	/*@GetMapping("/users/{id}")
	public User getDetails(@PathVariable int id) {
		return userService.findUserById(id);
	}*/
	
	//add new user
	/*@PostMapping("/users/new")
	public User addNewUser(@RequestBody User newUser) {
		return userService.addNewUser(newUser);
	}*/
	
	//delete user
	public void deleteExistingUser(@RequestBody User exsitingUser) {
		userService.deleteUser(exsitingUser);
	}
	
	//update user details
	public User updateUserDetails(@RequestBody User updatingUser) {
		return userService.updateUser(updatingUser);
	}
	
}
