package com.app.agripulse.exceptions;

public class CommentNotFoundException extends RuntimeException {

    private Long id;

    public CommentNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }
}
