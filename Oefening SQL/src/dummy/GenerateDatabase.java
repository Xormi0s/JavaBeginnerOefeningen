package dummy;

import dummy.test.PersistentCourse;
import dummy.test.PersistentEnrollment;
import dummy.test.PersistentStudent;
import persistance.DatabaseEnumeration;
import persistance.DatabaseSelection;

import java.io.IOException;
import java.sql.SQLException;

public class GenerateDatabase {
    public static void main(String[] args) {
        if (args.length == 1){
            DatabaseSelection.setCurrentDatabase(DatabaseEnumeration.valueOf(args[0]));
        }

        DatabaseEnumeration database = DatabaseSelection.getCurrentDatabase();
        try {
            PersistentStudent.initialLoad();
            PersistentCourse.initialLoad();
            PersistentEnrollment.initialLoad();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
