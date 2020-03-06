package beans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entities.Address;
import entities.Roles;
import enums.UserRoles;
import lombok.Data;

@Data
public class UserDTO {
	private int user;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phno;
	private List<Address> address;
	private UserRoles userType;
	private Set<Roles> roles = new HashSet<>();
}
