package ies.p1.rooms_scanner.Repository;
import ies.p1.rooms_scanner.Entities.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface RoomsRepository extends  JpaRepository<Rooms,Integer>{

    //@Query(value = "SELECT i FROM Rooms i ")
    List<Rooms> findAll();

    List<Rooms> findAllByDepartment(String department);
    List<Rooms> findAllByDepartmentAndAndFloor(String department, int floor);
}
