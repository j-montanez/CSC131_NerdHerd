package openoscars;

//javafx imports

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    public void movieYear(int year){
        // Test for MovieArray
        MovieArray mv = new MovieArray(year);
        List<MovieNS> movies = mv.getMovies();
        System.out.println("movies: " + movies);
        for(int i = 0; i<movies.size();i++) {
            System.out.println("Index: " + i + " Title:" + movies.get(i).getTitle() + " " + year);
        }

    }
    // This Starts the main Stage (Window), Loads FXML and give it some starting properties.
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resources/login.fxml"));
        User.setTheme("resources/styles.css");
        root.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        primaryStage.setTitle("OpenOscars");
        Scene scene = new Scene(root, 426, 300);
        scene.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();


//        movieYear(2019);
//        movieYear(2018);







///////         Test for MovieArraySearch
//        MovieArraySearch mv = new MovieArraySearch("horror");
////        System.out.println(mv);
//        List<MovieNS> movies = mv.getMovies();
////        System.out.println(movies);
//        List<String> tit = mv.getYup();
////        System.out.println(tit);
//        for(int i = 0; i<6;i++) {
//            System.out.println(i + " " + movies.get(i).getTitle());
//        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
