package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.User;

@Entity
public class Roles {
	private int id;
	
	@Enumerated(EnumType.STRING)
	private User name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getName() {
		return name;
	}
	public void setName(User name) {
		this.name = name;
	}
	
}
