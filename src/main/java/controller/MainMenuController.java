package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainMenuController {
    StrikethroughMainController strikethrough = new StrikethroughMainController();

    @FXML
    private Button Logout;

    @FXML
    AnchorPane MainMenu, LoginPage;

    public MainMenuController() throws IOException {
        System.out.println(strikethrough.getUserLoggedIn().toString());
    }



    public void logout(MouseEvent mouseEvent) throws IOException {
        strikethrough.setUserLoggedIn(null);
        LoginPage = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/LoginPage.fxml"));
        MainMenu.getChildren().setAll(LoginPage);
        System.out.println("-----------------------------" + strikethrough.getUserLoggedIn());

    }
}
