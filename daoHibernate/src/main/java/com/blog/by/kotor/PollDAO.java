package com.blog.by.kotor;

import org.springframework.stereotype.Repository;

@Repository
public class PollDAO extends AbstractHibernateDao<Poll> {

    public PollDAO() {
        super(Poll.class);
    }

}
