package eu.calendrify.calendrifyback.validation;


import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.infrastructure.exception.EmailAlreadyExistsException;

import static eu.calendrify.calendrifyback.infrastructure.Error.*;

public class ValidationService {

    public static DataNotFoundException throwPrimaryKeyNotFoundException(String primaryKeyName, Integer value) {
        return new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage() + primaryKeyName + " = " + value, PRIMARY_KEY_NOT_FOUND.getErrorCode());
    }

    public static DataNotFoundException throwForeignKeyNotFoundException(String fieldName, Integer value) {
        return new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage() + fieldName + " = " + value, FOREIGN_KEY_NOT_FOUND.getErrorCode());
    }

    public static EmailAlreadyExistsException throwEmailAlreadyExistsException(String fieldName, Integer value) {
        return new EmailAlreadyExistsException(INCORRECT_EMAIL.getMessage() + fieldName + " = " + value, INCORRECT_EMAIL.getErrorCode());
    }

}