package edu.neumont.strikethrough;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StrikeThroughApplication extends Application
{

	public static void main(String[] args) 
	{
		Application.launch(StrikeThroughApplication.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/window.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("/fxml/stylesheet.css").toExternalForm().toString());
        stage.setTitle("Awesomeness of awesome");
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();
	}

}
