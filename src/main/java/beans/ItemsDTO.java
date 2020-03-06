package beans;

import enums.ItemAttributes;
import lombok.Data;

@Data
public class ItemsDTO {
	private int item;
	private String name;
	private ItemAttributes itemAttributes;
}
