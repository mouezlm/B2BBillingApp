package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final Connection connection;

    /**
     * Creates a database connection to MySQL at localhost:3307 with username "root" and no password.
     *
     * @throws SQLException if a database access error occurs.
     */
    public DatabaseConnection() throws SQLException {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            String url = "jdbc:mysql://localhost:3307/b2b_billing";
            this.connection = DriverManager.getConnection(url, "root", "");
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found. Please ensure the dependency is added to the project.", e);
        }
    }

    /**
     * Returns the established database connection.
     *
     * @return The connection object.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Closes the database connection.
     */
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close database connection: " + e.getMessage());
        }
    }
}
