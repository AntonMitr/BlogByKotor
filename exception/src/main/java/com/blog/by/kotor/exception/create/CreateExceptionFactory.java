package com.blog.by.kotor.exception.create;

import com.blog.by.kotor.exception.NotNullParam;

public class CreateExceptionFactory {

    public static CreateException CategoryParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case CATEGORY_ID -> {
                return new CreateException(notNullParam, "Category_id cannot be null");
            }
            case CATEGORY_NAME -> {
                return new CreateException(notNullParam, "Category_name cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException CommentParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case COMMENT_ID -> {
                return new CreateException(notNullParam, "Comment_id cannot be null");
            }
            case COMMENT_POST_ID -> {
                return new CreateException(notNullParam, "Comment_post_id cannot be null");
            }
            case COMMENT_CONTENT -> {
                return new CreateException(notNullParam, "Comment_content cannot be null");
            }
            case COMMENT_CREATED_AT -> {
                return new CreateException(notNullParam, "Comment_created_at cannot be null");
            }
            case COMMENT_USER_ID -> {
                return new CreateException(notNullParam, "Comment_user_id cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException FilterParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case FILTER_CRITERIA -> {
                return new CreateException(notNullParam, "Filter_criteria cannot be null");
            }
            case FILTER_ID -> {
                return new CreateException(notNullParam, "Filter_id cannot be null");
            }
            case FILTER_NAME -> {
                return new CreateException(notNullParam, "Filter_name cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException OptionParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case OPTION_ID -> {
                return new CreateException(notNullParam, "Option_id cannot be null");
            }
            case OPTION_QUESTION_ID -> {
                return new CreateException(notNullParam, "Option_question_id cannot be null");
            }
            case OPTION_TEXT -> {
                return new CreateException(notNullParam, "Option_text cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException PollParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case POLL_ID -> {
                return new CreateException(notNullParam, "Poll_id cannot be null");
            }
            case POLL_DESCRIPTION -> {
                return new CreateException(notNullParam, "Poll_description cannot be null");
            }
            case POLL_CREATED_AT -> {
                return new CreateException(notNullParam, "Poll_created_at cannot be null");
            }
            case POLL_TITLE -> {
                return new CreateException(notNullParam, "Poll_title cannot be null");
            }
            case POLL_USER_ID -> {
                return new CreateException(notNullParam, "Poll_user_id cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException PostParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case POST_ID -> {
                return new CreateException(notNullParam, "Post_id cannot be null");
            }
            case POST_CONTENT -> {
                return new CreateException(notNullParam, "Post_content cannot be null");
            }
            case POST_DATE_PUBLISHED -> {
                return new CreateException(notNullParam, "Post_date_published cannot be null");
            }
            case POST_IS_PREMIUM -> {
                return new CreateException(notNullParam, "Post_is_premium cannot be null");
            }
            case POST_IS_PUBLISHED -> {
                return new CreateException(notNullParam, "Post_is_published cannot be null");
            }
            case POST_TITLE -> {
                return new CreateException(notNullParam, "Post_title cannot be null");
            }
            case POST_USER_ID -> {
                return new CreateException(notNullParam, "Post_user_id cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException PostCategoryParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case POST_CATEGORY_POST_ID -> {
                return new CreateException(notNullParam, "Post_category_post_id cannot be null");
            }
            case POST_CATEGORY_CATEGORY_ID -> {
                return new CreateException(notNullParam, "Post_category_category_id cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException PostTagParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case POST_TAG_POST_ID -> {
                return new CreateException(notNullParam, "Post_tag_post_id cannot be null");
            }
            case POST_TAG_TAG_ID -> {
                return new CreateException(notNullParam, "Post_tag_tag_id cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException PremiumSubscriptionParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case PREMIUM_SUBSCRIPTION_ID -> {
                return new CreateException(notNullParam, "Premium_subscription_id cannot be null");
            }
            case PREMIUM_SUBSCRIPTION_USER_ID -> {
                return new CreateException(notNullParam, "Premium_subscription_user_id cannot be null");
            }
            case PREMIUM_SUBSCRIPTION_START_DATE -> {
                return new CreateException(notNullParam, "Premium_subscription_start_date cannot be null");
            }
            case PREMIUM_SUBSCRIPTION_END_DATE -> {
                return new CreateException(notNullParam, "Premium_subscription_end_date cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException QuestionParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case QUESTION_ID -> {
                return new CreateException(notNullParam, "Question_id cannot be null");
            }
            case QUESTION_POLL_ID -> {
                return new CreateException(notNullParam, "Question_poll_id cannot be null");
            }
            case QUESTION_TEXT -> {
                return new CreateException(notNullParam, "Question_text cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException RoleParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case ROLE_ID -> {
                return new CreateException(notNullParam, "Role_id cannot be null");
            }
            case ROLE_NAME -> {
                return new CreateException(notNullParam, "Role_name cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException TagParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case TAG_ID -> {
                return new CreateException(notNullParam, "Tag_id cannot be null");
            }
            case TAG_NAME -> {
                return new CreateException(notNullParam, "Tag_name cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException UserParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case USER_ID -> {
                return new CreateException(notNullParam, "User_id cannot be null");
            }
            case USER_CREATED_AT -> {
                return new CreateException(notNullParam, "User_created_at cannot be null");
            }
            case USER_EMAIL -> {
                return new CreateException(notNullParam, "User_email cannot be null");
            }
            case USER_NAME -> {
                return new CreateException(notNullParam, "User_text cannot be null");
            }
            case USER_PASSWORD -> {
                return new CreateException(notNullParam, "User_password cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException UserRoleParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case USER_ROLE_USER_ID -> {
                return new CreateException(notNullParam, "User_role_user_id cannot be null");
            }
            case USER_ROLE_ROLE_ID -> {
                return new CreateException(notNullParam, "User_role_role_id cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

    public static CreateException VoteRoleParamNotBeNull(NotNullParam notNullParam) {
        switch (notNullParam) {
            case VOTE_ID -> {
                return new CreateException(notNullParam, "Vote_id cannot be null");
            }
            case VOTE_OPTION_ID -> {
                return new CreateException(notNullParam, "Vote_option_id cannot be null");
            }
            case VOTE_POST_ID -> {
                return new CreateException(notNullParam, "Vote_post_id cannot be null");
            }
            case VOTE_USER_ID -> {
                return new CreateException(notNullParam, "Vote_user_id cannot be null");
            }
            default -> {
                return new CreateException(notNullParam, "Unknown Error");
            }
        }
    }

}
