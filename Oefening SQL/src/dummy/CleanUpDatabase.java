package dummy;
import dummy.test.PersistentCourse;
import dummy.test.PersistentStudent;
import persistance.DatabaseEnumeration;
import persistance.DatabaseSelection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CleanUpDatabase {
    public static void main(String[] args) {
        if (args.length == 1){
            DatabaseSelection.setCurrentDatabase(DatabaseEnumeration.valueOf(args[0]));
        }

        DatabaseEnumeration database = DatabaseSelection.getCurrentDatabase();
        try{
            PersistentCourse.cleanUp();
            PersistentStudent.cleanUp();
        //enrollment wordt automatisch leeg gemaakt via de Ref.Constraint On Delete Cascade
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
