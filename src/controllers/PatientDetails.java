package controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import dbHandler.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class PatientDetails implements Initializable {
    @FXML
    private Circle patientimage;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton savenotes;

    @FXML
    private JFXTextArea notess;

    @FXML
    private Text mnum1, gender, dob, lnamefname, maritalstatus, registrationdate, city, address, id, email;
    DatabaseHandler databaseHandler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            databaseHandler = new DatabaseHandler();
//            setupNotesTable();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
//        patientimage.setFill(new ImagePattern(new Image("res/placeholder.jpg")));
    }

    public void loadDetails(String mnumm1, String genderr, String dobb, String lnamefn, String mstatus, String citytown, String addresss, String idd, String emaill){
        mnum1.setText(mnumm1);
        gender.setText(genderr);
        dob.setText(dobb);
        lnamefname.setText(lnamefn);
        maritalstatus.setText(mstatus);
        city.setText(citytown);
        address.setText(addresss);
        id.setText(idd);
        email.setText(emaill);
    }


    @FXML
    private void onsavenotes(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String ids = id.getText().toString();
        String note = notess.getText().toString();
        String query = "INSERT INTO notestable VALUES (" +
                "'" + ids + "' ," +
                "'" + note + "'" +
                ") ";

        System.out.println(query);
//        execAction(query);
    }
        public void patientlistclick (MouseEvent mouseEvent) throws IOException {
            System.out.println("Hello");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Patients/patients.fxml"));
            Parent roots = loader.load();

            root.getChildren().setAll(roots);
        }


    //create the notes table
    void setupNotesTable() throws SQLException, ClassNotFoundException {
        String TABLE_NAME = "notestable";
        Statement statement = databaseHandler.getConnection().createStatement();
        DatabaseMetaData databaseMetaData = databaseHandler.getConnection().getMetaData();
        ResultSet tables = databaseMetaData.getTables(null, null, TABLE_NAME, null);

        if (tables.next()){
            System.out.println(TABLE_NAME + " Now Exists");
        }else {
            statement.execute("CREATE TABLE " + TABLE_NAME + " ("
            +" id varchar(200) primary key, \n"
            +" notes varchar" + " )");
        }

    }


//    execute action method
    public boolean execAction(String query) throws SQLException, ClassNotFoundException {
        Statement statement = databaseHandler.getConnection().createStatement();
        statement.execute(query);
        return true;
    }
}
