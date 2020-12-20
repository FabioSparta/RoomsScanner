package ies.p1.rooms_scanner.Entities;
import javax.persistence.*;


@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int DataCaptured;
    private String SensorType;

    @ManyToOne()
    @JoinColumn(name = "room_id")
    private Rooms room;

    public Sensor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataCaptured() {
        return DataCaptured;
    }

    public void setDataCaptured(int dataCaptured) {
        DataCaptured = dataCaptured;
    }

    public String getSensorType() {
        return SensorType;
    }

    public void setSensorType(String sensorType) {
        SensorType = sensorType;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }
}