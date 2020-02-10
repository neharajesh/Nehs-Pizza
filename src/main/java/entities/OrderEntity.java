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

import enums.Status;
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
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private UserEntity customer;
	private UserEntity staff;
	private UserEntity delivery;
	private Date orderedDateTime;
	private Date expectedDateTime;
	private String extraInstructions;
	//private StatusType status; 		change this later
	private int flag;
	
	@OneToOne
	private ItemsEntity itemId;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}

	public UserEntity getStaff() {
		return staff;
	}

	public void setStaff(UserEntity staff) {
		this.staff = staff;
	}

	public UserEntity getDelivery() {
		return delivery;
	}

	public void setDelivery(UserEntity delivery) {
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public ItemsEntity getItemId() {
		return itemId;
	}

	public void setItemId(ItemsEntity itemId) {
		this.itemId = itemId;
	}
	
	
	
}
