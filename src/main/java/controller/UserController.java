package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import beans.UserDTO;
import entities.User;
import enums.UserRoles;
import exceptions.RecordNotFoundException;
import service.RoleService;
import service.UserService;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
	static final String BASE_URL = "/api/auth/user";
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	//get all user details
	@GetMapping("/all")
	@PreAuthorize("hasRole('MANAGER')")
	public String all(
					/*@RequestBody User user, */
					Model model) {
		List<UserDTO> allUsers = userService.findAllUserDetails();
		model.addAttribute("users", allUsers);
		return "usersAll";
	}
	
	//get user details by phno
	@GetMapping("/{phno}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('STAFF')")
	public String getDetailsByPhno(@RequestParam("phno") String phno, Model model) throws RecordNotFoundException{
		UserDTO user = userService.findUserByPhno(phno);
		model.addAttribute("user", user);
		return "userByPhno";
	}
	
	//get user details by email
	@GetMapping("/{email}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('STAFF')")
	public String getDetailsByEmail(@RequestParam("email") String email, Model model) throws RecordNotFoundException{
		UserDTO user = userService.findUserByEmail(email);
		model.addAttribute("user", user);
		return "userByEmail";
	}
		
	//get users based on role
	@GetMapping("/{usertype}")
	@PreAuthorize("hasRole('MANAGER')")
	public List<User> findUsersBasedOnRole(@RequestParam UserRoles roleName, Model model) throws RecordNotFoundException{
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
	
	//update user details
	@PostMapping("/update/{id}")
	public String updateUserDetails(@RequestParam User updatingUser, Model model) {
		User updated = userService.updateUser(updatingUser);
		model.addAttribute("updated", updated);
		return "userUpdate";
		
		//or return find item by id page by passing this id 
	}
	
}
