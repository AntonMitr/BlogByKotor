CREATE SCHEMA IF NOT EXISTS blog_by_kotor;

create table users
(
    id int primary key auto_increment,
    name varchar(30) not null,
    email varchar(70) not null,
    password varchar(50) not null,
    created_at timestamp default current_timestamp,
    constraint users_unique unique (email)
);

create table posts
(
    id int primary key auto_increment,
    user_id int not null,
    foreign key (user_id) references users (id),
    title varchar(250) not null,
    content text not null,
    date_published timestamp default current_timestamp,
    is_premium tinyint(1) not null,
    is_published tinyint(1) not null
);

create table comments
(
    id int primary key auto_increment,
    user_id int not null,
    foreign key (user_id) references users (id),
    post_id int not null,
    foreign key (post_id) references posts (id),
    content varchar(2000) not null,
    created_at timestamp default current_timestamp
);

create table categories
(
    id int primary key auto_increment,
    name varchar(100) not null
);

create table posts_categories
(
    post_id int not null,
    foreign key (post_id) references posts (id),
    category_id int not null,
    foreign key (category_id) references categories (id),
    PRIMARY KEY (post_id, category_id)
);

create table tags
(
    id int primary key auto_increment,
    name varchar(100) not null
);

create table posts_tags
(
    post_id int not null,
    foreign key (post_id) references posts (id),
    tag_id int not null,
    foreign key (tag_id) references tags (id),
    PRIMARY KEY (post_id, tag_id)
);

create table premium_subscriptions
(
    id int primary key auto_increment,
    user_id int not null,
    foreign key (user_id) references users (id),
    start_date timestamp not null,
    end_date timestamp not null
);

create table roles
(
    id int primary key auto_increment,
    name varchar(40) not null
);

create table users_roles
(
    user_id int not null,
    foreign key (user_id) references users (id),
    role_id int not null,
    foreign key (role_id) references roles (id),
    primary key (user_id, role_id)
);

create table polls
(
    id int primary key auto_increment,
    user_id int not null,
    foreign key (user_id) references users(id),
    title varchar(250) not null,
    description TEXT,
    created_at timestamp default current_timestamp
);

create table questions
(
    id int primary key auto_increment,
    poll_id int not null,
    foreign key (poll_id) references polls(id),
    question_text text not null
);

create table options
(
    id int primary key auto_increment,
    question_id int not null,
    foreign key (question_id) references questions(id),
    option_text varchar(300) not null
);

create table user_answers
(
    id int primary key auto_increment,
    question_id int not null,
    foreign key (question_id) references questions(id),
    user_id int not null,
    foreign key (user_id) references users(id),
    option_id int,
    foreign key (option_id) references options(id),
    answer_text TEXT,
    created_at timestamp default current_timestamp
);

create table votes
(
    id int primary key auto_increment,
    post_id int not null,
    foreign key (post_id) references posts(id),
    user_id int not null,
    foreign key (user_id) references users(id),
    option_id int,
    foreign key (option_id) references options(id)
);

create table filters
(
    id int primary key not null,
    name varchar(255),
    criteria varchar(255) not null
);
