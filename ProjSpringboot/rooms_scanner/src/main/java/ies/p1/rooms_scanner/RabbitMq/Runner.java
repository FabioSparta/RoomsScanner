package ies.p1.rooms_scanner.RabbitMq;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/*
@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        int counter=0;
        while(true){
            rabbitTemplate.convertAndSend(MessagingRabbitApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!" + ++counter);
            receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
            Thread.sleep(1000);
            if(counter==10) break;
        }

    }


}

 */