package ies.p1.rooms_scanner.Service;
import ies.p1.rooms_scanner.Entities.Sensor;
import ies.p1.rooms_scanner.Entities.SensorHistory;
import ies.p1.rooms_scanner.Repository.SensorRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
@Service
public class SensorService {
    @Autowired
    SensorRepository repository;

    public void test() {
        Sensor s1 = new Sensor();
        s1.setId(1);
        s1.setSensorType("PeopleCounter");
        s1.setDataCaptured(7);

        Sensor s2 = new Sensor();
        s2.setId(2);
        s2.setSensorType("PeopleCounter");
        s2.setDataCaptured(5);

        Sensor s3 = new Sensor();
        s3.setId(3);
        s3.setSensorType("PeopleCounter");
        s3.setDataCaptured(7);

        Sensor s4 = new Sensor();
        s4.setId(4);
        s4.setSensorType("PeopleCounter");
        s4.setDataCaptured(5);

        Sensor s5 = new Sensor();
        s5.setId(5);
        s5.setSensorType("PeopleCounter");
        s5.setDataCaptured(7);

        Sensor s6 = new Sensor();
        s6.setId(6);
        s6.setSensorType("PeopleCounter");
        s6.setDataCaptured(5);

        Sensor s7 = new Sensor();
        s7.setId(7);
        s7.setSensorType("PeopleCounter");
        s7.setDataCaptured(5);

        Sensor s8 = new Sensor();
        s8.setId(8);
        s8.setSensorType("PeopleCounter");
        s8.setDataCaptured(5);

        Sensor s9 = new Sensor();
        s9.setId(9);
        s9.setSensorType("PeopleCounter");
        s9.setDataCaptured(5);

        Sensor s10 = new Sensor();
        s10.setId(10);
        s10.setSensorType("PeopleCounter");
        s10.setDataCaptured(5);

        Sensor s11 = new Sensor();
        s11.setId(11);
        s11.setSensorType("Temperature");
        s11.setDataCaptured(5);

        Sensor s12 = new Sensor();
        s12.setId(12);
        s12.setSensorType("Temperature");
        s12.setDataCaptured(5);

        Sensor s13 = new Sensor();
        s13.setId(13);
        s13.setSensorType("Temperature");
        s13.setDataCaptured(5);

        Sensor s14 = new Sensor();
        s14.setId(14);
        s14.setSensorType("Temperature");
        s14.setDataCaptured(5);

        Sensor s15 = new Sensor();
        s15.setId(15);
        s15.setSensorType("Temperature");
        s15.setDataCaptured(5);

        Sensor s16 = new Sensor();
        s16.setId(16);
        s16.setSensorType("Temperature");
        s16.setDataCaptured(5);

        Sensor s17 = new Sensor();
        s17.setId(17);
        s17.setSensorType("Temperature");
        s17.setDataCaptured(5);

        Sensor s18 = new Sensor();
        s18.setId(18);
        s18.setSensorType("Temperature");
        s18.setDataCaptured(5);

        Sensor s19 = new Sensor();
        s19.setId(19);
        s19.setSensorType("Temperature");
        s19.setDataCaptured(5);

        Sensor s20 = new Sensor();
        s20.setId(20);
        s20.setSensorType("Temperature");
        s20.setDataCaptured(5);

        createSensor(s1);
        createSensor(s2);
        createSensor(s3);
        createSensor(s4);
        createSensor(s5);
        createSensor(s6);
        createSensor(s7);
        createSensor(s8);
        createSensor(s9);
        createSensor(s10);
        createSensor(s11);
        createSensor(s12);
        createSensor(s13);
        createSensor(s14);
        createSensor(s15);
        createSensor(s16);
        createSensor(s17);
        createSensor(s18);
        createSensor(s19);
        createSensor(s20);
    }

    public boolean createSensor(Sensor s) {
        if(repository.existsById(s.getId()))
            return false;
        repository.save(s);
        return true;
    }

    public boolean updateSensor(int id,int data) {
        Sensor s = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sensor not found for this id :: " + id));

        //Update current date
        s.setDataCaptured(data);

        //Add value to sensor history
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        SensorHistory h = new SensorHistory(dtf.format(now),data);
        s.getSensor_history().add(h);
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
        return repository.getSensorById(id);
    }
}