package ies.p1.rooms_scanner.Entities;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class SensorHistory {
        @NotNull
        private String date;

        @NotNull
        private int value;

        public SensorHistory() { }

        public SensorHistory(String date, int value) {
            this.date = date;
            this.value = value;
        }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public void setValue(int value) { this.value = value; }
    public int getValue() { return value; }
}
