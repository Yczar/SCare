package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dbHandler.RegisterPatientsHandler;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreatePatientsController implements Initializable {

    @FXML
    private JFXTextField fname;

    @FXML
    private JFXTextField mname;

    @FXML
    private JFXTextField lname;

    @FXML
    private JFXTextField idnum;

    @FXML
    private JFXTextField scnum;

    @FXML
    private DatePicker dob;

    @FXML
    private JFXTextField gender;

    @FXML
    private JFXTextField mstatus;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField citytown;

    @FXML
    private JFXTextField state;

    @FXML
    private JFXTextField mobilenumber2;

    @FXML
    private JFXTextField mobilenumber;

    @FXML
    private JFXTextField poc;

    @FXML
    private JFXTextField otherinfo;

    @FXML
    private JFXButton clear;

    @FXML
    private JFXButton save;

    @Override
    public void initialize(URL event, ResourceBundle rb) {
    }

    @FXML
    private void onAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (event.getSource() == clear){
            clearAll();
        }else if (event.getSource() == save){
            registerPatients();
        }
    }

    private void registerPatients() throws SQLException, ClassNotFoundException {
        RegisterPatientsHandler registerPatientsHandler = new RegisterPatientsHandler(fname.getText(), mname.getText(), lname.getText(), idnum.getText(), scnum.getText(), dob.getEditor().getText().toString(), gender.getText(), mstatus.getText(), address.getText(), citytown.getText(), state.getText(), mobilenumber.getText(), mobilenumber2.getText(), poc.getText(), otherinfo.getText());
        registerPatientsHandler.registerPatients();
        clearAll();

    }


    private void clearAll(){
        fname.clear();
        lname.clear();
        mname.clear();
        idnum.clear();
        scnum.clear();
        dob.getEditor().clear();
        gender.clear();
        mstatus.clear();
        address.clear();
        citytown.clear();
        state.clear();
        mobilenumber.clear();
        mobilenumber2.clear();
        poc.clear();
        otherinfo.clear();
    }
}
