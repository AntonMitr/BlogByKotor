package com.blog.by.kotor;

public class DAOException extends Exception {

    private static final String CATEGORY_DAO_EXCEPTION_TEXT = "Что-то пошло не так в CATEGORY_DAO_IMPL с SQL";
    private static final String COMMENT_DAO_EXCEPTION_TEXT = "Что-то пошло не так в COMMENT_DAO_IMPL с SQL";
    private static final String FILTER_DAO_EXCEPTION_TEXT = "Что-то пошло не так в FILTER_DAO_IMPL с SQL";
    private static final String POLL_DAO_EXCEPTION_TEXT = "Что-то пошло не так в POLL_DAO_IMPL с SQL";
    private static final String POST_DAO_EXCEPTION_TEXT = "Что-то пошло не так в POST_DAO_IMPL с SQL";
    private static final String POST_TAG_EXCEPTION_TEXT = "Что-то пошло не так в POST_TAG_DAO_IMPL с SQL";
    private static final String POST_CATEGORY_DAO_EXCEPTION_TEXT = "Что-то пошло не так в POST_CATEGORY_DAO_IMPL с SQL";
    private static final String PREMIUM_SUBSCRIPTION_DAO_EXCEPTION_TEXT = "Что-то пошло не так в PREMIUM_SUBSCRIPTION_DAO_IMPL с SQL";
    private static final String QUESTION_DAO_EXCEPTION_TEXT = "Что-то пошло не так в QUESTION_DAO_IMPL с SQL";
    private static final String ROLE_DAO_EXCEPTION_TEXT = "Что-то пошло не так в ROLE_DAO_IMPL с SQL";
    private static final String TAG_DAO_EXCEPTION_TEXT = "Что-то пошло не так в TAG_DAO_IMPL с SQL";
    private static final String USER_DAO_EXCEPTION_TEXT = "Что-то пошло не так в USER_DAO_IMPL с SQL";
    private static final String USER_ANSWER_DAO_EXCEPTION_TEXT = "Что-то пошло не так в USER_ANSWER_DAO_IMPL с SQL";
    private static final String USER_ROLE_DAO_EXCEPTION_TEXT = "Что-то пошло не так в USER_ROLE_DAO_IMPL с SQL";
    private static final String OPTION_DAO_EXCEPTION_TEXT = "Что-то пошло не так в OPTION_DAO_IMPL с SQL";



    public static final int CATEGORY_DAO_EXCEPTION = 1;
    public static final int COMMENT_DAO_EXCEPTION = 2;
    public static final int FILTER_DAO_EXCEPTION = 3;
    public static final int POLL_DAO_EXCEPTION = 4;
    public static final int POST_DAO_EXCEPTION = 5;
    public static final int POST_CATEGORY_DAO_EXCEPTION = 6;
    public static final int POST_TAG_DAO_EXCEPTION = 7;
    public static final int PREMIUM_SUBSCRIPTION_DAO_EXCEPTION = 8;
    public static final int QUESTION_DAO_EXCEPTION = 9;
    public static final int ROLE_DAO_EXCEPTION = 10;
    public static final int TAG_DAO_EXCEPTION = 11;
    public static final int USER_DAO_EXCEPTION = 12;
    public static final int USER_ANSWER_DAO_EXCEPTION = 13;
    public static final int USER_ROLE_DAO_EXCEPTION = 14;
    public static final int OPTION_DAO_EXCEPTION = 15;

    private final int code;

    public DAOException(int code) {
        this.code = code;
    }

    public String getMessage() {
        return switch (code) {
            case 1 -> CATEGORY_DAO_EXCEPTION_TEXT;
            case 2 -> COMMENT_DAO_EXCEPTION_TEXT;
            case 3 -> FILTER_DAO_EXCEPTION_TEXT;
            case 4 -> POLL_DAO_EXCEPTION_TEXT;
            case 5 -> POST_DAO_EXCEPTION_TEXT;
            case 6 -> POST_CATEGORY_DAO_EXCEPTION_TEXT;
            case 7 -> POST_TAG_EXCEPTION_TEXT;
            case 8 -> PREMIUM_SUBSCRIPTION_DAO_EXCEPTION_TEXT;
            case 9 -> QUESTION_DAO_EXCEPTION_TEXT;
            case 10 -> ROLE_DAO_EXCEPTION_TEXT;
            case 11 -> TAG_DAO_EXCEPTION_TEXT;
            case 12 -> USER_DAO_EXCEPTION_TEXT;
            case 13 -> USER_ANSWER_DAO_EXCEPTION_TEXT;
            case 14 -> USER_ROLE_DAO_EXCEPTION_TEXT;
            case 15 -> OPTION_DAO_EXCEPTION_TEXT;
            default -> "";
        };
    }

}
