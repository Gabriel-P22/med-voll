package br.com.projects.medvoll.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InvalidEmail extends RuntimeException {
    public InvalidEmail(String message) {
        super(message);
    }
}