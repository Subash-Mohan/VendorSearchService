package com.marraigemate.vendorsearchservice.exception;

public class MongoDBAggregateQueryException extends RuntimeException{
    public MongoDBAggregateQueryException(String message) {
        super(message);
    }
}
