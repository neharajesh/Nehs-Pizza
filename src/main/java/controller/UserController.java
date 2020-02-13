package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.User;
import enums.UserRoles;
import service.RoleService;
import service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	//get all user details
	@GetMapping("/users")
	@PreAuthorize("hasRole('MANAGER')")
	public String all(
					/*@RequestBody User user, */
					Model model) {
		List<User> allUsers = userService.findAllUserDetails();
		model.addAttribute("users", allUsers);
		return "users";
	}
	
	//get user details by phno
	@GetMapping("/users/{phno}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('STAFF')")
	public User getDetailsByPhno(@PathVariable String phno, Model model) {
		User user = userService.findUserByPhno(phno);
		model.addAttribute("user", user);
		return user;
	}
	
	//get user details by email
	@GetMapping("/users/{email}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('STAFF')")
	public User getDetailsByEmail(@PathVariable String email, Model model) {
		User user = userService.findUserByEmail(email);
		model.addAttribute("user", user);
		return user;
	}
		
	//get users based on role
	@GetMapping("/users/{usertype}")
	@PreAuthorize("hasRole('MANAGER')")
	public List<User> findUsersBasedOnRole(@PathVariable UserRoles roleName, Model model) {
		List<User> listOfUsers = roleService.findUsersBasedOnRole(roleName);
		model.addAttribute("user", listOfUsers);
		return listOfUsers;
	}
	
	//add new user
	/*@PostMapping("/users/new")
	public User addNewUser(@RequestBody User newUser) {
		return userService.addNewUser(newUser);
	}*/
	
	//delete user
	public void deleteExistingUser(@RequestBody User exsitingUser) {
		userService.deleteUser(exsitingUser);
	}
	
	@PostMapping("/users/update/{id}")
	//update user details
	public User updateUserDetails(@RequestBody User updatingUser) {
		return userService.updateUser(updatingUser);
	}
	
}
