package entities;

import java.util.HashSet;
import java.util.List;
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
	private int user;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phno;

	private String password;
	
	@OneToMany
	private List<Address> address;
	
	@Enumerated(EnumType.STRING)
	private UserRoles userType;
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Roles> roles = new HashSet<>();

}
	
		

