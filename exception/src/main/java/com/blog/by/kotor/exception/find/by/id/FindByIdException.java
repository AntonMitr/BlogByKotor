package com.blog.by.kotor.exception.find.by.id;

import com.blog.by.kotor.exception.ErrorCode;
import lombok.Getter;

@Getter
public class FindByIdException extends RuntimeException {

    private final ErrorCode errorCode;

    public FindByIdException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
