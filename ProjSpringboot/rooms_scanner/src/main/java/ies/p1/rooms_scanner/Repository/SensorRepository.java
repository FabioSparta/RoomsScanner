package ies.p1.rooms_scanner.Repository;
import ies.p1.rooms_scanner.Entities.Sensor;
import ies.p1.rooms_scanner.Entities.SensorHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface SensorRepository extends  JpaRepository<Sensor, Integer>{

    @Query(value = "SELECT id,data_captured,sensor_type FROM sensors", nativeQuery = true)
    List<Sensor> findAll();

    Sensor getSensorById (int id);


}
