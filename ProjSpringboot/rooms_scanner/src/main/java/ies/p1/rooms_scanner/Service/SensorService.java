package ies.p1.rooms_scanner.Service;
import ies.p1.rooms_scanner.Entities.Sensor;
import ies.p1.rooms_scanner.Repository.SensorRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class SensorService {
    @Autowired
    SensorRepository repository;

    public void test() {
        Sensor s1 = new Sensor();
        s1.setSensorType("PeopleCounter");
        s1.setDataCaptured(7);

        Sensor s2 = new Sensor();
        s2.setSensorType("Temperature");
        s2.setDataCaptured(5);

        createSensor(s1);
        createSensor(s2);
    }

    public boolean createSensor(Sensor s) {
        if(repository.existsById(s.getId()))
            return false;
        repository.save(s);
        return true;
    }

    public boolean updateSensor(int id,int data) {
        Sensor s = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sensor not found for this id :: " + id));
        s.setId(id);
        s.setDataCaptured(data);
        repository.save(s);
        return true;
    }

    public boolean deleteSensor(int id) {
        repository.deleteById(id);
        return true;
    }
    public Collection<Sensor> getSensors() {
        return repository.findAll();
    }
    public Sensor getSensorsById(int id) {
        return repository.getById(id);
    }
}