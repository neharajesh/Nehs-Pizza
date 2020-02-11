package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enums.StatusTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
	//private StatusType status; 		change this later
	private int flag;
	
	@OneToOne
	private Items itemId;
	
	@Enumerated(EnumType.STRING)
	private StatusTypes status;

	public int getId() {
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

	public StatusTypes getStatus() {
		return status;
	}

	public void setStatus(StatusTypes status) {
		this.status = status;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Items getItemId() {
		return itemId;
	}

	public void setItemId(Items itemId) {
		this.itemId = itemId;
	}
	
	
	
}
