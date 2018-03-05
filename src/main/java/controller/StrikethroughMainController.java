package controller;

import model.User;
import model.UserData;

import java.io.*;

public class StrikethroughMainController {
    public static UserData userD = new UserData();
    public static User userLoggedIn;
    private String fileName = "UserData.rac";

    public StrikethroughMainController() throws IOException {
        loadData();
        System.out.println("Loaded data");
        if (userD == null) {
            userD.setUsers(new User("Admin", "Admin", "Admin"));
        }
    }

    public UserData getUserD() {
        return userD;
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
        }
    }

    public void exit()
    {
        System.exit(0);
    }
}
