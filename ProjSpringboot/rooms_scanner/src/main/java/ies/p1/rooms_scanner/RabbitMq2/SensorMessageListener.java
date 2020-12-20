package ies.p1.rooms_scanner.RabbitMq2;

import ies.p1.rooms_scanner.Entities.Rooms;
import ies.p1.rooms_scanner.Service.RoomsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorMessageListener {
    @Autowired
    RoomsService roomsService;
    private static final Logger log = LoggerFactory.getLogger(SensorMessageListener.class);

    // Number of Peoplle
    @RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME2)
    public void receiveMessage(final Message message) {
        //log.info("Received message as generic: {}", message.toString());
        long id = 10; //= Integer.parseInt(message.getBody()); //ver como ir buscar os campos da msg
        int busySeats = Integer.parseInt(String.valueOf(message));
        roomsService.updateRoom(id,-1,busySeats);
    }
    @RabbitListener(queues = MessagingApplication.QUEUE_SPECIFIC_NAME2)
    public void receiveMessage(final SensorMessage sensorMessage) {
        log.info("Received message as specific class: {}", sensorMessage.toString());
    }

    // Temp
    @RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME3)
    public void receiveMessage2(final Message message) {
        //log.info("Received message as generic: {}", message.toString());
    }
    @RabbitListener(queues = MessagingApplication.QUEUE_SPECIFIC_NAME3)
    public void receiveMessage2(final SensorMessage sensorMessage) {
        log.info("Received message as specific class: {}", sensorMessage.toString());
    }


}