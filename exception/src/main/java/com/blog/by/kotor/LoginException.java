package com.blog.by.kotor;

public class LoginException extends Exception {

    public static final String LOGIN_CONFIRMED_TEXT = "Добро пожаловать";
    public static final String LOGIN_FAILED_TEXT = "Неправильный логин или пароль!";

    public LoginException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
