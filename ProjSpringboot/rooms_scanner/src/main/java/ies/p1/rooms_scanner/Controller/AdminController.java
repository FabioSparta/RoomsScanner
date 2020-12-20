package ies.p1.rooms_scanner.Controller;

import ies.p1.rooms_scanner.Entities.Rooms;
import ies.p1.rooms_scanner.Entities.Sensor;
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
    SensorService sensorService;

    @RequestMapping(value = "/allRooms")
    public ResponseEntity<Object> getRooms() {
        roomsService.test(); //TODO: retirar no final APENAS PRA TESTES
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
    public ResponseEntity<Object> updateRoom(@PathVariable("id") int id, @RequestBody Rooms r) {
        if (roomsService.updateRoom(id,r.getMaxSeats()))
            return new ResponseEntity<>("Room is updated successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not updated", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/allRooms/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRoom(@PathVariable("id") int id) {
        if (roomsService.deleteRoom(id))
            return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not deleted", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/allSensors")
    public ResponseEntity<Object> getSensors() {
        sensorService.test(); ////TODO: retirar no final APENAS PRA TESTES
        return new ResponseEntity<>(roomsService.getRooms(), HttpStatus.OK);
    }

    @RequestMapping(value = "/allSensors", method = RequestMethod.POST)
    public ResponseEntity<Object> createSensor(@RequestBody Sensor s) {
        if (sensorService.createSensor(s))
            return new ResponseEntity<>("Sensor is created successfully", HttpStatus.CREATED);
        else
            return  new ResponseEntity<>("Sensor not created", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/allSensors/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSensor(@PathVariable("id") int id, @RequestBody Sensor s) {
        if (sensorService.updateSensor(id,s.getDataCaptured()))
            return new ResponseEntity<>("Sensor is updated successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor not updated", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/allSensors/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSensor(@PathVariable("id") int id) {
        if (sensorService.deleteSensor(id))
            return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not deleted", HttpStatus.NOT_ACCEPTABLE);
    }

}
