package controller;

import exceptions.InvalidBirthdayException;
import exceptions.UserAlreadyExistsException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.io.*;

public class RegisterUserController {
    private StrikethroughMainController strikethrough = new StrikethroughMainController();

    @FXML
    private TextField uName, fName, weight, goalWeight, birthday;

    @FXML
    private PasswordField pWord;

    @FXML
    private AnchorPane RegisterUser, MainMenu, loginPage;

    @FXML
    private Label label;

    @FXML
    public void initialize() {
        Platform.runLater( () -> label.requestFocus() );
    }

    public RegisterUserController() throws IOException {}

    private String username, password, firstName;
    private int uWeight, uGoalWeight;
    Birthday uBirthday;
    Alert alert = new Alert(Alert.AlertType.WARNING);


    /**
     * Creates a new user profile
     */

    public void register(MouseEvent e) throws IOException {
        alert.setTitle("Invalid Input");
        try {
            System.out.println("In register method");
            username = uName.getText();
            password = pWord.getText();
            firstName = fName.getText();
            uWeight = Integer.parseInt(weight.getText());
            uGoalWeight = Integer.parseInt(goalWeight.getText());
            uBirthday = new Birthday(birthday.getText());

            for (User u : strikethrough.getUserD().getUsers()) {
                if (u.getUsername().equalsIgnoreCase(username)) {
                    throw new UserAlreadyExistsException("Username already exists.");
                }
            }

            User user = new User(username, password, firstName, uWeight, uGoalWeight, uBirthday);
            strikethrough.getUserD().setUsers(user);
            strikethrough.saveData();
            login();
            System.out.println("Successfully created a new user");
        }

        catch(NumberFormatException numberException) {
            alert.setContentText("Invalid weight or goal weight! Enter numbers only!!");
            alert.show();
        }
        catch(InvalidBirthdayException e1) {
            alert.setContentText("Invalid birthday format!! Enter correct format! mm/dd/yyyy");
            alert.show();
        }

        catch(UserAlreadyExistsException e2) {
            alert.setContentText("Username already exists!! Try again!");
            uName.setText("");
            alert.show();
        }

    }

    /**
     * logs in an existing profile
     */
    public void login() throws IOException {
        username = uName.getText();
        password = pWord.getText();

        for (User u : strikethrough.getUserD().getUsers()) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                if (u.getPassword().equals(password)) {
                    strikethrough.setUserLoggedIn(u);
                    MainMenu = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MainMenu.fxml"));
                    RegisterUser.getChildren().setAll(MainMenu);

                }
            }
        }
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        loginPage = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/LoginPage.fxml"));
        RegisterUser.getChildren().setAll(loginPage);

    }
}
