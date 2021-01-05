package ies.p1.rooms_scanner.Controller;

import ies.p1.rooms_scanner.Entities.Rooms;
import ies.p1.rooms_scanner.Entities.Sensor;
import ies.p1.rooms_scanner.Service.RoomsService;
import ies.p1.rooms_scanner.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@RestController
public class AdminController {
    @Autowired
    RoomsService roomsService;
    @Autowired
    SensorService sensorService;

    @RequestMapping(value = "/Rooms")
    public ResponseEntity<Object> getRooms() {
        roomsService.test(); //TODO: retirar no final APENAS PRA TESTES
        return new ResponseEntity<>(roomsService.getRooms(), HttpStatus.OK);
    }

    @RequestMapping(value = "/Rooms", method = RequestMethod.POST)
    public ResponseEntity<Object> createRoom(@RequestBody Rooms room) {
        if (roomsService.createRoom(room))
            return new ResponseEntity<>("Room is created successfully", HttpStatus.CREATED);
        else
            return  new ResponseEntity<>("Room not created", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/Rooms/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateRoom(@PathVariable("id") int id, @RequestParam(required = true) int seats) {
        if (roomsService.updateRoom(id,seats))
            return new ResponseEntity<>("Room is updated successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not updated", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/Rooms/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRoom(@PathVariable("id") int id) {
        if (roomsService.deleteRoom(id))
            return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not deleted", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/Sensors")
    public ResponseEntity<Object> getSensors(@RequestParam(required = false) int idSensor) {
        sensorService.test(); ////TODO: retirar no final APENAS PRA TESTE
        if (idSensor == -1) //TODO: default deve ser -1
            return new ResponseEntity<>(sensorService.getSensors(), HttpStatus.OK);
        else
            return new ResponseEntity<>(sensorService.getSensorsById(idSensor), HttpStatus.OK);
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

    @RequestMapping(value = "/RoomSetSensor/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSensorRoom(@PathVariable("id") int id, @RequestParam(required = true) int idSensor) {
        if (roomsService.updateSensorRoom(id,idSensor))
            return new ResponseEntity<>("Sensor "+idSensor+" was updated to room "+id+" successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor "+idSensor+" not updated to room "+id+"", HttpStatus.NOT_ACCEPTABLE);
    }


    @RequestMapping(value = "/Sensors/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSensor(@PathVariable("id") int id) {
        if (sensorService.deleteSensor(id))
            return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not deleted", HttpStatus.NOT_ACCEPTABLE);
    }

}