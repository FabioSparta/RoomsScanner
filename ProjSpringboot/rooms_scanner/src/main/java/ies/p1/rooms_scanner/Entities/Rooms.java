package ies.p1.rooms_scanner.Entities;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String department;
    private int maxSeats;
    private int floor;

    @OneToMany(targetEntity = Sensor.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "sensor_id")
    private List<Sensor> sensorList;

    // room(id, departamento, andar, numLugaresOcupados, maxSeats)
    public Rooms() {}
    public int getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public String getDepartment() {
        return department;
    }

    public int getFloor() {
        return floor;
    }

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }
}
