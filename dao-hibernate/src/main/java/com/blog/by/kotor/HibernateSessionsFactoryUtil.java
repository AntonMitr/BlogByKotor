package com.blog.by.kotor;

import com.blog.by.kotor.postCategory.PostCategory;
import com.blog.by.kotor.postTag.PostTag;
import com.blog.by.kotor.userRole.UserRole;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSessionsFactoryUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateSessionsFactoryUtil.class);

    private static SessionFactory sessionFactory;

    private HibernateSessionsFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
                        .addAnnotatedClass(Category.class)
                        .addAnnotatedClass(Comment.class)
                        .addAnnotatedClass(Filter.class)
                        .addAnnotatedClass(Option.class)
                        .addAnnotatedClass(Poll.class)
                        .addAnnotatedClass(Post.class)
                        .addAnnotatedClass(PostCategory.class)
                        .addAnnotatedClass(PostTag.class)
                        .addAnnotatedClass(PremiumSubscription.class)
                        .addAnnotatedClass(Question.class)
                        .addAnnotatedClass(Role.class)
                        .addAnnotatedClass(Tag.class)
                        .addAnnotatedClass(User.class)
                        .addAnnotatedClass(UserRole.class)
                        .addAnnotatedClass(Vote.class)
                        .configure()
                        .buildSessionFactory();
            } catch (Exception e) {
                LOGGER.error("Нет подлючения к базе данных! {}", e.getMessage(), e);
            }
        }
        return sessionFactory;
    }

}
