alter table comments drop foreign key comments_ibfk_1;
alter table comments drop foreign key comments_ibfk_2;

alter table options drop foreign key options_ibfk_1;

alter table polls drop foreign key polls_ibfk_1;

alter table posts drop foreign key posts_ibfk_1;

alter table posts_categories drop foreign key posts_categories_ibfk_1;
alter table posts_categories drop foreign key posts_categories_ibfk_2;

alter table posts_tags drop foreign key posts_tags_ibfk_1;
alter table posts_tags drop foreign key posts_tags_ibfk_2;

alter table premium_subscriptions drop foreign key premium_subscriptions_ibfk_1;

alter table questions drop foreign key questions_ibfk_1;

alter table user_answers drop foreign key user_answers_ibfk_1;
alter table user_answers drop foreign key user_answers_ibfk_2;
alter table user_answers drop foreign key user_answers_ibfk_3;

alter table users_roles drop foreign key users_roles_ibfk_1;
alter table users_roles drop foreign key users_roles_ibfk_2;

alter table votes drop foreign key votes_ibfk_1;
alter table votes drop foreign key votes_ibfk_2;
alter table votes drop foreign key votes_ibfk_3;

drop table categories;
drop table comments;
drop table filters;
drop table options;
drop table polls;
drop table posts;
drop table posts_categories;
drop table posts_tags;
drop table premium_subscriptions;
drop table roles;
drop table tags;
drop table user_answers;
drop table users;
drop table users_roles;
drop table votes;
drop table questions;

drop database blog_by_kotor;
