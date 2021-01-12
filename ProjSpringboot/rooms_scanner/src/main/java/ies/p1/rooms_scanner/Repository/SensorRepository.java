package ies.p1.rooms_scanner.Repository;
import ies.p1.rooms_scanner.Entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface SensorRepository extends  JpaRepository<Sensor, Integer>{
    List<Sensor> findAll();
    Sensor getSensorById (int id);
}
