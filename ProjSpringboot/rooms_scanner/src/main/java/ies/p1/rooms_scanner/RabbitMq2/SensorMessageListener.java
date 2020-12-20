package ies.p1.rooms_scanner.RabbitMq2;

import ies.p1.rooms_scanner.Service.RoomsService;
import ies.p1.rooms_scanner.Service.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorMessageListener {
    @Autowired
    SensorService sensorService;
    private static final Logger log = LoggerFactory.getLogger(SensorMessageListener.class);

    // Number of Peoplle
    @RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME2)
    public void receiveMessage(final Message message) {
        //log.info("Received message as generic: {}", message.toString());
    }
    @RabbitListener(queues = MessagingApplication.QUEUE_SPECIFIC_NAME2)
    public void receiveMessage(final SensorMessage sensorMessage) {
        log.info("Received message as specific class: {}", sensorMessage.toString());
        sensorService.updateSensor(sensorMessage.getId(),sensorMessage.getData());
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