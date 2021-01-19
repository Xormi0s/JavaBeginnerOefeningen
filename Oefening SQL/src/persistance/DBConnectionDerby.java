package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 class DBConnectionDerby {
     //ApacheDG, JavaDB, Derby (Apache.org)
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //Load Driver
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        System.out.println("Driver loaded");
        // Connect to a database
        Connection connection = DriverManager.getConnection
                ("jdbc:derby://localhost:1527/javabook", "Mathy", "Npngnmtj0");

        return connection;
    }
}
