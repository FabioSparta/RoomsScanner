package ies.p1.rooms_scanner.Repository;
import ies.p1.rooms_scanner.Entities.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import org.springframework.data.jpa.repository.Query;

public interface RoomsRepository extends  JpaRepository<Rooms,Long>{
    List<Rooms> findAll();
    @Query(value = "SELECT i FROM Rooms i WHERE busySeats < maxSeats")
    List<Rooms> findAllEmptyRooms();
    List<Rooms> findAllByDepartment(String department);
    List<Rooms> findAllByDepartmentAndAndFloor(String department, int floor);
}
