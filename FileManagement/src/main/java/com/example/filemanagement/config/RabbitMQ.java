/**
 * This class defines the needed configuration for rabbitMQ
 *
 * @author  Matej Kolesar
 * @version 1.0
 * @since   13-05-2023
 */

package com.example.filemanagement.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQ {

    public static final String topicExchangeName = "file-metadata-exchange";

    public static final String queueName = "file.queue";
    public static final String ROOTING_KEY = "foo.bar.#";


    @Bean
    RabbitTemplate inquiryRabbitTemplate(ConnectionFactory factory) {
        return new RabbitTemplate(factory);
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROOTING_KEY);
    }


}
