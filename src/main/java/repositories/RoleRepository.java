package repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Roles;
import entities.User;
import enums.UserRoles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByName(UserRoles roleName);
    List<User> findUsersByRole(UserRoles roleName);
}