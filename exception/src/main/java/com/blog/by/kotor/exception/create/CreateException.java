package com.blog.by.kotor.exception.create;

import com.blog.by.kotor.exception.ErrorCode;
import lombok.Getter;
import org.aspectj.weaver.ast.Not;

@Getter
public class CreateException extends RuntimeException {

    public CreateException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}
