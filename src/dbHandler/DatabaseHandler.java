package dbHandler;


import java.sql.*;

public class DatabaseHandler {
    private static Connection c = null;
    private static final String SQLNAME = "jdbc:sqlite:scare.sqlite";
    private static Statement statement = null;

    public DatabaseHandler() throws SQLException, ClassNotFoundException {
        getConnection();
        createStaffTable();
        createPatientsTable();
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (c == null) {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(SQLNAME);
        }
        return c;
    }

    void createStaffTable() throws SQLException {
        String TABLE_NAME = "STAFF";
        statement = c.createStatement();
        DatabaseMetaData databaseMetaData = c.getMetaData();
        ResultSet tables = databaseMetaData.getTables(null, null, TABLE_NAME.toUpperCase(), null);

        if (tables.next()) {
            System.out.println(TABLE_NAME + " Table Already Created");
        } else {
            statement.execute("CREATE TABLE " + TABLE_NAME + "("
                    + " id varchar(200) primary key, \n"
                    + " fullname varchar(200), \n"
                    + " email varchar(200), \n"
                    + " password varchar(200), \n"
                    + " department varchar(200)"
                    + " )");
        }
    }

    void createPatientsTable() throws SQLException {
        String TABLE_NAME = "PATIENTS";
        statement = c.createStatement();
        DatabaseMetaData databaseMetaData = c.getMetaData();
        ResultSet tables = databaseMetaData.getTables(null, null, TABLE_NAME.toUpperCase(), null);

        if (tables.next()) {
            System.out.println(TABLE_NAME + " Table Already Created");
        } else {
            statement.execute("CREATE TABLE " + TABLE_NAME + "("
                    + " id varchar(200) primary key, \n"
                    + " firstname varchar(200), \n"
                    + " middlename varchar(200), \n"
                    + " lastname varchar(200), \n"
                    + " scarenumber varchar(200), \n"
                    + " dob varchar(200), \n"
                    + " gender varchar(200), \n"
                    + " maritalstatus varchar(200), \n"
                    + " address varchar(200), \n"
                    + " city_town varchar(200), \n"
                    + " state varchar(200), \n"
                    + " mobilenumber varchar(200), \n"
                    + " mobilenumber2 varchar(200), \n"
                    + " poc varchar(200), \n"
                    + " otherinformations varchar(200)"
                    + " )" );
        }
    }

    public boolean execAction(String query) {
        try {
            statement = c.createStatement();
            statement.execute(query);
            return true;
        } catch (SQLException e) {

            return false;
        } finally {

        }
    }

}
