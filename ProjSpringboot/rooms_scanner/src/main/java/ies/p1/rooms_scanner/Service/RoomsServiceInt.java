package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.Rooms;

import java.util.Collection;

public interface RoomsServiceInt {
    public abstract void createRoom(Rooms room);
    public abstract void updateRoom(Long id, Rooms room);
    public abstract void deleteRoom(Long id);
    public abstract Collection<Rooms> getRooms();
}
