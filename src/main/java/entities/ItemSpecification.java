package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.ItemAttributes;
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
@Table
public class ItemSpecification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemspec;
	
	@Enumerated(EnumType.STRING)
	private ItemAttributes itemAttribute;
	
	private String value;
}
