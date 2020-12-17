package ies.p1.rooms_scanner.RabbitMq2;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

//python3 -m pip install pika --upgrade
// docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
// Open in browser: http://localhost:15672/#/
//Login: user:guest ; pw:guest

@SpringBootApplication
@EnableScheduling
public class MessagingApplication {

    //CustomMessage
    public static final String EXCHANGE_NAME="PYhellos";
    public static final String QUEUE_GENERIC_NAME="hello99";
    public static final String QUEUE_SPECIFIC_NAME="hello99";
    public static final String ROUTING_KEY="hello";

    @Bean
    public TopicExchange appExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }
    @Bean
    public Queue appQueueGeneric() {
        return new Queue(QUEUE_GENERIC_NAME);
    }
    @Bean
    public Queue appQueueSpecific() {
        return new Queue(QUEUE_SPECIFIC_NAME);
    }
    @Bean
    public Binding declareBindingGeneric() { return BindingBuilder.bind(appQueueGeneric()).to(appExchange()).with(ROUTING_KEY); }
    @Bean
    public Binding declareBindingSpecific() { return BindingBuilder.bind(appQueueSpecific()).to(appExchange()).with(ROUTING_KEY); }


    public static final String EXCHANGE_NAME2="PYsensors";

    //PeopleCounterMessage
    public static final String QUEUE_GENERIC_NAME2="people_counter";
    public static final String QUEUE_SPECIFIC_NAME2="people_counter";
    public static final String ROUTING_KEY2="people_counter";
    //PeopleCounterMessage
    public static final String QUEUE_GENERIC_NAME3="temperature";
    public static final String QUEUE_SPECIFIC_NAME3="temperature";
    public static final String ROUTING_KEY3="temperature";

    @Bean
    public TopicExchange appExchange2() {
        return new TopicExchange(EXCHANGE_NAME2);
    }
    @Bean
    public Queue appQueueGeneric2() {
        return new Queue(QUEUE_GENERIC_NAME2);
    }
    @Bean
    public Queue appQueueSpecific2() {
        return new Queue(QUEUE_SPECIFIC_NAME2);
    }
    @Bean
    public Binding declareBindingGeneric2() { return BindingBuilder.bind(appQueueGeneric2()).to(appExchange2()).with(ROUTING_KEY2); }
    @Bean
    public Binding declareBindingSpecific2() { return BindingBuilder.bind(appQueueSpecific2()).to(appExchange2()).with(ROUTING_KEY2); }


    @Bean
    public Queue appQueueGeneric3() {
        return new Queue(QUEUE_GENERIC_NAME3);
    }
    @Bean
    public Queue appQueueSpecific3() {
        return new Queue(QUEUE_SPECIFIC_NAME3);
    }
    @Bean
    public Binding declareBindingGeneric3() { return BindingBuilder.bind(appQueueGeneric3()).to(appExchange2()).with(ROUTING_KEY3); }
    @Bean
    public Binding declareBindingSpecific3() { return BindingBuilder.bind(appQueueSpecific3()).to(appExchange2()).with(ROUTING_KEY3); }





    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}