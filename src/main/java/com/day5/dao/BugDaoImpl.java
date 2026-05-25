package com.day5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.day5.model.Bug;
import com.day5.util.DatabaseUtil;

public class BugDaoImpl implements BugDao {

    private static final String INSERT_BUG =
            "INSERT INTO bugs(title, description, status) VALUES (?, ?, ?)";

    private static final String GET_ALL_BUGS =
            "SELECT * FROM bugs";

    private static final String UPDATE_STATUS =
            "UPDATE bugs SET status = ? WHERE id = ?";

    private static final String DELETE_BUG =
            "DELETE FROM bugs WHERE id = ?";

    @Override
    public boolean addBug(Bug bug) {

        try (
                Connection connection = DatabaseUtil.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(
                                INSERT_BUG,
                                Statement.RETURN_GENERATED_KEYS
                        )
        ) {

            ps.setString(1, bug.getTitle());
            ps.setString(2, bug.getDescription());
            ps.setString(3, bug.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    bug.setId(rs.getInt(1));
                }

                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error Adding Bug");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Bug> getAllBugs() {

        List<Bug> bugList = new ArrayList<>();

        try (
                Connection connection = DatabaseUtil.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(GET_ALL_BUGS);

                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Bug bug = new Bug();

                bug.setId(rs.getInt("id"));
                bug.setTitle(rs.getString("title"));
                bug.setDescription(rs.getString("description"));
                bug.setStatus(rs.getString("status"));

                bugList.add(bug);
            }

        } catch (SQLException e) {
            System.out.println("Error Fetching Bugs");
            e.printStackTrace();
        }

        return bugList;
    }

    @Override
    public boolean updateBugStatus(int id, String status) {

        try (
                Connection connection = DatabaseUtil.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(UPDATE_STATUS)
        ) {

            ps.setString(1, status);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error Updating Bug");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteBug(int id) {

        try (
                Connection connection = DatabaseUtil.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(DELETE_BUG)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error Deleting Bug");
            e.printStackTrace();
        }

        return false;
    }
}