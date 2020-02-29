package beans;

import java.util.Date;
import java.util.List;

import entities.Items;
import entities.User;
import enums.StatusTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private int order;
	private User customer;
	private User staff;
	private User delivery;
	private Date orderedDateTime;
	private Date expectedDateTime;
	private String extraInstructions;
	private StatusTypes status;
	private List<Items> item;
}
