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
        return new ResponseEntity<>(roomsService.getRooms(), HttpStatus.OK);
    }
    @RequestMapping(value = "/allRooms/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateProduct(@PathVariable("id") Long id, @RequestBody Rooms room) {
        roomsService.updateRoom(id, room);
        return new ResponseEntity<>("Room is updated successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/allRooms/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        roomsService.deleteRoom(id);
        return new ResponseEntity<>("Room is deleted successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/allRooms", method = RequestMethod.POST)
    public ResponseEntity<Object> createRoom(@RequestBody Rooms room) {
        roomsService.createRoom(room);
        return new ResponseEntity<>("Room is created successfully", HttpStatus.CREATED);
    }
}
