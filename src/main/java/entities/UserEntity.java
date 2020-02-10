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

import enums.User;

@Entity
@Table(name="users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Long phno;
	
	@OneToMany
	private AddressEntity addressId;
	
	@Enumerated(EnumType.STRING)
	private User userType;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "user_roles", 
	      joinColumns = @JoinColumn(name = "user_id"), 
	      inverseJoinColumns = @JoinColumn(name = "role_id"))
	    //private Set<Roles> roles = new HashSet()<>();
	 private Set<Roles> roles = new HashSet<>();
	 
	 public UserEntity() {}
	 
	    public UserEntity(String firstName, String lastName, Long phno, String email, String password) {
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

		public Long getPhno() {
			return phno;
		}

		public void setPhno(Long phno) {
			this.phno = phno;
		}

		public AddressEntity getAddressId() {
			return addressId;
		}

		public void setAddressId(AddressEntity addressId) {
			this.addressId = addressId;
		}

		public User getUserType() {
			return userType;
		}

		public void setUserType(User userType) {
			this.userType = userType;
		}

		public Set<Roles> getRoles() {
			return roles;
		}

		public void setRoles(Set<Roles> roles) {
			this.roles = roles;
		}

	
	
	
}
