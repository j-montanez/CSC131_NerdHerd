package openoscars;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resources/login.fxml"));
        User.setTheme("resources/styles.css");
        root.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("iconSmall.png")));
        primaryStage.setTitle("OpenOscars");
        Scene scene = new Scene(root, 426, 300);
        scene.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
