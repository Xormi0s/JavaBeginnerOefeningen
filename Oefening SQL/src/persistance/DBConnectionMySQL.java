package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 class DBConnectionMySQL {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        // Connect to a database
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/javabook?characterEncoding=utf8", "JavaOef", "Noobcake1");
        return connection;
    }
}
