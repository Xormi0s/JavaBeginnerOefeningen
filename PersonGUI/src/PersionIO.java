import java.io.IOException;
import java.sql.*;

public class PersionIO {

    public static Persoon getPersoon(String voornaam, String achternaam) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sqlString = "Select * from persoon where voornaam = ? && achternaam = ? ";
        PreparedStatement statement = connection.prepareStatement(sqlString);
        statement.setString(1, voornaam);
        statement.setString(2, achternaam);

        Persoon output = null;
        try  {
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                ResultSetMetaData md = set.getMetaData();
                output = new Persoon(set.getString(2), set.getString(3),set.getDate(4), set.getString(5), set.getInt(6), set.getString(7));
            }
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception "+sqlException.getSQLState());
            throw new SQLException(sqlException);
        }

        return output;
    }

    public static void setPersoon(String voornaam, String achternaam, Date geboortedatum, String adres, int postcode, String gemeente) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("insert into persoon Values(?,?,?,?,?,?,?)");

        preparedStatement.setString(1, null);
        preparedStatement.setString(2, voornaam);
        preparedStatement.setString(3, achternaam);
        preparedStatement.setDate(4, geboortedatum);
        preparedStatement.setString(5, adres);
        preparedStatement.setInt(6, postcode);
        preparedStatement.setString(7, gemeente);
        preparedStatement.execute();
    }

    public static void changePersoon(String voornaam, String achternaam, Date geboortedatum, String adres, int postcode, String gemeente) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE persoon set geboortedatum = ?, adres = ?, postcode = ?, gemeente = ? Where voornaam = ? && achternaam = ?");

        preparedStatement.setDate(1, geboortedatum);
        preparedStatement.setString(2, adres);
        preparedStatement.setInt(3, postcode);
        preparedStatement.setString(4, gemeente);
        preparedStatement.setString(5, voornaam);
        preparedStatement.setString(6, achternaam);
        preparedStatement.execute();
    }
}
