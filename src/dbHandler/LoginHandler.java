package dbHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginHandler extends DatabaseHandler{
    String email;
    String password;

    public LoginHandler( String email, String password) throws SQLException, ClassNotFoundException {
        super();
        this.email = email;
        this.password = password;
    }
    public boolean isLogin() throws SQLException, ClassNotFoundException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        Connection connection = getConnection();

        String sql = "SELECT * FROM STAFF where email = ? and password = ?";

        try {

            pr = connection.prepareStatement(sql);
            pr.setString(1, email);
            pr.setString(2, password);

            rs = pr.executeQuery();
            boolean bool1;

            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();

            return false;
        }
        finally {
            {
                pr.close();
                rs.close();
            }
        }
    }
}
