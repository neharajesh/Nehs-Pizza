package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findByEmail(String email);
	Optional<UserEntity> findByPhno(String phno);
    Boolean existsByPhno(String phno);
    Boolean existsByEmail(String email);
}
