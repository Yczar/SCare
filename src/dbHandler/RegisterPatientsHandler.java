package dbHandler;

import javafx.scene.control.Alert;

import java.sql.SQLException;

public class RegisterPatientsHandler extends DatabaseHandler{
    String firstname, middlename, lastname, idnumber, scarenumberm, dob, gender, status, address, citytown, state, mobilenumber, mobilenumber2, poc, otherinfo;

    public RegisterPatientsHandler(String firstname, String middlename, String lastname, String idnumber, String scarenumberm, String dob, String gender, String status, String address, String citytown, String state, String mobilenumber, String mobilenumber2, String poc, String otherinfo) throws SQLException, ClassNotFoundException {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.idnumber = idnumber;
        this.scarenumberm = scarenumberm;
        this.dob = dob;
        this.status = status;
        this.gender = gender;
        this.address = address;
        this.citytown = citytown;
        this.state = state;
        this.mobilenumber = mobilenumber;
        this.mobilenumber2 = mobilenumber2;
        this.poc = poc;
        this.otherinfo = otherinfo;
    }

    public void registerPatients(){
        String action = "INSERT INTO PATIENTS VALUES (" +
                "'"+ idnumber +"',"+
                "'"+ firstname +"',"+
                "'"+ middlename +"',"+
                "'"+ lastname +"',"+
                "'"+ scarenumberm +"',"+
                "'"+ dob +"',"+
                "'"+ gender +"',"+
                "'"+ status +"',"+
                "'"+ address +"',"+
                "'"+ citytown +"',"+
                "'"+ state +"',"+
                "'"+ mobilenumber +"',"+
                "'"+ mobilenumber2 +"',"+
                "'"+ poc +"',"+
                "'"+ otherinfo +"'"+
                ")";
        if (execAction(action)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Patient Successfully Registered");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Patient already exists");
            alert.showAndWait();
        }
    }
}
