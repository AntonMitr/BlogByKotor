package com.blog.by.kotor.exception.update;

import com.blog.by.kotor.exception.ErrorCode;
import lombok.Getter;

@Getter
public class UpdateException extends RuntimeException {

    public UpdateException(ErrorCode errorCode, Integer id) {
        super(String.format(errorCode.getMessage(), id));
    }

}
