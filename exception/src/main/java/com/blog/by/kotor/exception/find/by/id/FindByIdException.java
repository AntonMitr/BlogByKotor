package com.blog.by.kotor.exception.find.by.id;

import com.blog.by.kotor.exception.ErrorCode;
import lombok.Getter;

@Getter
public class FindByIdException extends RuntimeException {

    public FindByIdException(ErrorCode errorCode, Integer id) {
        super(String.format(errorCode.getMessage(), id));
    }

}
