package com.blog.by.kotor;

public class DAOException extends Exception {

    public static final String CATEGORY_DAO_EXCEPTION_TEXT = "Что-то пошло не так в CATEGORY_DAO_IMPL с SQL";
    public static final String COMMENT_DAO_EXCEPTION_TEXT = "Что-то пошло не так в COMMENT_DAO_IMPL с SQL";
    public static final String FILTER_DAO_EXCEPTION_TEXT = "Что-то пошло не так в FILTER_DAO_IMPL с SQL";
    public static final String POLL_DAO_EXCEPTION_TEXT = "Что-то пошло не так в POLL_DAO_IMPL с SQL";
    public static final String POST_DAO_EXCEPTION_TEXT = "Что-то пошло не так в POST_DAO_IMPL с SQL";
    public static final String POST_TAG_EXCEPTION_TEXT = "Что-то пошло не так в POST_TAG_DAO_IMPL с SQL";
    public static final String POST_CATEGORY_DAO_EXCEPTION_TEXT = "Что-то пошло не так в POST_CATEGORY_DAO_IMPL с SQL";
    public static final String PREMIUM_SUBSCRIPTION_DAO_EXCEPTION_TEXT = "Что-то пошло не так в PREMIUM_SUBSCRIPTION_DAO_IMPL с SQL";
    public static final String QUESTION_DAO_EXCEPTION_TEXT = "Что-то пошло не так в QUESTION_DAO_IMPL с SQL";
    public static final String ROLE_DAO_EXCEPTION_TEXT = "Что-то пошло не так в ROLE_DAO_IMPL с SQL";
    public static final String TAG_DAO_EXCEPTION_TEXT = "Что-то пошло не так в TAG_DAO_IMPL с SQL";
    public static final String USER_DAO_EXCEPTION_TEXT = "Что-то пошло не так в USER_DAO_IMPL с SQL";
    public static final String USER_ANSWER_DAO_EXCEPTION_TEXT = "Что-то пошло не так в USER_ANSWER_DAO_IMPL с SQL";
    public static final String USER_ROLE_DAO_EXCEPTION_TEXT = "Что-то пошло не так в USER_ROLE_DAO_IMPL с SQL";
    public static final String OPTION_DAO_EXCEPTION_TEXT = "Что-то пошло не так в OPTION_DAO_IMPL с SQL";

    public DAOException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }

}
