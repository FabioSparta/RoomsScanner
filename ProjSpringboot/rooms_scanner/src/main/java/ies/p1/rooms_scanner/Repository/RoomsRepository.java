package ies.p1.rooms_scanner.Repository;
import ies.p1.rooms_scanner.Entities.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface RoomsRepository extends  JpaRepository<Rooms,Integer>{
    List<Rooms> findAll();
    List<Rooms> findAllByDepartment(String department);
    List<Rooms> findAllByDepartmentAndAndFloor(String department, int floor);
}
