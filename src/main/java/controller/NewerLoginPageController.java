package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.User;

import java.io.IOException;

public class NewerLoginPageController {
    StrikethroughMainController strikethrough = new StrikethroughMainController();

    @FXML
    private TextField username;

    @FXML
    private PasswordField Password;

    @FXML
    private AnchorPane NewerLoginPage, MainMenu, loginPage;

    @FXML
    private Label NewerLogin;


    @FXML
    public void initialize() {
        Platform.runLater( () -> NewerLogin.requestFocus() );
    }


    public NewerLoginPageController() throws IOException {
    }


    public void loginUser(MouseEvent mouseEvent) throws IOException {
        for (User u : strikethrough.getUserD().getUsers()) {
            if (username.getText().equals(u.getUsername())) {
                System.out.println("Inside user name check");
                if (Password.getText().equals(u.getPassword())) {
                    System.out.println("Inside user password check");
                    strikethrough.setUserLoggedIn(u);
                    MainMenu = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MainMenu.fxml"));
                    NewerLoginPage.getChildren().setAll(MainMenu);
                    return;
                }
            }
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("User not found!");
        alert.setContentText("Invalid username or password");
        alert.show();
    }

    public void exit(MouseEvent mouseEvent) throws IOException {
        strikethrough.exit();
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        loginPage = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/LoginPage.fxml"));
        NewerLoginPage.getChildren().setAll(loginPage);
    }
}
