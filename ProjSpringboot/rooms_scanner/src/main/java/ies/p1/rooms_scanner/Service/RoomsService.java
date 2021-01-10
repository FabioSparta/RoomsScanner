package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.Room;
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
        Room r1 = new Room();
        r1.setDepartment("DETI");
        r1.setFloor(2);
        r1.setDnumber(4);
        r1.setMaxSeats(20);
        r1.setNumber("04.02.02");


        Room r2 = new Room();
        r2.setDnumber(11);
        r2.setDepartment("DMAT");
        r2.setFloor(1);
        r2.setMaxSeats(25);
        r2.setNumber("11.01.10");

        createRoom(r1);
        createRoom(r2);
    }

    public boolean createRoom(Room room) {
        if(repository.existsById(room.getId()))
            return false;
        repository.save(room);
        return true;
    }

    public boolean updateRoom(int id, int maxSeats) {
        Room r = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + id));
        r.setMaxSeats(maxSeats);
        repository.save(r);
        return true;
    }

    public boolean updateSensorRoom(int roomID,int sensorId) {
        Room r = repository.findById(roomID).orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomID));
        if(sensorRepo.existsById(sensorId)){
            r.getSensorList().add(sensorRepo.getById(sensorId));
            repository.save(r);
            return true;
        }
        return false;
    }

    public boolean removeSensorRoom(int roomID,int sensorId) {
        Room r = repository.findById(roomID).orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomID));
        if(sensorRepo.existsById(sensorId)){
            int i = r.getSensorList().indexOf(sensorRepo.getById(sensorId));
            r.getSensorList().remove(i);
            repository.save(r);
            return true;
        }
        return false;
    }
    public boolean deleteRoom(int id) {
        repository.deleteById(id);
        return true;
    }
    public Collection<Room> getRooms() {
        return repository.findAll();
    }
}