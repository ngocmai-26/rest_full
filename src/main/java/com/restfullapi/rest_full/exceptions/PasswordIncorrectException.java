package com.restfullapi.rest_full.exceptions;

import javax.naming.AuthenticationException;

public class PasswordIncorrectException extends AuthenticationException {
    public PasswordIncorrectException(String msg) {
        super(msg);
    }
}
