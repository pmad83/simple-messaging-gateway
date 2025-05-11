package pl.pm.simplemessaginggateway.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.pm.simplemessaginggateway.entity.EmailMessage;

/*
 * Service do wysyłania wiadomości e-mail.
 */
@Service
@AllArgsConstructor
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;

    public void sendEmail(EmailMessage emailMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailMessage.getRecipientEmail());
        message.setSubject(emailMessage.getSubject());
        message.setText(emailMessage.getMessage());
        message.setFrom(emailMessage.getSenderEmail());

        mailSender.send(message);
        logger.info("Wysłano wiadomość: {}", emailMessage);
    }
}
