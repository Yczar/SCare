package dbHandler;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.SQLException;

public class SignUpDBHandler extends DatabaseHandler{
    private String fullname;
    private String email;
    private String password;
    private String department;
    private String staffid;


    public SignUpDBHandler(String fullname, String email, String password, String department, String staffid) throws SQLException, ClassNotFoundException {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.department = department;
        this.staffid = staffid;
    }

    public void signUp(){
        String action = "INSERT INTO STAFF VALUES (" +
                "'"+ staffid +"',"+
                "'"+ fullname +"',"+
                "'"+ email +"',"+
                "'"+ password +"',"+
                "'"+ department +"'"+
                ")";
        if (execAction(action)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Signed Up Successfully. You can now sign in using your email and password");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Staff ID already exists");
            alert.showAndWait();
        }
    }

}
