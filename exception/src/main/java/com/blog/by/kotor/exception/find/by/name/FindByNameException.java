package com.blog.by.kotor.exception.find.by.name;

import com.blog.by.kotor.exception.ErrorCode;

public class FindByNameException extends RuntimeException {

    public FindByNameException(ErrorCode errorCode, String name) {
        super(String.format(errorCode.getMessage(), name));
    }

}
