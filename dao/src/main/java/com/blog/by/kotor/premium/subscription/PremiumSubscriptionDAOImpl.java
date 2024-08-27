package com.blog.by.kotor.premium.subscription;

import com.blog.by.kotor.PremiumSubscription;
import com.blog.by.kotor.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PremiumSubscriptionDAOImpl implements PremiumSubscriptionDAO {

    private static final String DELETE = "DELETE FROM premium_subscriptions WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM premium_subscriptions ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM premium_subscriptions WHERE id = ?";
    private static final String IS_PREMIUM = "SELECT * FROM premium_subscriptions WHERE id = ?";
    private static final String FIND_BY_USER_ID = "SELECT * FROM premium_subscriptions WHERE user_id = ?";
    private static final String INSERT = "INSERT INTO premium_subscriptions (user_id, start_date, end_date) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE premium_subscriptions set user_id = ?, start_date = ?, end_date = ? WHERE id = ?";

    @Override
    public PremiumSubscription findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PremiumSubscription premiumSubscription = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                premiumSubscription = new PremiumSubscription();
                premiumSubscription.setId(rs.getInt("id"));
                premiumSubscription.setUserId(rs.getInt("user_id"));
                premiumSubscription.setStartDate(rs.getDate("start_date"));
                premiumSubscription.setEndDate(rs.getDate("end_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return premiumSubscription;
    }


    @Override
    public List<PremiumSubscription> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PremiumSubscription> premiumSubscriptionList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                PremiumSubscription premiumSubscription = new PremiumSubscription();
                premiumSubscription.setId(rs.getInt("id"));
                premiumSubscription.setUserId(rs.getInt("user_id"));
                premiumSubscription.setStartDate(rs.getDate("start_date"));
                premiumSubscription.setEndDate(rs.getDate("end_date"));
                premiumSubscriptionList.add(premiumSubscription);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return premiumSubscriptionList;
    }

    @Override
    public int insert(PremiumSubscription premiumSubscription) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, premiumSubscription.getUserId());
            ps.setDate(2, premiumSubscription.getStartDate());
            ps.setDate(3, premiumSubscription.getEndDate());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(conn);
            Util.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int update(PremiumSubscription oldPremiumSubscription, PremiumSubscription newPremiumSubscription) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();
            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newPremiumSubscription.getUserId());
            ps.setDate(2, newPremiumSubscription.getStartDate());
            ps.setDate(3, newPremiumSubscription.getEndDate());
            ps.setInt(4, oldPremiumSubscription.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(conn);
            Util.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int delete(PremiumSubscription premiumSubscription) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, premiumSubscription.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(conn);
            Util.closePreparedStatement(ps);
        }
        return 0;
    }


    @Override
    public List<PremiumSubscription> findByUserId(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PremiumSubscription> premiumSubscriptionList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_USER_ID);
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                PremiumSubscription premiumSubscription = new PremiumSubscription();
                premiumSubscription.setId(rs.getInt("id"));
                premiumSubscription.setUserId(rs.getInt("user_id"));
                premiumSubscription.setStartDate(rs.getDate("start_date"));
                premiumSubscription.setEndDate(rs.getDate("end_date"));
                premiumSubscriptionList.add(premiumSubscription);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return premiumSubscriptionList;
    }

    @Override
    public boolean isPremiumSubscription(int userId) {
        boolean isPremiumSubscription = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(IS_PREMIUM);
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                isPremiumSubscription = rs.getBoolean("is_premium");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return isPremiumSubscription;
    }

}
