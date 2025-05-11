package pl.pm.simplemessaginggateway.listener;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Konfigurator kolejek na RabbitMQ.
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue("messagesQueue", true);
    }
}
