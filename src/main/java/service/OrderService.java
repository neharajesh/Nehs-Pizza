package service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.OrderEntity;
import repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	//find all orders
	public List<OrderEntity> findAllOrders() {
		return orderRepository.findAll();
	}
	
	//find live orders
	public List<OrderEntity> findLiveOrders() {
		List<OrderEntity> all = orderRepository.findAll();
		ArrayList<OrderEntity> live = new ArrayList<OrderEntity>();
		for(OrderEntity a : all) {
			if(a.getFlag() == 1) {
				live.add(a);
			}
		}
		return live;
	}
	
	//find past orders
	public List<OrderEntity> findPastOrders() {
		List<OrderEntity> all = orderRepository.findAll();
		ArrayList<OrderEntity> past = new ArrayList<OrderEntity>();
		for(OrderEntity a : all) {
			if(a.getFlag() == 0) {
				past.add(a);
			}
		}
		return null;
	}
	
	//get order by id
	public OrderEntity findOrderById(int id) {
		return orderRepository.findById(id).get();
	}
	
	//add order
	public OrderEntity addNewOrder(OrderEntity oe) {
		return orderRepository.save(oe);

	}
}
