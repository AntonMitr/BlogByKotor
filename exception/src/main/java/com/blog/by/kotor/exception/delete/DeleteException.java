package com.blog.by.kotor.exception.delete;

import com.blog.by.kotor.exception.ErrorCode;
import lombok.Getter;

@Getter
public class DeleteException extends RuntimeException {

    private final ErrorCode errorCode;

    public DeleteException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
