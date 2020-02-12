package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer>{
	Optional<Items> findByName(String name);
}
