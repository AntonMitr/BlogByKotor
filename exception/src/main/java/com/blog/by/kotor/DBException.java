package com.blog.by.kotor;

public class DBException extends Exception {

    private static final String DB_NOT_CONNECTED_TEXT = "Сейчас база данных не работает. Попробуйте позже";

    public static final int DB_NOT_CONNECTED = 1;

    private final int code;

   public DBException(int code) {
       this.code = code;
   }

   public String getMessage() {
       return switch (code) {
           case DB_NOT_CONNECTED -> DB_NOT_CONNECTED_TEXT;
           default -> "";
       };
   }

}
