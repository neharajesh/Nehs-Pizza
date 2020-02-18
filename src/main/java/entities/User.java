package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;*/

import entities.Roles.RolesBuilder;
import enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phno;

	private String password;
	
	@OneToMany
	private Address addressId;
	
	@Enumerated(EnumType.STRING)
	private UserRoles userType;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "user_roles", 
	      joinColumns = @JoinColumn(name = "user_id"), 
	      inverseJoinColumns = @JoinColumn(name = "role_id"))
	    //private Set<Roles> roles = new HashSet()<>();
	 private Set<Roles> roles = new HashSet<>();
	 
	 /*public User() {}
	 
	    public User(String firstName, String lastName, String phno, String email, String password) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.phno = phno;
	        this.email = email;
	        this.password = password;
	    }	 
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

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

		public String getPhno() {
			return phno;
		}

		public void setPhno(String phno) {
			this.phno = phno;
		}

		public Address getAddressId() {
			return addressId;
		}

		public void setAddressId(Address addressId) {
			this.addressId = addressId;
		}

		public UserRoles getUserType() {
			return userType;
		}

		public void setUserType(UserRoles userType) {
			this.userType = userType;
		}

		public Set<Roles> getRoles() {
			return roles;
		}

		public void setRoles(Set<Roles> roles) {
			this.roles = roles;
		}*/



		/*public class Builder {
			 private  String firstName;
			 private  String lastName;
			 private  String phno;
			 private  String email;
			 private  String password;
			 
			 public Builder() {}

			public Builder setFirstName(String firstName) {
				this.firstName = firstName;
				return this;
			}

			public Builder setLastName(String lastName) {
				this.lastName = lastName;
				return this;
			}


			public Builder setPhno(String phno) {
				this.phno = phno;
				return this;
			}


			public Builder setEmail(String email) {
				this.email = email;
				return this;
			}


			public Builder setPassword(String password) {
				this.password = password;
				return this;
			}
			 
			 public User build() {
				 return new User(firstName, lastName, phno, email, password);
			 }
		}*/
}
	
		

