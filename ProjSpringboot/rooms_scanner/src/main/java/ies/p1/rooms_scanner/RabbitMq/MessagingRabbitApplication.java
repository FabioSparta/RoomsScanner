package ies.p1.rooms_scanner.RabbitMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//python3 -m pip install pika --upgrade
// docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
// Open in browser: http://localhost:15672/#/
//Login: user:guest ; pw:guest

//@SpringBootApplication
public class MessagingRabbitApplication {

    static final String topicExchangeName = "spring-boot-exchange";
    //static final String topicExchangeName = "PYhellos";

    static final String queueName = "spring-bootTEST";
    //static final String queueName = "hello";

    @Bean
    //creates an AMQP queue
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    //creates a topic
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        //return BindingBuilder.bind(queue).to(exchange).with("hello");
         return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(MessagingRabbitApplication.class, args).close();
    }

}