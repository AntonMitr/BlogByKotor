package com.blog.by.kotor.exception.find.by.id;

import com.blog.by.kotor.exception.ErrorCode;

public class FindByIdExceptionFactory {

    public static FindByIdException moduleNotFound(ErrorCode errorCode, Integer id) {
        switch (errorCode) {
            case CATEGORY_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Category with id" + id + " not found");
            }
            case COMMENT_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Comment with id" + id + " not found");
            }
            case FILTER_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Filter with id" + id + " not found");
            }
            case OPTION_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Option with id" + id + " not found");
            }
            case POLL_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Poll with id" + id + " not found");
            }
            case POST_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Post with id" + id + " not found");
            }
            case PREMIUM_SUBSCRIPTION_NOT_FOUND -> {
                return new FindByIdException(errorCode, "PremiumSubscription with id" + id + " not found");
            }
            case QUESTION_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Question with id" + id + " not found");
            }
            case ROLE_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Role with id" + id + " not found");
            }
            case TAG_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Tag with id" + id + " not found");
            }
            case USER_NOT_FOUND -> {
                return new FindByIdException(errorCode, "User with id" + id + " not found");
            }
            case VOTE_NOT_FOUND -> {
                return new FindByIdException(errorCode, "Vote with id" + id + " not found");
            }
            default -> {
                return new FindByIdException(errorCode, "Unknown Error");
            }
        }
    }

}
