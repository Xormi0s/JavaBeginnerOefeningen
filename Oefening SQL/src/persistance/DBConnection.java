package persistance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DBConnection {
    private static final String DATABASE = "database";
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    //ApacheDG, JavaDB, Derby (Apache.org)
    private static DatabaseEnumeration database;
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static File file;

   public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
    file = new File("database.properties");
       Properties p = new Properties();
           p.load(new FileInputStream(file));
           database = DatabaseEnumeration.valueOf(p.getProperty(DATABASE));
           url = p.getProperty(URL);
           driver = p.getProperty(DRIVER);
           user = p.getProperty(USER);
           password = p.getProperty(PASSWORD);

       //Load Driver
       Class.forName(driver);
       System.out.println("Driver loaded");
       // Connect to a database
       Connection connection = DriverManager.getConnection
               (url, user, password);

       return connection;
   }
}
