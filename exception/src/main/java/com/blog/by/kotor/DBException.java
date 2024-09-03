package com.blog.by.kotor;

public class DBException extends Exception {

    private static final String DB_NOT_CONNECTED_TEXT = "Сейчас база данных не работает. Попробуйте позже";
    private static final String CLOSE_CONN_ERROR_TEXT = "Не работает close connection";
    private static final String CLOSE_PS_ERROR_TEXT = "Не работает close preparedStatement";
    private static final String CLOSE_RS_ERROR_TEXT = "Не работает close resultSet";

    public static final int DB_NOT_CONNECTED = 1;
    public static final int CLOSE_CONN_ERROR = 2;
    public static final int CLOSE_PS_ERROR = 3;
    public static final int CLOSE_RS_ERROR = 4;


    private final int code;

   public DBException(int code) {
       this.code = code;
   }

   public String getMessage() {
       return switch (code) {
           case DB_NOT_CONNECTED -> DB_NOT_CONNECTED_TEXT;
           case CLOSE_CONN_ERROR -> CLOSE_CONN_ERROR_TEXT;
           case CLOSE_PS_ERROR -> CLOSE_PS_ERROR_TEXT;
           case CLOSE_RS_ERROR -> CLOSE_RS_ERROR_TEXT;
           default -> "";
       };
   }

}
