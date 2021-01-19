package persistance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseSelection {
    private static Connection connection;
    private static DatabaseEnumeration currentDatabase;

    private static Connection getSelection(DatabaseEnumeration database) throws SQLException, ClassNotFoundException, IOException {
        System.out.println("Connected to "+database.toString());
        switch (database) {
            case DERBY:
                return DBConnectionDerby.getConnection();
            case MYSQL:
                return DBConnectionMySQL.getConnection();
            case PROPERTIES:
                return DBConnection.getConnection();
        }
        return null;
    }

    /*
    * Singleton
     */
    public static Connection getDatabase(DatabaseEnumeration database) throws SQLException, ClassNotFoundException, IOException {
            if ((connection == null) || (connection.isClosed())){
                currentDatabase = database;
                connection = getSelection(database);
            }
        return connection;
    }

    public static DatabaseEnumeration getCurrentDatabase() {
        if(currentDatabase == null){
            currentDatabase = DatabaseEnumeration.MYSQL;
        }
        return currentDatabase;
    }

    public static void setCurrentDatabase(DatabaseEnumeration currentDatabase) {
        DatabaseSelection.currentDatabase = currentDatabase;
    }
}
