package persistance;

import org.apache.derby.client.am.SqlException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseMirror {
    private Connection mySQL;
    private Connection derby;

    public DatabaseMirror() throws SqlException, ClassNotFoundException, SQLException, IOException {
        this.mySQL = DatabaseSelection.getDatabase(DatabaseEnumeration.MYSQL);
        this.derby = DatabaseSelection.getDatabase(DatabaseEnumeration.DERBY);
    }

    public Connection getMySQL() {
        return mySQL;
    }

    public Connection getDerby() {
        return derby;
    }
}
