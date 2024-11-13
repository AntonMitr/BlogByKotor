package com.blog.by.kotor.exception.signup;

import com.blog.by.kotor.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignupException extends RuntimeException {

    public SignupException(ErrorCode errorCode, String message) {
        super(String.format(errorCode.getMessage(), message));
    }

}
