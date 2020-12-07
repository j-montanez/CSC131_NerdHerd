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
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        primaryStage.setTitle("OpenOscars");
        primaryStage.setScene(new Scene(root, 426, 300));
        primaryStage.show();
        MovieObj movie = new MovieObj("Harry%20Potter%20and%20the%20Sorcerer's%20Stone");
////        MovieObj movie = new MovieObj("Harry Potter and the Sorcerer's Stone");
        System.out.println(movie.getPoster());
//        System.out.println(movie.getAwards());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
