package ies.p1.rooms_scanner.Repository;
import ies.p1.rooms_scanner.Entities.Room;
import ies.p1.rooms_scanner.Entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface SensorRepository extends  JpaRepository<Sensor, Integer>{
    List<Sensor> findAll();
    Sensor getSensorById (int id);

    //MySql -> select rooms.max_seats,sensors.data_captured from rooms inner join sensors on rooms.id = sensors.room_id where sensors.id=2;

    @Query(value="select rooms.max_seats from rooms inner join sensors on rooms.id = sensors.room_id where sensors.id=?1",nativeQuery = true)
    int getMaxSeatsBySensorID(int id);

    @Query(value="select rooms.number from rooms inner join sensors on rooms.id = sensors.room_id where sensors.id=?1",nativeQuery = true)
    String getNumberBySensorID(int id);

    @Query(value="select rooms.department from rooms inner join sensors on rooms.id = sensors.room_id where sensors.id=?1",nativeQuery = true)
    String getDepartmentBySensorID(int id);
}
