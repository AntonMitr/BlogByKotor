package com.blog.by.kotor.exception.update;

import com.blog.by.kotor.exception.ErrorCode;

public class UpdateExceptionFactory {

    public static UpdateException moduleNotFound(ErrorCode errorCode, Integer id) {
        switch (errorCode) {
            case CATEGORY_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Category with id" + id + " not found");
            }
            case COMMENT_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Comment with id" + id + " not found");
            }
            case FILTER_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Filter with id" + id + " not found");
            }
            case OPTION_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Option with id" + id + " not found");
            }
            case POLL_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Poll with id" + id + " not found");
            }
            case POST_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Post with id" + id + " not found");
            }
            case PREMIUM_SUBSCRIPTION_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. PremiumSubscription with id" + id + " not found");
            }
            case QUESTION_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Question with id" + id + " not found");
            }
            case ROLE_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Role with id" + id + " not found");
            }
            case TAG_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Tag with id" + id + " not found");
            }
            case USER_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. User with id" + id + " not found");
            }
            case VOTE_NOT_FOUND -> {
                return new UpdateException(errorCode, "Cannot update. Vote with id" + id + " not found");
            }
            default -> {
                return new UpdateException(errorCode, "Unknown Error");
            }
        }
    }

}
