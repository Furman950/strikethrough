package controller;

import model.User;
import model.UserData;

import java.io.*;

public class StrikethroughMainController {
    public static UserData userD = new UserData();
    public static User userLoggedIn = new User();
    private String fileName = "UserData.rac";

    public StrikethroughMainController() throws IOException {}

    public UserData getUserD() {
        return userD;
    }

    public void setUserD(UserData userD) {
        this.userD = userD;
    }

    public User getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(User userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
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
                System.out.println("Loaded data");
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException f) {}
    }

    /**
     * Saves all users and their data
     *
     * @throws IOException
     */
    public void saveData() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this.userD);
            System.out.println("Saved data");
        }
    }

    public void exit() throws IOException {
        saveData();
        System.exit(0);
    }
}
