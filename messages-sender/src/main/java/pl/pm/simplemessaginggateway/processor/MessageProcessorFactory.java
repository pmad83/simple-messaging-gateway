package pl.pm.simplemessaginggateway.processor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
 * Fabryka zarządzająca mapą procesorów wiadomości i zapewniająca metodę do pobierania odpowiedniego procesora na podstawie typu wiadomości.
 */
@Component
@AllArgsConstructor
public class MessageProcessorFactory {

    private final Map<String, MessageProcessor> processors;

    public MessageProcessor getProcessor(String messageType) {

        MessageProcessor processor = processors.get(messageType);
        if (processor == null) {
            throw new IllegalArgumentException("Nie można wybrać procesora do obsługi wiadomości. Nieznany typ: " + messageType);
        }
        return processor;
    }
}
