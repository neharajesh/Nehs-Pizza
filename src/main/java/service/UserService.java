package service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import entities.Roles;
import entities.User;
import enums.UserRoles;
import http.request.SignUp;
import repositories.RoleRepository;
import repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	 private PasswordEncoder encoder;
	 
	 @Autowired
	 private RoleRepository roleRepository;
	
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
	public User addNewUser(SignUp signUpRequest) {
		 User user = User.builder()
	                .firstName(signUpRequest.getFirstName())
	                .lastName(signUpRequest.getLastName())
	                .phno(signUpRequest.getPhno())
	                .email(signUpRequest.getEmail())
	                .password(encoder.encode(signUpRequest.getPassword()))
	                .build();
		 Set<UserRoles> strRoles = signUpRequest.getRole();
	        Set<Roles> roles = new HashSet<>();
	 
	        strRoles.forEach(role -> {
	          switch(role) {
	          case MANAGER:
	            Roles managerRole = roleRepository.findByName(UserRoles.MANAGER)
	                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
	            roles.add(managerRole);
	            
	            break;
	          case GENERAL:
	                Roles generalRole = roleRepository.findByName(UserRoles.GENERAL)
	                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
	                roles.add(generalRole);
	                
	            break;
	          case DELIVERY:
	              Roles deliveryRole = roleRepository.findByName(UserRoles.DELIVERY)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
	              roles.add(deliveryRole);
	              
	          break;
	          default:
	        	  Roles userRole = roleRepository.findByName(UserRoles.USER)
	                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
	              roles.add(userRole);              
	          }
	        });
	        
	        user.setRoles(roles);
		
		return userRepository.save(user);
	}
	
	//delete user
	public void deleteUser(User userEntity) {
		userRepository.delete(userEntity);
	}
	
	//update user
	public User updateUser(User userEntity) {
		return userRepository.save(userEntity);
	}
}