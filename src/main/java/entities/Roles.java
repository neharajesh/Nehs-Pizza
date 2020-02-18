package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
public class Roles {
	private int id;
	
	@Enumerated(EnumType.STRING)
	private UserRoles name;
	
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserRoles getName() {
		return name;
	}
	public void setName(UserRoles name) {
		this.name = name;
	}*/
	
}
