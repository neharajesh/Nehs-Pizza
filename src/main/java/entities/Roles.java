package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.UserRoles;

@Entity
public class Roles {
	private int id;
	
	@Enumerated(EnumType.STRING)
	private UserRoles name;
	
	public int getId() {
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
	}
	
}
