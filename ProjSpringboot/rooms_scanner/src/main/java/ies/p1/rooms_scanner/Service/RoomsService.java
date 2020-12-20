package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.Rooms;
import ies.p1.rooms_scanner.Repository.RoomsRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class RoomsService implements RoomsServiceInt {
    @Autowired
    RoomsRepository repository;

    public void test() {
        Rooms r1 = new Rooms();
        r1.setId(1);
        r1.setDepartment("DETI");
        r1.setFloor(2);
        r1.setBusySeats(3);
        r1.setMaxSeats(20);
        repository.findById(r1.getId());

        Rooms r2 = new Rooms();
        r2.setId(2);
        r2.setDepartment("DMAT");
        r2.setFloor(1);
        r2.setBusySeats(5);
        r2.setMaxSeats(25);
        repository.findById(r2.getId());

        createRoom(r1);
        createRoom(r2);
    }

    @Override
    public boolean createRoom(Rooms room) {
        if(repository.existsById(room.getId()))
            return false;
        repository.save(room); //TODO: ver se dá algum return de sucesso
        return true;
    }

    @Override
    public boolean updateRoom(Long id, int maxSeats,int busySeats) {
        Rooms r = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + id));
        r.setBusySeats(busySeats);
        if (maxSeats != -1)
            r.setMaxSeats(maxSeats);
        repository.save(r);
        return true;
    }
    @Override
    public boolean deleteRoom(Long id) {
        repository.deleteById(id);
        return true;
    }
    @Override
    public Collection<Rooms> getRooms() {
        return repository.findAll();
    }
}