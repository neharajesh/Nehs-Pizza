package http.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Login {
	@NotBlank
	@Size(min=2, max=60, message="Enter valid phone number")
	private Long phno;
	
	@NotBlank
	@Size(min=2, max=60, message="Enter valid password")
	private String password;

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
