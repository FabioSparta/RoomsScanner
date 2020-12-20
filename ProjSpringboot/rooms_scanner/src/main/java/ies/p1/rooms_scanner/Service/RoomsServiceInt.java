package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.Rooms;

import java.util.Collection;

public interface RoomsServiceInt {
    public abstract boolean createRoom(Rooms room);

    public abstract boolean updateRoom(Long id, int maxSeats,int busySeats);

    public abstract boolean deleteRoom(Long id);

    public abstract Collection<Rooms> getRooms();
}
