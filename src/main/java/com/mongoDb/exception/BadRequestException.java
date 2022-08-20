package com.mongoDb.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends HttpException{

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
