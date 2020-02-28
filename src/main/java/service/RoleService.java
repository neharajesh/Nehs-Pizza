package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.User;
import enums.UserRoles;
import repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	//find users based on role
	public List<User> findUsersBasedOnRole(UserRoles roleName) {
		return roleRepository.findUsersByRole(roleName);
		
	}
}
