package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Poll;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PollDAO extends AbstractHibernateDao<Poll> {

    @Autowired
    public PollDAO(SessionFactory sessionFactory) {
        super(Poll.class, sessionFactory);
    }

}
