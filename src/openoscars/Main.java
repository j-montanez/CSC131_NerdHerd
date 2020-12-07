package openoscars;

//javafx imports

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    // This Starts the main Stage (Window), Loads FXML and give it some starting properties.
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resources/login.fxml"));
        root.getStylesheets().add(getClass().getResource("resources/styles.css").toExternalForm());
        // Relative path to directory isn't participating. Linking to the github isn't great... too bad!
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        primaryStage.setTitle("OpenOscars");
        Scene scene = new Scene(root, 426, 300);
        //scene.getStylesheets().add(getClass().getResource("resources/styles.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
