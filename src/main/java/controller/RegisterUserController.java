package controller;

import exceptions.UserAlreadyExistsException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.*;

import java.io.*;

public class RegisterUserController {
    private StrikethroughMainController strikethrough = new StrikethroughMainController();
    private UserData userD = strikethrough.getUserD();
    private User userLoggedIn;

    @FXML
    private TextField uName, pWord, fName, weight, goalWeight, birthday;

    @FXML
    private Label label;

    @FXML
    public void initialize() {
        Platform.runLater( () -> label.requestFocus() );
    }

    public RegisterUserController() throws IOException {}

    private String username, password, firstName, uWeight, uGoalWeight, uBirthday;


    /**
     * Creates a new user profile
     */

    public void register(MouseEvent e) {
        System.out.println("In register method");
        username = uName.getText();
        password = pWord.getText();
        firstName = fName.getText();
        uWeight = weight.getText();
        uGoalWeight = goalWeight.getText();
        uBirthday = birthday.getText();

        for (User u : this.userD.getUsers()) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                throw new UserAlreadyExistsException("Username already exists.");
            }
        }

        User user = new User(username, password, firstName);
        userD.setUsers(user);
        login();
        System.out.println("Successfully created a new user");
    }

    /**
     * logs in an existing profile
     */
    public void login() {
        username = uName.getText();
        password = pWord.getText();

        for (User u : this.userD.getUsers()) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                if (u.getPassword().equals(password)) {
                    strikethrough.setUserLoggedIn(u);
                }
            }
        }
    }

    public void printUserData(MouseEvent mouseEvent) {
        if (userD != null) {
            System.out.println(userD.toString());
        }
    }
}
