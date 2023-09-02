package com.example.javadddtemplate.domain.core.exceptions;

public class ValidationException extends Exception {
    public ValidationException(String field, String reason) {
        super("ValidationException: field "+field+" "+ reason);
    }
}
