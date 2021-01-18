package ies.p1.rooms_scanner.RabbitMq2;

import ies.p1.rooms_scanner.Service.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SensorMessageListener {
    //@Autowired
    //private JavaMailSender mailSender;
    @Autowired
    SensorService sensorService;
    private static final Logger log = LoggerFactory.getLogger(SensorMessageListener.class);

    // Number of People
    @RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME2)
    public void receiveMessage(final Message message) {
        //log.info("Received message as generic: {}", message.toString());
    }

    @RabbitListener(queues = MessagingApplication.QUEUE_SPECIFIC_NAME2)
    public void receiveMessage(final SensorMessage sensorMessage) {
        log.info("Received message as specific class: {}", sensorMessage.toString());
        sensorService.updateSensor(sensorMessage.getId(), sensorMessage.getData());

        //mail(sensorMessage.getData());
    }

    // Temp
    @RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME3)
    public void receiveMessage2(final Message message) {
        //log.info("Received message as generic: {}", message.toString());
    }

    @RabbitListener(queues = MessagingApplication.QUEUE_SPECIFIC_NAME3)
    public void receiveMessage2(final SensorMessage sensorMessage) {
        log.info("Received message as specific class: {}", sensorMessage.toString());
        sensorService.updateSensor(sensorMessage.getId(), sensorMessage.getData());
    }

    public void mail(int data){
        System.out.println("A enviar email...");
        /*SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("ines.seabrarocha@gmail.com");
        message.setSubject("Room overloaded");
        message.setText("Sensors data"+ data);
        mailSender.send(message);*/
        System.out.println("enviada");
    }
}
