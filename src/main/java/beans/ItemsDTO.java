package beans;

import enums.ItemAttributes;
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
public class ItemsDTO {
	private int item;
	private String name;
	private ItemAttributes itemAttributes;
}
