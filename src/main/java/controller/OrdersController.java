/*package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Order;
import exceptions.RecordNotFoundException;
import service.OrderService;

@RestController
@RequestMapping(OrdersController.BASE_URL)
public class OrdersController {
	static final String BASE_URL = "/api/auth/orders";
	@Autowired
	private OrderService orderService;
	
	//to get all orders
	@GetMapping()
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String all (Model model) {
		List<Order> orders = orderService.findAllOrders();
		model.addAttribute("orders", orders);
		return "ordersAll";
	}
	
	//to get all live orders
	@GetMapping("/live")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL') or hasRole('DELIVERY')")
	public String live(Model model) throws RecordNotFoundException{
		List<Order> liveorders = orderService.findLiveOrders();
		model.addAttribute("liveorders", liveorders);
		return "ordersLive";
	}
	
	//to get all past orders
	@GetMapping("/past")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String past(Model model) throws RecordNotFoundException{
		List<Order> pastorders = orderService.findPastOrders();
		model.addAttribute("pastorders", pastorders);
		return "ordersPast";
	}
	
	//get past orders based on user id
	@GetMapping("/past/{id}")
	public String pastBasedOnId(@RequestParam("id") int userId, Model model) throws RecordNotFoundException{
		List<Order> pastorders = orderService.findPastOrdersBasedOnUserId(userId);
		model.addAttribute("pastordersid", pastorders);
		return "ordersPastById";
	}
	
	//find order by id
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL')")
	public String findById(@RequestParam("id") int id, Model model) throws RecordNotFoundException{
		Order order = orderService.findOrderById(id);
		model.addAttribute("order", order);
		return "orderbyid";
	}
	
	//add new order
	@PostMapping("/new")
	@PreAuthorize("hasRole('MANAGER') or hasRole('GENERAL') or hasRole('USER')")
	public Order newOrder(@RequestBody Order newOrder) throws RecordNotFoundException {
		return null;//orderService.addNewOrder(newOrder);
	}
	
	//add update order
	
}
*/