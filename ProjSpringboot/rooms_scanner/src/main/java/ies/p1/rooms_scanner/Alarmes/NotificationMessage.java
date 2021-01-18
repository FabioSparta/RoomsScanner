package ies.p1.rooms_scanner.Alarmes;

public class NotificationMessage {

    private String department;
    private String depNumber;
    private int id;
    private int maxSeats;
    private  int totalPeop;
    private String msgDate;

    public String getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(String msgDate) {
        this.msgDate = msgDate;
    }

    @Override
    public String toString() {
        return "Message: Room from departement " + department + '\'' +
                ", " + depNumber + '\'' +
                " has a bound of " + maxSeats +
                "seats. This room is now overloaded with total of " + totalPeop +
                " people.";
    }
}
