package ies.p1.rooms_scanner.Repository;
import ies.p1.rooms_scanner.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface RoomsRepository extends  JpaRepository<Room,Integer>{
    List<Room> findAll();
    List<Room> findAllByDepartment(String department);
    List<Room> findAllByFloor(int floor);
    List<Room> findAllByDepartmentAndFloor(String department, int floor);
    Room getRoomsById (int id);
}
