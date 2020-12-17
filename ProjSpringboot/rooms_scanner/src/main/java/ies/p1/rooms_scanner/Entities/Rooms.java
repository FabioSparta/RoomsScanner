package ies.p1.rooms_scanner.Entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rooms")
public class Rooms {
    @Id     // ->  !!!!!!!!!!! TODO: ID automatico ou dept+floor+numSala?
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String department;
    private int busySeats;
    private int maxSeats;
    private int floor;
    // room(id, departamento, andar, numLugaresOcupados, maxSeats)
    public Rooms() {}

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getBusySeats() {
        return busySeats;
    }

    public void setBusySeats(int busySeats) {
        this.busySeats = busySeats;
    }

    public String getDepartment() {
        return department;
    }

    public int getFloor() {
        return floor;
    }
}
