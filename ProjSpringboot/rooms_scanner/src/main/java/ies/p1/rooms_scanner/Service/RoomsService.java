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
public class RoomsService {
    @Autowired
    RoomsRepository repository;
    @Autowired
    SensorRepository sensorRepo;

    public void test() {
        Rooms r1 = new Rooms();
        r1.setId(1);
        r1.setDepartment("DETI");
        r1.setFloor(2);
        r1.setMaxSeats(20);

        Rooms r2 = new Rooms();
        r2.setId(2);
        r2.setDepartment("DMAT");
        r2.setFloor(1);
        r2.setMaxSeats(25);

        createRoom(r1);
        createRoom(r2);
    }

    public boolean createRoom(Rooms room) {
        if(repository.existsById(room.getId()))
            return false;
        repository.save(room);
        return true;
    }

    public boolean updateRoom(int id, int maxSeats) {
        Rooms r = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + id));
        r.setMaxSeats(maxSeats);
        repository.save(r);
        return true;
    }

    public boolean updateSensorRoom(int roomID,int sensorId) {
        Rooms r = repository.findById(roomID).orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomID));
        if(sensorRepo.existsById(sensorId)){
            System.out.println(r.getSensorList());
            r.getSensorList().add(sensorRepo.getById(sensorId));
            System.out.println(r.getSensorList());
            repository.save(r);
            return true;
        }
        return false;
    }

    public boolean deleteRoom(int id) {
        repository.deleteById(id);
        return true;
    }
    public Collection<Rooms> getRooms() {
        return repository.findAll();
    }
}