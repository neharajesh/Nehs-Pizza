package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Order;
import service.OrderService;

@RestController
public class OrdersController {
	@Autowired
	private OrderService orderService;
	
	//to get all orders
	@GetMapping("/orders")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String all (Model model) {
		List<Order> orders = orderService.findAllOrders();
		model.addAttribute("orders", orders);
		return "allorders";
	}
	
	//to get all live orders
	@GetMapping("/orders/live")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL') or hasRole('DELIVERY')")
	public String live(Model model) {
		List<Order> liveorders = orderService.findLiveOrders();
		model.addAttribute("liveorders", liveorders);
		return "liveorders";
	}
	
	//to get all past orders
	@GetMapping("/orders/past")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String past(Model model) {
		List<Order> pastorders = orderService.findPastOrders();
		model.addAttribute("pastorders", pastorders);
		return "pastorders";
	}
	
	//find order by id
	@GetMapping("/orders/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String findById(@RequestParam int id, Model model) {
		Order order = orderService.findOrderById(id);
		model.addAttribute("order", order);
		return "orderbyid";
	}
	
	//add new order
	@PostMapping("/neworder")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL') or hasRole('USER')")
	public Order newOrder(@RequestBody Order newOrder) {
		return orderService.addNewOrder(newOrder);
	}
	
}
