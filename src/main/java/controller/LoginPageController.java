package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class LoginPageController {
    StrikethroughMainController strikethrough = new StrikethroughMainController();
    @FXML
    private AnchorPane LoginPage;

    @FXML
    private AnchorPane RegisterUser, NewerLoginPage;

    /**
     *
     * @throws IOException
     */
    public LoginPageController() throws IOException {
        strikethrough.loadData();
    }

    @FXML
    public void register(MouseEvent e) throws IOException {
        RegisterUser = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/RegisterUser.fxml"));
        LoginPage.getChildren().setAll(RegisterUser);
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void login(MouseEvent mouseEvent) throws IOException {
        NewerLoginPage = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/NewerLoginPage.fxml"));
        LoginPage.getChildren().setAll(NewerLoginPage);
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void exit(MouseEvent mouseEvent) throws IOException {
        strikethrough.exit();
    }
}
