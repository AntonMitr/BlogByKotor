package com.blog.by.kotor.exception.delete;

import com.blog.by.kotor.exception.ErrorCode;

public class DeleteExceptionFactory {

    public static DeleteException moduleNotFound(ErrorCode errorCode, Integer id) {
        switch (errorCode) {
            case CATEGORY_NOT_FOUND -> {
                return new DeleteException(errorCode, "Category with id" + id + " not found");
            }
            case COMMENT_NOT_FOUND -> {
                return new DeleteException(errorCode, "Comment with id" + id + " not found");
            }
            case FILTER_NOT_FOUND -> {
                return new DeleteException(errorCode, "Filter with id" + id + " not found");
            }
            case OPTION_NOT_FOUND -> {
                return new DeleteException(errorCode, "Option with id" + id + " not found");
            }
            case POLL_NOT_FOUND -> {
                return new DeleteException(errorCode, "Poll with id" + id + " not found");
            }
            case POST_NOT_FOUND -> {
                return new DeleteException(errorCode, "Post with id" + id + " not found");
            }
            case PREMIUM_SUBSCRIPTION_NOT_FOUND -> {
                return new DeleteException(errorCode, "PremiumSubscription with id" + id + " not found");
            }
            case QUESTION_NOT_FOUND -> {
                return new DeleteException(errorCode, "Question with id" + id + " not found");
            }
            case ROLE_NOT_FOUND -> {
                return new DeleteException(errorCode, "Role with id" + id + " not found");
            }
            case TAG_NOT_FOUND -> {
                return new DeleteException(errorCode, "Tag with id" + id + " not found");
            }
            case USER_NOT_FOUND -> {
                return new DeleteException(errorCode, "User with id" + id + " not found");
            }
            case VOTE_NOT_FOUND -> {
                return new DeleteException(errorCode, "Vote with id" + id + " not found");
            }
            default -> {
                return new DeleteException(errorCode, "Unknown Error");
            }
        }
    }
    
}
