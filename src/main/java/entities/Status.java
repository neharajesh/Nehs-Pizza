package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.StatusTypes;
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
public class Status {
	private int id;
	
	@Enumerated(EnumType.STRING)
	private StatusTypes name;
	
	/*public int getId() {
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
	*/
}
