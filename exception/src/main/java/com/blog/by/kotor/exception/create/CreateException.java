package com.blog.by.kotor.exception.create;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.NotNullParam;
import lombok.Getter;
import org.aspectj.weaver.ast.Not;

@Getter
public class CreateException extends RuntimeException {

    private final NotNullParam notNullParam;

    public CreateException(NotNullParam notNullParam, String message) {
        super(message);
        this.notNullParam = notNullParam;
    }

}
