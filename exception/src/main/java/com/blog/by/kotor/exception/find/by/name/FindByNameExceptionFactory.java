package com.blog.by.kotor.exception.find.by.name;

import com.blog.by.kotor.exception.ErrorCode;

public class FindByNameExceptionFactory {

    public static FindByNameException moduleNotFound(ErrorCode errorCode, String name) {
        switch (errorCode) {
            case CATEGORY_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Category with name" + name + " not found");
            }
            case COMMENT_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Comment with name" + name + " not found");
            }
            case FILTER_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Filter with name" + name + " not found");
            }
            case OPTION_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Option with name" + name + " not found");
            }
            case POLL_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Poll with name" + name + " not found");
            }
            case POST_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Post with name" + name + " not found");
            }
            case PREMIUM_SUBSCRIPTION_NOT_FOUND -> {
                return new FindByNameException(errorCode, "PremiumSubscription with name" + name + " not found");
            }
            case QUESTION_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Question with name" + name + " not found");
            }
            case ROLE_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Role with name" + name + " not found");
            }
            case TAG_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Tag with name" + name + " not found");
            }
            case USER_NOT_FOUND -> {
                return new FindByNameException(errorCode, "User with name" + name + " not found");
            }
            case VOTE_NOT_FOUND -> {
                return new FindByNameException(errorCode, "Vote with name" + name + " not found");
            }
            default -> {
                return new FindByNameException(errorCode, "Unknown Error");
            }
        }
    }
    
}
