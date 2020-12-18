package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.Rooms;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoomsService implements RoomsServiceInt {
    private static Map<Long, Rooms> roomRepo = new HashMap<>();
    static { //PARA TESTE
        Rooms r1 = new Rooms();
        r1.setId(1);
        r1.setDepartment("DETI");
        r1.setFloor(2);
        r1.setBusySeats(3);
        r1.setMaxSeats(20);
        roomRepo.put(r1.getId(), r1);

        Rooms r2 = new Rooms();
        r2.setId(2);
        r2.setDepartment("DMAT");
        r2.setFloor(1);
        r2.setBusySeats(5);
        r2.setMaxSeats(25);
        roomRepo.put(r2.getId(), r2);
    }
    @Override
    public void createRoom(Rooms room) {
        roomRepo.put(room.getId(), room);
    }

    @Override
    public void updateRoom(Long id, Rooms r) {
        roomRepo.remove(id);
        r.setId(id);
        roomRepo.put(id, r);
    }
    @Override
    public void deleteRoom(Long id) {
        roomRepo.remove(id);
    }
    @Override
    public Collection<Rooms> getRooms() {
        return roomRepo.values();
    }
}