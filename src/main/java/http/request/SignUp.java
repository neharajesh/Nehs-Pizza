package http.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignUp {
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;
 
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;
 
    @NotBlank
    @Size(max = 60)
    @Email
    private Long phno;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
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

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
        
}