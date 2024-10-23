insert into users (name, email, password)
values ('Anton', 'Anton1234@gmail.com', 'qwerty1');
insert into users (name, email, password)
values ('Mike', 'Mike1234@gmail.com', 'qwerty12');
insert into users (name, email, password)
values ('Jhon', 'Jhon1234@gmail.com', 'qwerty123');
insert into users (name, email, password)
values ('Wilder', 'Wilder1234@gmail.com', 'qwerty1234');
insert into users (name, email, password)
values ('Tom', 'Tom1234@gmail.com', 'qwerty12345');

insert into posts (user_id, title, content, date_published, is_premium, is_published)
values (1, 'All about sport', 'adsfodjjkadfjsbjkfdanfsbfkfkfadn', '2024-03-13', 0, 1);
insert into posts (user_id, title, content, date_published, is_premium, is_published)
values (1, 'Nice food', 'adsfodjjkadfjsbjkfdanfsbfkffgdkfadn', '2024-03-15', 0, 1);
insert into posts (user_id, title, content, date_published, is_premium, is_published)
values (3, 'Job for me', 'adsfodjjkadfjsbjafdsdgbfkfdanfsbfkfkfadn', '2024-03-13', 1, 1);


insert into tags (name)
values ('cool');
insert into tags (name)
values ('lol');
insert into tags (name)
values ('wow');
insert into tags (name)
values ('good');
insert into tags (name)
values ('like');

insert into categories (name)
values ('Sport');
insert into categories (name)
values ('It');
insert into categories (name)
values ('Food');
insert into categories (name)
values ('Jobs');
insert into categories (name)
values ('Housework');

insert into comments (user_id, post_id, content, created_at)
values (2, 1, 'fghgdsdfgb', '2024-03-16 13:13:03');
insert into comments (user_id, post_id, content, created_at)
values (2, 1, 'sadfsdbgnfgradsgfd', '2024-03-16 13:14:00');
insert into comments (user_id, post_id, content, created_at)
values (4, 3, 'dkfjgbjgklsdfjg', '2024-04-23 13:13:03');

insert into posts_categories (post_id, category_id)
values (1, 1);
insert into posts_categories (post_id, category_id)
values (2, 3);
insert into posts_categories (post_id, category_id)
values (2, 5);
insert into posts_categories (post_id, category_id)
values (3, 4);

insert into posts_tags (post_id, tag_id)
values (1, 1);
insert into posts_tags (post_id, tag_id)
values (1, 2);
insert into posts_tags (post_id, tag_id)
values (1, 3);
insert into posts_tags (post_id, tag_id)
values (2, 3);
insert into posts_tags (post_id, tag_id)
values (2, 4);
insert into posts_tags (post_id, tag_id)
values (3, 2);
insert into posts_tags (post_id, tag_id)
values (3, 5);

insert into premium_subscriptions (user_id, start_date, end_date)
values (2, '2024-08-21 12:21:21', '2024-09-21 12:21:21');
insert into premium_subscriptions (user_id, start_date, end_date)
values (3, '2024-09-21 12:21:21', '2024-10-21 12:21:21');

insert into roles (name)
values ('reader');
insert into roles (name)
values ('writer');
insert into roles (name)
values ('admin');
insert into roles (name)
values ('moderator');

insert into users_roles (user_id, role_id)
values (1, 1);
insert into users_roles (user_id, role_id)
values (1, 2);
insert into users_roles (user_id, role_id)
values (2, 1);
insert into users_roles (user_id, role_id)
values (3, 1);
insert into users_roles (user_id, role_id)
values (4, 2);
insert into users_roles (user_id, role_id)
values (5, 1);
insert into users_roles (user_id, role_id)
values (5, 2);
insert into users_roles (user_id, role_id)
values (5, 3);

insert into polls (user_id, title, description)
values (1, 'WQEWRWSFDGFBASFD', 'sdfghjhgfds');

insert into questions (poll_id, question_text)
values (1, 'asdfghgfdsmdm');
insert into questions (poll_id, question_text)
values (1, 'ewgfgjhsaasgf');
insert into questions (poll_id, question_text)
values (1, 'gghgsgdggaf');
insert into questions (poll_id, question_text)
values (1, 'fg,gl,df,glgdfgb');

insert into options (question_id, option_text)
values (1, 'sdfgbgd');
insert into options (question_id, option_text)
values (2, 'sdfghgdf');
insert into options (question_id, option_text)
values (3, 'sfghmhgfd');
insert into options (question_id, option_text)
values (4, 'xdfghhefgh');

insert into user_answers (question_id, user_id, option_id)
values (1, 1, 1);
insert into user_answers (question_id, user_id, option_id)
values (2, 2, 2);
insert into user_answers (question_id, user_id, option_id)
values (3, 3, 3);

insert into votes (post_id, user_id, option_id)
values ();
insert into votes (post_id, user_id, option_id)
values ();

