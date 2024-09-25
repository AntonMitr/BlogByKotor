package com.blog.by.kotor.exception.find.by.name;

import com.blog.by.kotor.exception.ErrorCode;
import lombok.Getter;

@Getter
public class FindByNameException extends RuntimeException {

    private final ErrorCode errorCode;

    public FindByNameException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
