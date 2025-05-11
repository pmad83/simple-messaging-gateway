package pl.pm.simplemessaginggateway.tester;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pm.simplemessaginggateway.entity.EmailMessage;
import pl.pm.simplemessaginggateway.service.EmailService;

/*
 * Tester do wysyłki wiadomości podczas startu aplikacji.
 */
@Component
@AllArgsConstructor
public class EmailServiceTester implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceTester.class);
    private final EmailService emailService;

    @Override
    public void run(String... args) throws Exception {
        EmailMessage testMessage = new EmailMessage();
        testMessage.setSubject("Test - start aplikacji");
        testMessage.setMessage("Treść przykładowa");
        testMessage.setRecipientEmail("test@example.com");
        emailService.sendEmail(testMessage);
    }
}
