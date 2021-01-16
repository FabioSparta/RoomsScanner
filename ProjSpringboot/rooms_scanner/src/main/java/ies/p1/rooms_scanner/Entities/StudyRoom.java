package ies.p1.rooms_scanner.Entities;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studyRooms")
public class StudyRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // studyRoom(id, departamento,andar, estado, numMaxOcupantes, horaAbertura, horaFecho)
    private long id;
    private String department;
    private int maxSeats;
    private int floor;
    private Timestamp openHour;
    private Timestamp closingHour;

    //construtor
    public StudyRoom() {}



    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Timestamp getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Timestamp openHour) {
        this.openHour = openHour;
    }

    public Timestamp getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(Timestamp closingHour) {
        this.closingHour = closingHour;
    }

    //only getters
    public long getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public String getDepartment() {
        return department;
    }

}
