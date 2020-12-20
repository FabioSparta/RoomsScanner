package ies.p1.rooms_scanner.Controller;

import ies.p1.rooms_scanner.Entities.Rooms;
import ies.p1.rooms_scanner.Service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    RoomsService roomsService;

    @RequestMapping(value = "/allRooms")
    public ResponseEntity<Object> getRooms() {
        roomsService.test();
        return new ResponseEntity<>(roomsService.getRooms(), HttpStatus.OK);
    }

    @RequestMapping(value = "/allRooms", method = RequestMethod.POST)
    public ResponseEntity<Object> createRoom(@RequestBody Rooms room) {
        if (roomsService.createRoom(room))
            return new ResponseEntity<>("Room is created successfully", HttpStatus.CREATED);
        else
            return  new ResponseEntity<>("Room not created", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/allRooms/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateRoom(@PathVariable("id") Long id, @RequestBody Rooms r) {
        if (roomsService.updateRoom(id,r.getMaxSeats(),r.getBusySeats()))
            return new ResponseEntity<>("Room is updated successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not updated", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/allRooms/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        if (roomsService.deleteRoom(id))
            return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not deleted", HttpStatus.NOT_ACCEPTABLE);
    }


}
