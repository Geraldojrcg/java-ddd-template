package com.example.javadddtemplate.domain.core.validators;

import java.util.regex.Pattern;

public class EmailValidator {
    public static Boolean validate(String email) {
        String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }
}
