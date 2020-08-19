package controllers;

import dbHandler.DatabaseHandler;
import dbHandler.LoginHandler;
import dbHandler.SignUpDBHandler;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private StackPane pnstack;

    @FXML
    private Pane pnsignup;

    @FXML
    private TextField signupemail;

    @FXML
    private Button SignUp;

    @FXML
    private Label forgotPasswordLabel11;

    @FXML
    private FontAwesomeIconView backarrow;

    @FXML
    private TextField signupfullname;

    @FXML
    private TextField signuppassword;

    @FXML
    private TextField signupdepartment;

    @FXML
    private TextField signupstaffid;

    @FXML
    private TextField emailLabel;

    @FXML
    private PasswordField passwordLabel;

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnSignUp;

    @FXML
    private Label forgotPasswordLabel;

    @FXML
    private Label forgotPasswordLabel1;

    SignUpDBHandler signUpDBHandler;

    @Override
    public void initialize(URL event, ResourceBundle rb) {

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if (event.getSource() == btnSignUp) {
            pnsignup.toFront();
        } else if (event.getSource() == SignUp) {
            if (signupfullname.getText().isEmpty() || signupemail.getText().isEmpty() || signuppassword.getText().isEmpty() || signupdepartment.getText().isEmpty() || signupstaffid.getText().isEmpty()) {
                showAndWait(Alert.AlertType.ERROR, "Fields can't be empty");
            } else {
                signUp();
            }
        }else if(event.getSource() == btnSignIn){
            if (emailLabel.getText().toString().isEmpty() || passwordLabel.getText().toString().isEmpty()){
                showAndWait(Alert.AlertType.ERROR, "Fields can't be empty");
            }else{
                signIn();
            }
        }
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        pnsignup.toBack();
    }

    private void signUp() throws SQLException, ClassNotFoundException {
        signUpDBHandler = new SignUpDBHandler(signupfullname.getText().toString(), signupemail.getText().toString(), signuppassword.getText().toString(), signupdepartment.getText().toString(), signupstaffid.getText().toString());
        signUpDBHandler.signUp();
        signupfullname.clear();
        signupemail.clear();
        signuppassword.clear();
        signupdepartment.clear();
        signupstaffid.clear();
    }
    private void signIn() throws SQLException, ClassNotFoundException, IOException {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        LoginHandler loginHandler = new LoginHandler(emailLabel.getText().toString(), passwordLabel.getText().toString());
        if (loginHandler.isLogin()){
            Stage stage = (Stage) btnSignIn.getScene().getWindow();
            stage.close();
            showHomeScreen();
        }else{
            showAndWait(Alert.AlertType.ERROR, "Invalid Credentials");
        }
    }

    private void showHomeScreen() throws IOException {
        Stage homeStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = (Pane)loader.load(getClass().getResource("/views/home.fxml").openStream());
        HomeController controller = loader.getController();

        Scene scene = new Scene(root);
        homeStage.setScene(scene);
        homeStage.show();
    }
    private Alert showAndWait(Alert.AlertType alertType, String alertmessage){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setContentText(alertmessage);
        alert.showAndWait();
        return alert;
    }
}
