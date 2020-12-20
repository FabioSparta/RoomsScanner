package ies.p1.rooms_scanner.Service;
import ies.p1.rooms_scanner.Entities.Rooms;
import ies.p1.rooms_scanner.Entities.Sensor;
import ies.p1.rooms_scanner.Repository.RoomsRepository;
import ies.p1.rooms_scanner.Repository.SensorRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class SensorService {
    @Autowired
    SensorRepository repository;
    RoomsRepository roomRepo;

    public void test() {
        Sensor s1 = new Sensor();
        s1.setId(1);
        s1.setSensorType("PeopleCounter");
        s1.setRoom(roomRepo.getRoomsById(1));
        s1.setDataCaptured(7);

        Sensor s2 = new Sensor();
        s2.setId(2);
        s2.setSensorType("Temperature");
        s2.setRoom(roomRepo.getRoomsById(2));
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

    public boolean updateSensorRoom(int sensorId,Rooms r) {
        Sensor s = repository.findById(sensorId).orElseThrow(() -> new ResourceNotFoundException("Sensor not found for this id :: " + sensorId));
        if(roomRepo.existsById(r.getId())){
            s.setRoom(r);
            repository.save(s);
            return true;
        }
        return false;
    }
    public boolean updateSensorType(int sensorId,String type) {
        Sensor s = repository.findById(sensorId).orElseThrow(() -> new ResourceNotFoundException("Sensor not found for this id :: " + sensorId));
        s.setSensorType(type);
        return true;
    }
    public boolean deleteSensor(int id) {
        repository.deleteById(id);
        return true;
    }
    public Collection<Sensor> getSensores() {
        return repository.findAll();
    }
}