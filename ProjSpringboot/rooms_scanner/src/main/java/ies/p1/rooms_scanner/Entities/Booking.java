package ies.p1.rooms_scanner.Entities;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String department; // TODO smp a biblioteca
    private int numAttendees;
    private String roomType; // enumerado sala grupo ou individual
    private int floor;
    private int nmecUser;
    private Timestamp bookingHour;
    private Timestamp endHour;
    private Date bookingDate; //proprio dia -> automatico

    // bookings(id, departamento(?) -> so a biblioteca -> inserir por default, andar, numOcupantes, emailResponsavel, horaReserva, tempoPrevisto,dataReserva) //data e hora insere a do proprio dia automaticamente
    //nao ha reservas pra dias distintos
    public Booking() {}

    public Date getBookingDate() {
        return bookingDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumAttendees() {
        return numAttendees;
    }

    public void setNumAttendees(int numAttendees) {
        this.numAttendees = numAttendees;
    }

    public Timestamp getBookingHour() {
        return bookingHour;
    }

    public void setBookingHour(Timestamp bookingHour) {
        this.bookingHour = bookingHour;
    }

    public int getNmecUser() {
        return nmecUser;
    }

    public void setNmecUser(int nmecUser) {
        this.nmecUser = nmecUser;
    }

    public Timestamp getEndHour() {
        return endHour;
    }

    public void setEndHour(Timestamp endHour) {
        this.endHour = endHour;
    }
}