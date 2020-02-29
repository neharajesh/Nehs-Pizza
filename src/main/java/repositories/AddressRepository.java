package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	Optional<Address> findByUserId(int userId);
	 
}
