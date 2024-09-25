package com.blog.by.kotor.exception.update;

import com.blog.by.kotor.exception.ErrorCode;
import lombok.Getter;

@Getter
public class UpdateException extends RuntimeException {

    private final ErrorCode errorCode;

    public UpdateException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
