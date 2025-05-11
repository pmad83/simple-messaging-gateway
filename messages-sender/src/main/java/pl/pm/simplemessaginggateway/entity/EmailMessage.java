package pl.pm.simplemessaginggateway.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/*
 * Klasa reprezentująca wiadomość e-mail.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EmailMessage extends AbstractMessage {

    private String senderEmail;
    private String recipientEmail;
    private String subject;
}
