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
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
public class AdminController {
    @Autowired
    RoomsService roomsService;
    @Autowired
    SensorService sensorService;
    @Autowired
    RoomsRepository roomsRepository;


    // ------------------------------------------------ GET ------------------------------------
    @GetMapping(value = "/rooms")
    public ResponseEntity<Object> getRooms(@RequestParam(required = false,defaultValue ="") String id) {
        if(id.equals("")) return new ResponseEntity<>(roomsService.getRooms(), HttpStatus.OK);
        try {
            int roomID = Integer.parseInt(id);
            Room r = roomsService.getRoomById(roomID);
            if (r == null)
                return new ResponseEntity<>("Error, room not found!", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(r, HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>("Error with room id", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/sensors")
    public ResponseEntity<Object> getSensors(@RequestParam(required = false,defaultValue ="") String id) {
        if(id.equals("")) return new ResponseEntity<>(sensorService.getSensors(), HttpStatus.OK);
        try {
            int sensorID = Integer.parseInt(id);
            Sensor s = sensorService.getSensorsById(sensorID);
            if (s == null)
                return new ResponseEntity<>("Error, sensor not found!", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(s, HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>("Error with sensor id", HttpStatus.NOT_FOUND);
        }
    }
    // ------------------------------------------------ CREATE ------------------------------------
    @PostMapping("/rooms")
    public ResponseEntity<Object> createRoom(@RequestBody Room room) {
        if (roomsService.createRoom(room)){
            return new ResponseEntity<>("Room is created successfully", HttpStatus.OK);}
        else
            return  new ResponseEntity<>("Room not created", HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping(value = "/sensors")
    public ResponseEntity<Object> createSensor(@RequestBody Sensor s) {
        if (sensorService.createSensor(s))
            return new ResponseEntity<>("Sensor is created successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor not created", HttpStatus.NOT_ACCEPTABLE);
    }

    // ------------------------------------------------ UPDATE ------------------------------------
    @PutMapping(value = "/roomsEdit")
    public ResponseEntity<Object> updateRoom(@RequestBody Room room) {
        if (roomsService.updateRoom(room.getId(),room.getMaxSeats()))
            return new ResponseEntity<>("Room is updated successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not updated", HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping(value = "/sensorsEdit")
    public ResponseEntity<Object> updateSensorData(@RequestBody Sensor s) {
        if (sensorService.updateSensor(s.getId(),s.getDataCaptured()))
            return new ResponseEntity<>("Sensor is updated successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor not updated", HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping(value = "/roomSetSensor/{id}")
    public ResponseEntity<Object> updateSensorRoom(@PathVariable("id") int id,@RequestBody Sensor s) {
        if (roomsService.updateSensorRoom(id,s.getId()))
            return new ResponseEntity<>("Sensor "+s.getId()+" was updated to room "+id+" successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor "+s.getId()+" not updated to room "+id+"", HttpStatus.NOT_ACCEPTABLE);
    }

    // ------------------------------------------------ DELETE ------------------------------------
   @DeleteMapping(value = "/deleteSensor/{id}")
    public ResponseEntity<Object> deleteSensor(@PathVariable("id") int id) {
        if (sensorService.deleteSensor(id))
            return new ResponseEntity<>("Sensor deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor not deleted", HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping(value = "/deleteRoom/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable("id") int id) {
        if (roomsService.deleteRoom(id))
            return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Room not deleted", HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping(value = "/roomRmSensor/{id}")
    public ResponseEntity<Object> removeSensorRoom(@PathVariable("id") int id,@RequestBody Sensor s) {
        if (roomsService.removeSensorRoom(id,s.getId()))
            return new ResponseEntity<>("Sensor "+s.getId()+" was removed from room "+id+" successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor "+s.getId()+" was not removed from room "+id+"", HttpStatus.NOT_ACCEPTABLE);
    }


    // ------------------------------------------------ FILTER SEARCH  ------------------------------------

    @PostMapping("/filterRooms")
    public ResponseEntity<Object> filterRoom(@RequestBody Room room) {
        if (!room.getDepartment().equals("Department") && room.getFloor() != -1) {
            return new ResponseEntity<>(roomsService.getRoomByDepartmentAndFloor(room.getDepartment(), room.getFloor()), HttpStatus.OK);
        } else if (!room.getDepartment().equals("Department")){
            return new ResponseEntity<>(roomsService.getRoomByDepartment(room.getDepartment()), HttpStatus.OK);
        } else if (room.getFloor() != -1) {
            return new ResponseEntity<>(roomsService.getRoomByFloor(room.getFloor()), HttpStatus.OK);
        } else
            return new ResponseEntity<>(roomsService.getRooms(), HttpStatus.OK);
    }

    // ---------------------------------------------- NOTIFICATIONS --------------------------------------
    @GetMapping("/notifications")
    public SseEmitter getNotifications() { //user pode seguir uma sala e nesse caso passavamos como argumento o ID do user pra ver a lista de salas q segue
        SseEmitter sseEmitter = new SseEmitter();
        /*for (Room r : roomsService.getRooms()) {
            if (r.getSensorList().size() > 0) {
                if (r.getSensorList().get(0).getDataCaptured() > r.getMaxSeats()) {
                    System.out.println(r.getSensorList().get(0).getSensorType());
                    try {
                        System.out.println("hereeeeeeeee");
                        sseEmitter.send("Message 1");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        sseEmitter.complete();*/
        return sseEmitter;
    }
}