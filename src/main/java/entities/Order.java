package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name="order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order;
	
	@ManyToOne
	private User customer;
	
	@ManyToOne
	private User staff;
	
	@ManyToOne
	private User delivery;
	
	private Date orderedDateTime;
	private Date expectedDateTime;
	private String extraInstructions;
	private StatusTypes status;

	@ManyToMany
	private List<Items> item;
	
}
