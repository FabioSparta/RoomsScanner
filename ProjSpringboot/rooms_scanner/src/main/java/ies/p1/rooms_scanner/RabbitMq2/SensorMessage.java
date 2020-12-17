package ies.p1.rooms_scanner.RabbitMq2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorMessage {

    private final int id;
    private final int data;

    public SensorMessage(@JsonProperty("id") int id,
                         @JsonProperty("data") int data) {
        this.id = id;
        this.data = data;
    }

    //Getters
    public int getId() { return id; }
    public int getData() { return data; }


    @Override
    public String toString() {
        return "SensorMessage{" +
                "id='" + id + " "  +
                ", data=" + data +
                '}';
    }
}
