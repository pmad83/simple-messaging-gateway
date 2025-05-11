package pl.pm.simplemessaginggateway.processor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.pm.simplemessaginggateway.entity.EmailMessage;
import pl.pm.simplemessaginggateway.service.EmailService;

/*
 * Procesor odpowiedzialny za przetwarzanie wiadomości e-mail.
 */
@Service("EMAIL")
@AllArgsConstructor
public class EmailMessageProcessor implements MessageProcessor {

    private static final Logger logger = LoggerFactory.getLogger(EmailMessageProcessor.class);
    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    @Override
    public void processMessage(String message) throws JsonProcessingException {
        EmailMessage emailMessage = objectMapper.readValue(message, EmailMessage.class);
        try {
            emailService.sendEmail(emailMessage);
        }
        catch (Exception e) {
            logger.error("Nie udało się wysłać wiadomości: {} Błąd: {}", emailMessage, e.getMessage());
        }
    }
}
