package com.app.agripulse.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoPostFound extends RuntimeException {

    private Long id;

    public NoPostFound(String message, Long id) {
        super(message);
        this.id = id;
    }
}
