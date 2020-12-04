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
        primaryStage.getIcons().add(new Image("resources/imgs/next.png"));
        primaryStage.setTitle("OpenOscars");
        primaryStage.setScene(new Scene(root, 426, 300));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
