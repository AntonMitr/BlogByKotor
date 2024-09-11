package com.blog.by.kotor;

public class PollDAO extends AbstractHibernateDao<Poll> {

    private static PollDAO pollDAO;

    private PollDAO() {
        super(Poll.class);
    }

    public static PollDAO getPollDAO() {
        if (pollDAO == null) {
            pollDAO = new PollDAO();
        }
        return pollDAO;
    }

}
