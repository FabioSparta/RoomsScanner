package ies.p1.rooms_scanner.Repository;

import ies.p1.rooms_scanner.Entities.Sensor;
import ies.p1.rooms_scanner.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findAll();
    User getUserByUsername (String username);
    User getUserByUsernameAndAndPassword(String username, String password);
    User getUserByNmec(int nmec);

}
