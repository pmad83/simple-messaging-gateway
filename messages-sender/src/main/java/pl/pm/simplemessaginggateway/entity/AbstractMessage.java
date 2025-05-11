package pl.pm.simplemessaginggateway.entity;

import lombok.Data;

/*
 * Abstrakcyjna klasa do obsługi różnych typów wiadomości.
 */
@Data
public class AbstractMessage {

    private Integer senderId;
    private String messageType;
    private String message;
    private String timeDeliveryRestrictions;
}
