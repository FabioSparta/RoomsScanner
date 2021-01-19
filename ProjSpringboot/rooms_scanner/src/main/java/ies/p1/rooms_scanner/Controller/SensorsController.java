package ies.p1.rooms_scanner.Controller;

import ies.p1.rooms_scanner.Entities.Sensor;
import ies.p1.rooms_scanner.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SensorsController {

    @Autowired
    SensorService sensorService;

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


    @PostMapping(value = "/sensors")
    public ResponseEntity<Object> createSensor(@RequestBody Sensor s) {
        if (sensorService.createSensor(s))
            return new ResponseEntity<>("Sensor is created successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor not created", HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping(value = "/sensorsEdit")
    public ResponseEntity<Object> updateSensorData(@RequestBody Sensor s) {
        if (sensorService.updateSensor(s.getId(),s.getDataCaptured(),s.getSensorType()=="PeopleCounter"))
            return new ResponseEntity<>("Sensor is updated successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor not updated", HttpStatus.NOT_ACCEPTABLE);
    }


    @DeleteMapping(value = "/deleteSensor/{id}")
    public ResponseEntity<Object> deleteSensor(@PathVariable("id") int id) {
        if (sensorService.deleteSensor(id))
            return new ResponseEntity<>("Sensor deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Sensor not deleted", HttpStatus.NOT_ACCEPTABLE);
    }
}
