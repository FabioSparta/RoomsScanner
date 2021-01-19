package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.Room;
import ies.p1.rooms_scanner.Entities.Sensor;
import ies.p1.rooms_scanner.Entities.User;
import ies.p1.rooms_scanner.Repository.SensorRepository;
import ies.p1.rooms_scanner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserService{
    @Autowired
    UserRepository repository;

    public boolean createUser(User u) {
        if(repository.existsById(u.getNmec())){
            System.out.println("nmec repetido");
            return false;
        }
        repository.save(u);
        return true;
    }

    public User exist(String username,String pw) { return repository.getUserByUsernameAndAndPassword(username,pw); }
    public User getUserByUsername(String username) {return repository.getUserByUsername(username);}

}
