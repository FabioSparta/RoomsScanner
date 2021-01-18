package ies.p1.rooms_scanner.Entities;
import javax.persistence.*;


@Entity
@Table(name = "sensors")
public class Sensor  {
    @Id
    private int id;
    private int dataCaptured;
    private String sensorType;

    public Sensor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataCaptured() {
        return dataCaptured;
    }

    public void setDataCaptured(int dataCaptured) {
        this.dataCaptured = dataCaptured;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
}