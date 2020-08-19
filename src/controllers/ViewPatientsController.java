package controllers;

import dbHandler.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.PatientsData;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewPatientsController implements Initializable {
    DatabaseHandler databaseHandler;
    private ObservableList<PatientsData> patientsData;

    @FXML
    private TableColumn<PatientsData, String> id;

    @FXML
    private TableColumn<PatientsData, String> fname;

    @FXML
    private TableColumn<PatientsData, String>  mname;

    @FXML
    private TableColumn<PatientsData, String>  lname;

    @FXML
    private TableColumn<PatientsData, String>  scno;

    @FXML
    private TableColumn<PatientsData, String> dob;

    @FXML
    private TableColumn<PatientsData, String> maritalstatus;

    @FXML
    private TableView<PatientsData> tableview;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            databaseHandler = new DatabaseHandler();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        loadPatientsData();
        tableview.setOnMouseClicked(e -> {
            try {
                Connection connection = databaseHandler.getConnection();
                PatientsData patientsData = (PatientsData)tableview.getSelectionModel().getSelectedItem();
                String query = "select * from Patients where id = ?";
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, patientsData.getID());
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    Stage patientDetails = new Stage();
//                    System.out.println(resultSet.getString("fname"));
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/patientdetails.fxml"));
                    Parent roots = loader.load();
                    PatientDetails viewPatients = loader.getController();
                    viewPatients.loadDetails(
                            resultSet.getString("mobilenumber"),
                            resultSet.getString("gender"),
                            resultSet.getString("dob"),
                            resultSet.getString("lastname") + " " + resultSet.getString("firstname"),
                            resultSet.getString("maritalstatus"),
                            resultSet.getString("city_town"),
                            resultSet.getString("address"),
                            resultSet.getString("id"),
                            resultSet.getString("lastname"));
                    Scene scene = new Scene(roots);
                    patientDetails.setScene(scene);
                    patientDetails.show();
                }
            } catch (SQLException | IOException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

    }

    private void loadPatientsData() {
        try {
            Connection connection = databaseHandler.getConnection();
            this.patientsData = FXCollections.observableArrayList();
            String sql = "SELECT * FROM PATIENTS";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                this.patientsData.add(new PatientsData(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(8),
                        resultSet.getString(7),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15)));

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        this.id.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("ID"));
        this.fname.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("firstname"));
        this.mname.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("mname"));
        this.lname.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("lname"));
        this.scno.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("hcarename"));
        this.dob.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("dob"));
        this.maritalstatus.setCellValueFactory(new PropertyValueFactory<PatientsData, String>("maritalstatus"));
        tableview.setItems(patientsData);
        System.out.println(patientsData.size());
    }

}
