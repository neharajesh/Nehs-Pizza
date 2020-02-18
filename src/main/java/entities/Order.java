package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private int id;
	private User customer;
	private User staff;
	private User delivery;
	private Date orderedDateTime;
	private Date expectedDateTime;
	private String extraInstructions;
	private Status status; 		//change this later

	@OneToOne
	private Items itemId;


	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public User getStaff() {
		return staff;
	}

	public void setStaff(User staff) {
		this.staff = staff;
	}

	public User getDelivery() {
		return delivery;
	}

	public void setDelivery(User delivery) {
		this.delivery = delivery;
	}

	public Date getOrderedDateTime() {
		return orderedDateTime;
	}

	public void setOrderedDateTime(Date orderedDateTime) {
		this.orderedDateTime = orderedDateTime;
	}

	public Date getExpectedDateTime() {
		return expectedDateTime;
	}

	public void setExpectedDateTime(Date expectedDateTime) {
		this.expectedDateTime = expectedDateTime;
	}

	public String getExtraInstructions() {
		return extraInstructions;
	}

	public void setExtraInstructions(String extraInstructions) {
		this.extraInstructions = extraInstructions;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Items getItemId() {
		return itemId;
	}

	public void setItemId(Items itemId) {
		this.itemId = itemId;
	}
	*/
	
	
}
