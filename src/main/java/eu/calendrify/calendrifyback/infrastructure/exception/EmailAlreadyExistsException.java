package eu.calendrify.calendrifyback.infrastructure.exception;

import lombok.Getter;

@Getter
public class EmailAlreadyExistsException extends RuntimeException {
    private final String message;
    private final Integer errorCode;

    public EmailAlreadyExistsException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}