package example;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by Anders on 5/2/2016.
 * LOOK THROUGH AND CLOSE EVERYTHING
 */
public class DatabaseHandler {

    private final Connection conn;

    /**
     * Constructs a DatabaseHandler object by initializing
     * a connection and a statement object
     * @param location The database's location on the computer (e.g. "C:/")
     * @throws SQLException Since we use SQL, this exception has to be caught
     */
    public DatabaseHandler(String location) throws SQLException {
        this.conn = connect(location);
        Statement stmt = this.conn.createStatement();

        // creates the trash table
        stmt.execute("CREATE TABLE IF NOT EXISTS trash (\n"
                + "  id INTEGER PRIMARY KEY AUTOINCREMENT, \n"
                + "  type TEXT NOT NULL, \n"
                + "  weight REAL, \n"
                + "  date TEXT\n"
                + ");");

        // creates the sums table
        stmt.execute("CREATE TABLE IF NOT EXISTS sums (\n"
                + "  type TEXT NOT NULL, \n"
                + "  totalWeight REAL, \n"
                + "  currentWeight REAL, \n"
                + "  PRIMARY KEY(type)\n"
                + ");");

        stmt.close();
    }

    /**
     * Gets the weight (current or total) of a specific type.
     * @param type The type of the object
     * @param identifier The identifier (current or total weight)
     * @return The weight
     */
    private Double getWeight(String type, String identifier) {
        // read from the database
        PreparedStatement pstmt = null;
        try {
            conn.setAutoCommit(true);
            pstmt = conn.prepareStatement("SELECT totalWeight, currentWeight "
                    + "FROM sums WHERE type = ?");
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();

            // read and return the weight
            try {
                if(rs.next()) {
                    return rs.getDouble(identifier);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0.0;
    }

    /**
     * Returns the current weight of a specific type
     * Uses @link{getWeight} to do this.
     * @param type The type to measure the weight of
     * @return The weight
     */
    public double getCurrentWeight(String type) {
        return getWeight(type, "currentWeight");
    }

    /**
     * Returns the total weight of a specific type.
     * Uses @link{getWeight} to do this.
     * @param type The type to measure the weight of
     * @return The weight
     */
    public double getTotalWeight(String type) {
        return getWeight(type, "totalWeight");
    }

    /**
     * Adds an item to the database
     * @param type The type of the object (e.g flammable)
     * @param weight The weight of the object
     */
    public void addItem(String type, double weight) {
        // read the current and total weight back from the database and add the new weight
        double currentWeight = getCurrentWeight(type) + weight;
        double totalWeight = getTotalWeight(type) + weight;

        // run an SQL transaction to add the information to the trash and sums tables simultaneously
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            // prepare for transaction
            conn.setAutoCommit(false);
            int rowAffected;

            // update the trash table
            pstmt1 = conn.prepareStatement("INSERT INTO trash(type,weight,date) VALUES(?,?,?)");
            pstmt1.setString(1, type);
            pstmt1.setDouble(2, weight);
            pstmt1.setString(3, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new java.util.Date()));
            rowAffected = pstmt1.executeUpdate();

            // if operation failed, roll back transaction
            if (rowAffected != 1) {
                conn.rollback();
                System.out.println("Rolling back");
            }

            // update the sums table
            pstmt2 = conn.prepareStatement("UPDATE sums SET totalWeight = ? , "
                    + "currentWeight = ? "
                    + "WHERE type = ?");
            pstmt2.setDouble(1, totalWeight);
            pstmt2.setDouble(2, currentWeight);
            pstmt2.setString(3, type);
            rowAffected = pstmt2.executeUpdate();

            // if operation failed, roll back transaction
            if (rowAffected != 1) {
                conn.rollback();
                System.out.println("Rolling back");
            }

            // commit transaction
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstmt1 != null) {
                    pstmt1.close();
                }
                if (pstmt2 != null) {
                    pstmt2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Resets the current weight of a specific type of trash
     * @param type The type to reset
     */
    public void resetWeight(String type) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("UPDATE sums SET currentWeight = ? "
                    + "WHERE type = ?");
            pstmt.setDouble(1, 0);
            pstmt.setString(2, type);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Connects to a database
     * @param location The database's location on the computer (e.g. "C:/")
     * @return A connection object
     */
    private Connection connect(String location) {
        String url = "jdbc:sqlite:" + location + "/trash.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
