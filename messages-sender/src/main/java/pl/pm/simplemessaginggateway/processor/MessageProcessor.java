package pl.pm.simplemessaginggateway.processor;

import com.fasterxml.jackson.core.JsonProcessingException;

/*
 * Interfejs dla procesorów różnych typów wiadomości.
 */
public interface MessageProcessor {

    void processMessage(String message) throws JsonProcessingException;
}
