package com.blog.by.kotor.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    CATEGORY_NOT_FOUND ("Category with id %d not found"),
    COMMENT_NOT_FOUND ("Comment with id %d not found"),
    FILTER_NOT_FOUND ("Filter with id %d not found"),
    OPTION_NOT_FOUND ("Option with id %d not found"),
    POLL_NOT_FOUND ("Poll with id %d not found"),
    POST_NOT_FOUND ("Post with id %d not found"),
    PREMIUM_SUBSCRIPTION_NOT_FOUND ("PremiumSubscription with id %d not found"),
    QUESTION_NOT_FOUND("Question with id %d not found"),
    ROLE_NOT_FOUND ("Role with id %d not found"),
    TAG_NOT_FOUND ("Tag with id %d not found"),
    USER_NOT_FOUND ("User with id %d not found"),
    VOTE_NOT_FOUND ("Vote with id %d not found"),

    CATEGORY_NAME_NOT_FOUND ("Category with name %d not found"),
    COMMENT_NAME_NOT_FOUND ("Comment with name %d not found"),
    FILTER_NAME_NOT_FOUND ("Filter with name %d not found"),
    OPTION_NAME_NOT_FOUND ("Option with name %d not found"),
    POLL_NAME_NOT_FOUND ("Poll with name %d not found"),
    POST_NAME_NOT_FOUND ("Post with name %d not found"),
    PREMIUM_SUBSCRIPTION_NAME_NOT_FOUND ("PremiumSubscription with name %d not found"),
    QUESTION_NAME_NOT_FOUND ("Question with name %d not found"),
    ROLE_NAME_NOT_FOUND ("Role with name %d not found"),
    TAG_NAME_NOT_FOUND ("Tag with name %d not found"),
    USER_NAME_NOT_FOUND ("User with name %d not found"),
    VOTE_NAME_NOT_FOUND ("Vote with name %d not found"),


    CATEGORY_ID ("Category_id cannot be null"),
    CATEGORY_NAME ("Category_name cannot be null"),

    COMMENT_ID ("Comment_id cannot be null"),
    COMMENT_POST_ID ("Comment_post_id cannot be null"),
    COMMENT_USER_ID ("Comment_user_id cannot be null"),
    COMMENT_CONTENT ("Comment_content cannot be null"),
    COMMENT_CREATED_AT ("Comment_created_at cannot be null"),

    FILTER_ID ("Filter_id cannot be null"),
    FILTER_NAME ("Filter_name cannot be null"),
    FILTER_CRITERIA ("Filter_criteria cannot be null"),

    OPTION_ID ("Option_id cannot be null"),
    OPTION_QUESTION_ID ("Option_question_id cannot be null"),
    OPTION_TEXT ("Option_text cannot be null"),

    POLL_ID ("Poll_id cannot be null"),
    POLL_USER_ID ("Poll_user_id cannot be null"),
    POLL_DESCRIPTION ("Poll_description cannot be null"),
    POLL_TITLE ("Poll_title cannot be null"),
    POLL_CREATED_AT ("Poll_created_at cannot be null"),

    POST_ID ("Post_id cannot be null"),
    POST_IS_PREMIUM ("Post_is_premium cannot be null"),
    POST_IS_PUBLISHED ("Post_is_published cannot be null"),
    POST_USER_ID ("Post_user_id cannot be null"),
    POST_CONTENT ("Post_content cannot be null"),
    POST_TITLE ("Post_title cannot be null"),
    POST_DATE_PUBLISHED ("Post_date_published cannot be null"),

    POST_CATEGORY_CATEGORY_ID ("Post_category_category_id cannot be null"),
    POST_CATEGORY_POST_ID ("Post_category_post_id cannot be null"),

    POST_TAG_POST_ID ("Post_tag_post_id cannot be null"),
    POST_TAG_TAG_ID ("Post_tag_tag_id cannot be null"),

    PREMIUM_SUBSCRIPTION_ID ("PremiumSubscription_id cannot be null"),
    PREMIUM_SUBSCRIPTION_USER_ID ("PremiumSubscription_user_id cannot be null"),
    PREMIUM_SUBSCRIPTION_START_DATE ("PremiumSubscription_start_date cannot be null"),
    PREMIUM_SUBSCRIPTION_END_DATE ("PremiumSubscription_end_date cannot be null"),

    QUESTION_ID ("Question_id cannot be null"),
    QUESTION_POLL_ID ("Question_poll_id cannot be null"),
    QUESTION_TEXT ("Question_text cannot be null"),

    ROLE_ID ("Role_id cannot be null"),
    ROLE_NAME ("Role_name cannot be null"),

    TAG_ID ("Tag_id cannot be null"),
    TAG_NAME ("Tag_name cannot be null"),

    USER_ID ("User_id cannot be null"),
    USER_NAME ("User_name cannot be null"),
    USER_EMAIL ("User_email cannot be null"),
    USER_PASSWORD ("User_password cannot be null"),
    USER_CREATED_AT ("User_created_at cannot be null"),

    USER_ROLE_ROLE_ID ("User_role_role_id cannot be null"),
    USER_ROLE_USER_ID ("User_role_user_id cannot be null"),

    VOTE_ID ("Vote_id cannot be null"),
    VOTE_OPTION_ID ("Vote_option_id cannot be null"),
    VOTE_POST_ID ("Vote_post_id cannot be null"),
    VOTE_USER_ID ("Vote_user_id cannot be null");

    private final String message;

}
