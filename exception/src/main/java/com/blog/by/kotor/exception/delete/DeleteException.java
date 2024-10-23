package com.blog.by.kotor.exception.delete;

import com.blog.by.kotor.exception.ErrorCode;
import lombok.Getter;

@Getter
public class DeleteException extends RuntimeException {

    public DeleteException(ErrorCode errorCode, Integer id) {
        super(String.format(errorCode.getMessage(), id));
    }

}
