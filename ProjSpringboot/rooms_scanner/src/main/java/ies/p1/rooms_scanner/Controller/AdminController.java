package ies.p1.rooms_scanner.Controller;

import ies.p1.rooms_scanner.Entities.Room;
import ies.p1.rooms_scanner.Entities.Sensor;
import ies.p1.rooms_scanner.Repository.RoomsRepository;
import ies.p1.rooms_scanner.Service.RoomsService;
import ies.p1.rooms_scanner.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    RoomsService roomsService;
    @Autowired
    SensorService sensorService;

    @Autowired
    RoomsRepository roomsRepository;




    @GetMapping("/rooms")
    public ResponseEntity<Object> getRooms() {
        return new ResponseEntity<>(roomsService.getRooms(), HttpStatus.OK);
    }

    @PostMapping(value = "/rooms")
    public ResponseEntity<Object> createRoom(@RequestBody Room room) {
        if (roomsService.createRoom(room))
            return new ResponseEntity<>("Room is created successfully", HttpStatus.CREATED);
        else
            return  new ResponseEntity<>("Room not created", HttpStatus.NOT_ACCEPTABLE);
    }
    @PostMapping(value = "/deleteRoom")
    public ResponseEntity<Object> deleteRoom(@RequestBody Room room) {
        if (roomsService.deleteRoom(room.getId()))
            return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not deleted", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateRoom(@PathVariable("id") int id, @RequestParam(required = true) int seats) {
        if (roomsService.updateRoom(id,seats))
            return new ResponseEntity<>("Room is updated successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not updated", HttpStatus.NOT_ACCEPTABLE);
    }



    @GetMapping(value = "/sensors")
    public ResponseEntity<Object> getSensors() {
            return new ResponseEntity<>(sensorService.getSensors(), HttpStatus.OK);

    }

    @RequestMapping(value = "/Sensors", method = RequestMethod.POST)
    public ResponseEntity<Object> createSensor(@RequestBody Sensor s) {
        if (sensorService.createSensor(s))
            return new ResponseEntity<>("Sensor is created successfully", HttpStatus.CREATED);
        else
            return  new ResponseEntity<>("Sensor not created", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/Sensors/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSensorData(@PathVariable("id") int id, @RequestBody Sensor s) {
        if (sensorService.updateSensor(id,s.getDataCaptured()))
            return new ResponseEntity<>("Sensor is updated successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor not updated", HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping(value = "/deleteSensor")
    public ResponseEntity<Object> deleteSensor(@RequestBody Sensor s) {
        if (sensorService.deleteSensor(s.getId()))
            return new ResponseEntity<>("Sensor deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor not deleted", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/RoomSetSensor/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSensorRoom(@PathVariable("id") int id, @RequestParam(required = true) int idSensor) {
        if (roomsService.updateSensorRoom(id,idSensor))
            return new ResponseEntity<>("Sensor "+idSensor+" was updated to room "+id+" successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor "+idSensor+" not updated to room "+id+"", HttpStatus.NOT_ACCEPTABLE);
    }

}