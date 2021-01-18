package ies.p1.rooms_scanner.Entities;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    private int id;
    private int maxSeats;
    private boolean viewed;
    private String roomNumber;
    private String message;
    private String department;
    private int detected;
    @Basic
    private java.sql.Date date;
    @Basic
    private java.sql.Time time;

    public Notification() {}

    public Notification(int detected,int seats,String roomNumber,String department,int id) {
        this.detected = detected;
        this.maxSeats = seats;
        this.roomNumber = roomNumber;
        this.department = department;
        this.date = new java.sql.Date(new Date().getTime());
        this.time = java.sql.Time.valueOf(LocalTime.now());
        this.viewed= false;
        this.id = id;
        this.message = "The room number " + this.roomNumber + " on "  + this.department + " has a limit of " + this.maxSeats + " people, but currently has  " + this.detected;
    }

    public int getId() {
        return id;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public String getRoomNumber() {return roomNumber;}

    public String getMessage() {return message; }

    public String getDepartment() {return department;}

    public int getDetected() { return detected; }

    public java.sql.Date getDate() {
        return date;
    }

    public void setSqlDate(java.sql.Date sqlDate) {
        this.date = sqlDate;
    }

    public Time getTime() {
        return time;
    }

    public void setSqlTime(Time sqlTime) {
        this.time = sqlTime;
    }
}
