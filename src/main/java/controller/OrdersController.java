package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import entities.OrderEntity;
import service.OrderService;

@RestController
public class OrdersController {
	@Autowired
	private OrderService orderService;
	
	//to get all orders
	@GetMapping("/orders")
	List<OrderEntity> all () {
		return orderService.findAllOrders();
	}
	
	//to get all live orders
	@GetMapping("/orders/live")
	public List<OrderEntity> live() {
		return orderService.findLiveOrders();
	}
	
	//to get all past orders
	@GetMapping("/orders/past")
	public List<OrderEntity> past() {
		return orderService.findPastOrders();
	}
	
	//find order by id
	@GetMapping("/orders/{id}")
	public OrderEntity findById(int id) {
		return orderService.findOrderById(id);
	}
	
	//add new order
	@PostMapping("/order/new")
	public OrderEntity newOrder(@RequestBody OrderEntity newOrder) {
		return orderService.addNewOrder(newOrder);
	}
	
}
