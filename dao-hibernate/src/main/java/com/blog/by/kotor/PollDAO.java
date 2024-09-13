package com.blog.by.kotor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PollDAO extends AbstractHibernateDao<Poll> {

    public PollDAO() {
        super(Poll.class);
    }

}
