package AssistantManager;

import java.sql.*;

public class AssistantManagerRepository {
    private Connection con;
    private PreparedStatement prst;

    private void getConnection() {
        try {
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/std_dtbs", "dev_user", "password");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void getPreparedStatement(String sql) {
        try {
            this.prst = con.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTable() {
        getConnection();

        try {
            String sql = "CREATE TABLE IF NOT EXISTS class_schedule (pazartesi VARCHAR(50), sali VARCHAR(50), carsamba VARCHAR(50), persembe VARCHAR(50), cuma VARCHAR(50), cumartesi VARCHAR(50), pazar VARCHAR(50))";
            getPreparedStatement(sql);
            prst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (prst != null) prst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createAnnouncementTable(String announcement) {
        getConnection();

        try {
            String sql = "CREATE TABLE IF NOT EXISTS t_announcement (announcement VARCHAR(160))";
            getPreparedStatement(sql);
            prst.execute();

            // Insert the announcement data into the table
            String insertSql = "INSERT INTO t_announcement (announcement) VALUES (?)";
            getPreparedStatement(insertSql);
            prst.setString(1, announcement);
            prst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (prst != null) prst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void newAnnouncement(String announcement) {
        getConnection();
        String sql = "TRUNCATE t_announcement";
        getPreparedStatement(sql);
        try {
            // Insert the announcement data into the table
            String insertSql = "INSERT INTO t_announcement (announcement) VALUES (?)";
            getPreparedStatement(insertSql);
            prst.setString(1, announcement);
            prst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (prst != null) prst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void showAnnouncement() {
        try {
            String sql = "SELECT announcement FROM t_announcement)";
            ResultSet resultSet = prst.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (prst != null) prst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error:" + e.getMessage());
            }
        }
    }


    public void createClassSchedule(String pzt1, String pzt2, String pzt3, String pzt4, String pzt5, String pzt6, String pzt7) {
        getConnection();

        try {
            String sql = "INSERT INTO dersprg (pazartesi, sali, carsamba, persembe, cuma, cumartesi, pazar) VALUES (?, ?, ?, ?, ?, ?, ?)";
            getPreparedStatement(sql);
            prst.setString(1, pzt1);
            prst.setString(2, pzt2);
            prst.setString(3, pzt3);
            prst.setString(4, pzt4);
            prst.setString(5, pzt5);
            prst.setString(6, pzt6);
            prst.setString(7, pzt7);

            prst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (prst != null) prst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}