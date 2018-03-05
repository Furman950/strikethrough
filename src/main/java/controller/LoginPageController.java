package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.UserData;
import java.io.IOException;

public class LoginPageController {
//    @FXML
//    Button Login,
    @FXML
    private AnchorPane LoginPage, RegisterUser;

    @FXML
    public void register(MouseEvent e) throws IOException {
        RegisterUser = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/RegisterUser.fxml"));
        LoginPage.getChildren().setAll(RegisterUser);
    }
//@FXML
//public void initialize() {
////    Platform.runLater( () -> label.requestFocus() );
//}

}
