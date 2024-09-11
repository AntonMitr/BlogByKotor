package com.blog.by.kotor;

public class DBException extends Exception {

    public static final String DB_NOT_CONNECTED_TEXT = "Сейчас база данных не работает. Попробуйте позже";
    public static final String CLOSE_CONN_ERROR_TEXT = "Не работает close connection";
    public static final String CLOSE_PS_ERROR_TEXT = "Не работает close preparedStatement";
    public static final String CLOSE_RS_ERROR_TEXT = "Не работает close resultSet";

    public DBException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }


}
