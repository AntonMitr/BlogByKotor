package com.blog.by.kotor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VoteDAO extends AbstractHibernateDao<Vote> {

    public VoteDAO() {
        super(Vote.class);
    }

}
