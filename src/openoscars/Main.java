package openoscars;

//javafx imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // This Starts the main Stage (Window), Loads FXML and give it some starting properties.
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resources/mainWindow.fxml"));
        primaryStage.setTitle("OpenOscars");
        primaryStage.setScene(new Scene(root, 1280, 768));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
