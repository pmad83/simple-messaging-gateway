package pl.pm.simplemessaginggateway.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.pm.simplemessaginggateway.processor.MessageProcessor;
import pl.pm.simplemessaginggateway.processor.MessageProcessorFactory;

/*
 * Listener kolejek na RabbitMQ.
 */
@Service
@AllArgsConstructor
public class RabbitMQListener {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);
    private static final String MESSAGE_TYPE_ATTRIBUTE_NAME = "messageType";

    private final MessageProcessorFactory processorFactory;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "messagesQueue")
    public void receiveMessage(String message) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            String messageType = jsonNode.get(MESSAGE_TYPE_ATTRIBUTE_NAME).asText();
            MessageProcessor processor = processorFactory.getProcessor(messageType);
            processor.processMessage(message);
        } catch (JsonProcessingException e) {
            logger.error("Błąd podczas parsowania wiadomości: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Błąd podczas przetwarzania wiadomości: {}", e.getMessage());
        }
    }
}
