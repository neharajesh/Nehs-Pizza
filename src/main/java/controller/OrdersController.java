package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import entities.Order;
import service.OrderService;

@RestController
public class OrdersController {
	@Autowired
	private OrderService orderService;
	
	//to get all orders
	@GetMapping("/orders")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	List<Order> all () {
		return orderService.findAllOrders();
	}
	
	//to get all live orders
	@GetMapping("/liveorders")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL') or hasRole('DELIVERY')")
	public List<Order> live() {
		return orderService.findLiveOrders();
	}
	
	//to get all past orders
	@GetMapping("/pastorders")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public List<Order> past() {
		return orderService.findPastOrders();
	}
	
	//find order by id
	@GetMapping("/ordersbyid")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public Order findById(int id) {
		return orderService.findOrderById(id);
	}
	
	//add new order
	@PostMapping("/neworder")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL') or hasRole('USER')")
	public Order newOrder(@RequestBody Order newOrder) {
		return orderService.addNewOrder(newOrder);
	}
	
}
