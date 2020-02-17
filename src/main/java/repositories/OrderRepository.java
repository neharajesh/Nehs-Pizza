package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	public List<Order> getOrdersByUserId(int userId); //can be used to find past orders for delivery guy and for user
}
