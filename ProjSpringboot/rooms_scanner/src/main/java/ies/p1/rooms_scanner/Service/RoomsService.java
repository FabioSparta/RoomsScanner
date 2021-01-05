package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.Rooms;
import ies.p1.rooms_scanner.Repository.RoomsRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class RoomsService {
    @Autowired
    RoomsRepository repository;

    public void test() {
        Rooms r1 = new Rooms();
        r1.setId(1);
        r1.setDepartment("DETI");
        r1.setFloor(2);
        r1.setMaxSeats(20);
        repository.findById(r1.getId());

        Rooms r2 = new Rooms();
        r2.setId(2);
        r2.setDepartment("DMAT");
        r2.setFloor(1);
        r2.setMaxSeats(25);
        repository.findById(r2.getId());

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
        Rooms ret = repository.save(r);
        return true;
    }

    public boolean deleteRoom(int id) {
        repository.deleteById(id);
        return true;
    }
    public Collection<Rooms> getRooms() {
        return repository.findAll();
    }
}