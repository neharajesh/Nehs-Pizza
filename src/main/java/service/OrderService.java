/*package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Order;
import enums.StatusTypes;
import repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	//find all orders
	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}
	
	//find live orders
	public List<Order> findLiveOrders() {
		List<Order> all = orderRepository.findAll();
		ArrayList<Order> live = new ArrayList<Order>();
		for(Order orderEntity : all) {
			if(orderEntity.getStatus().getName() == StatusTypes.PLACED || 
				orderEntity.getStatus().getName() == StatusTypes.PREPARING ) {
				live.add(orderEntity);
			}
		}
		return live;
	}
	
	//find past orders
	public List<Order> findPastOrders() {
		List<Order> all = orderRepository.findAll();
		ArrayList<Order> past = new ArrayList<Order>();
		for(Order orderEntity : all) {
			if(orderEntity.getStatus().getName() == StatusTypes.DELIVERED ||
				orderEntity.getStatus().getName() == StatusTypes.DISPATCHED) {
				past.add(orderEntity);
			}
		}
		return null;
	}
	
	//find past orders based on user id
	public List<Order> findPastOrdersBasedOnUserId(int userId) {
		return orderRepository.getOrdersByUserId(userId);
	}
	
	//get order by id
	public Order findOrderById(int id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}
	
	//add order
	public Order addOrUpdateOrder(Order orderEntity) {
		Optional<Order> order = orderRepository.findById(orderEntity.getId());
		if(order.isPresent()) {
			Order updatedOrder = order.get();
			updatedOrder.setCustomer(orderEntity.getCustomer());
			updatedOrder.setDelivery(orderEntity.getDelivery());
			updatedOrder.setExpectedDateTime(orderEntity.getExpectedDateTime());
			updatedOrder.setExtraInstructions(orderEntity.getExtraInstructions());
			updatedOrder.setItemId(orderEntity.getItemId());
			updatedOrder.setOrderedDateTime(orderEntity.getOrderedDateTime());
			updatedOrder.setStaff(orderEntity.getStaff());
			updatedOrder.setStatus(orderEntity.getStatus());
			
			return orderRepository.save(updatedOrder);
		}
		else
			return orderRepository.save(orderEntity);
	}
	
	//cancel or delete order
	public void cancelOrder(Order order) {
		orderRepository.delete(order);
	}
	
	
}
*/