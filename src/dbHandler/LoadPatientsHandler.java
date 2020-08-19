package dbHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.PatientsData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadPatientsHandler extends DatabaseHandler{
    private ObservableList<PatientsData> patientsData;
    public LoadPatientsHandler() throws SQLException, ClassNotFoundException {
    }

}
