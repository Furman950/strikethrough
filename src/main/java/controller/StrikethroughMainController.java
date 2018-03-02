package controller;

import javafx.scene.input.MouseEvent;
import model.User;
import model.UserData;

import java.io.*;

public class StrikethroughMainController {
    public static UserData userD = new UserData();
    public static User userLoggedIn;
    private String fileName = "UserData.rac";

    public UserData getUserD() {
        return userD;
    }

    /**
     * Loads all the users and their data
     *
     * @throws IOException
     */
    public void loadData() throws IOException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            try {
                this.userD = (UserData) in.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Saves all users and their data
     *
     * @throws IOException
     */
    public void saveData() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this.userD);
        }
    }

    public void exit()
    {
        System.exit(0);
    }
}
