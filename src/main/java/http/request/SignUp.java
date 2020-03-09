/*package http.request;

import java.util.Set;

import javax.validation.constraints.*;

import enums.UserRoles;
 
public class SignUp {
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;
 
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;
 
    @NotBlank
    @Size(max = 60, message="enter 10 digit phone number")
    private String phno;
    
    private Set<UserRoles> role;
    
    @Size(max=60, message="enter valid email")
    private String email;
    
    @NotBlank
    @Size(min = 6, max = 40, message="enter a valid password")
    private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public Set<UserRoles> getRole() {
		return role;
	}

	public void setRole(Set<UserRoles> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
 
        
}*/