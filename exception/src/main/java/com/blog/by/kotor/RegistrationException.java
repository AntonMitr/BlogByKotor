package com.blog.by.kotor;

public class RegistrationException extends Exception {

    public static final String REGISTRATION_NULL_EMAIL = "Почта не может быть null!";
    public static final String REGISTRATION_NULL_PASSWORD = "Пароль не может быть null!";
    public static final String REGISTRATION_SHORT_PASSWORD= "Пароль должен содержать не менее 6 символов!";
    public static final String REGISTRATION_EXISTING_USER = "Данный пользователь уже существует!";

    public RegistrationException(String ExceptionMessage) {
        super(ExceptionMessage);
    }

}
