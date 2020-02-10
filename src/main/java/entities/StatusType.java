package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import enums.Status;

@Entity
public class StatusType {
	private int id;
	@ManyToOne
	private Status name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Status getName() {
		return name;
	}
	public void setName(Status name) {
		this.name = name;
	}
	
}
