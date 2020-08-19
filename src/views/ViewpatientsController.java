package views;

import javafx.event.*;
import javafx.scene.input.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewpatientsController implements Initializable {

    @FXML
    private TableColumn id;

    @FXML
    private TableColumn fname;

    @FXML
    private TableColumn mname;

    @FXML
    private TableColumn lname;

    @FXML
    private TableColumn scno;

    @FXML
    private TableColumn dob;

    @FXML
    private TableColumn mstatus;

    @Override
    public void initialize(URL event, ResourceBundle rb) {
    }
}
