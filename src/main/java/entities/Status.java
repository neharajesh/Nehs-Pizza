package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import enums.StatusTypes;

@Entity
public class Status {
	private int id;
	@ManyToOne
	private StatusTypes name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StatusTypes getName() {
		return name;
	}
	public void setName(StatusTypes name) {
		this.name = name;
	}
	
}
