package com.blog.by.kotor.exception.create;

import com.blog.by.kotor.exception.NotNullParam;
import lombok.Getter;

@Getter
public class CreateException extends RuntimeException {

    private final NotNullParam notNullParam;

    public CreateException(NotNullParam notNullParam, String message) {
        super(message);
        this.notNullParam = notNullParam;
    }

}
