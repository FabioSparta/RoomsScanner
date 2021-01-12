package ies.p1.rooms_scanner.Repository;

import ies.p1.rooms_scanner.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}