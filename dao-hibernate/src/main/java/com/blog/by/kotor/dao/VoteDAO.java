package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Vote;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VoteDAO extends AbstractHibernateDao<Vote> {

    @Autowired
    public VoteDAO(SessionFactory sessionFactory) {
        super(Vote.class, sessionFactory);
    }

}
