package com.blog.by.kotor;

public class VoteDAO extends AbstractHibernateDao<Vote> {

    private static VoteDAO voteDAO;

    private VoteDAO() {
        super(Vote.class);
    }

    public static VoteDAO getVoteDAO() {
        if (voteDAO == null) {
            voteDAO = new VoteDAO();
        }
        return voteDAO;
    }

}
