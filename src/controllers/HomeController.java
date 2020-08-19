package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    BorderPane rootpane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("/views/createpatients.fxml"));
            rootpane.setCenter(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onCPatClick(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/createpatients.fxml"));
        rootpane.setCenter(pane);
    }

    public void onViewPatients(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/viewpatients.fxml"));
        rootpane.setCenter(pane);
    }
}
