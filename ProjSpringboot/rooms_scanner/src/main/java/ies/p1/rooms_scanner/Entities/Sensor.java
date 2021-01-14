package ies.p1.rooms_scanner.Entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@Entity
@Table(name = "sensors")
public class Sensor  {
    @Id
    private int id;
    private int dataCaptured;
    private String sensorType;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "sensor_data_history", joinColumns = @JoinColumn(name = "sensor_id"))
    private List<SensorHistory> sensor_history = new ArrayList<>();


    public Sensor() { }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDataCaptured() { return dataCaptured; }
    public void setDataCaptured(int dataCaptured) { this.dataCaptured = dataCaptured; }
    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
    public List<SensorHistory> getSensor_history() { return sensor_history; }
}