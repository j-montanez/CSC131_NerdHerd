package openoscars;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DetailController implements Initializable {

    @FXML
    public ImageView posterDetails;
    @FXML
    public VBox vBoxPoster;
    @FXML
    public Label movieTitleDetails;
    @FXML
    public Label yearGenreDetails;
    @FXML
    public ScrollPane plotDetailsScrollpane;
    @FXML
    public Label imdbRatingAndVotesDetails;
    @FXML
    public Label metaCriticScoreDetails;
    @FXML
    public BorderPane detailPane;
    @FXML
    public GridPane gridPane;
    @FXML
    public Label awardsWonDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Variables
        String poster = "https://m.media-amazon.com/images/M/MV5BNjQ3NWNlNmQtMTE5ZS00MDdmLTlkZjUtZTBlM2UxMGFiMTU3XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_SX300.jpg";
        String plot = "A young boy called harry potter finds out that he is a wizard and has fun and wacky adventures.";
        String title = "Harry Potter and the Sorcerer's Stone";
        String year = "2001";
        String genre = "Fantasy";
        String mpaRating = "PG";
        String imdbRating = "7.6";
        String imdbVotes = "645,159";
        String metacritic = "64%";
        String awards = null;
        String oscarWins = null;

        // Poster
        Image image = new Image(poster);
        posterDetails.setImage(image);
        posterDetails.setFitWidth(300);

        // Title
        movieTitleDetails.setText(title);
        yearGenreDetails.setText(year + " (" + genre + ") " + mpaRating);
        imdbRatingAndVotesDetails.setText("IMDb Rating: " + imdbRating + " (" + imdbVotes + ")" );
        metaCriticScoreDetails.setText("Metacritic Rating: " + metacritic);
        oscarWins = Objects.requireNonNullElse(awards, "none");
        awardsWonDetails.setText("Awards won: " + oscarWins );

        // ScrollPane
//        plotDetailsScrollpane.setPrefSize(250,130);
        Label description = new Label(plot);
        description.setWrapText(true);
        description.setMaxWidth(350);
        plotDetailsScrollpane.setContent(description);

        //

//        try {
//            System.out.println("posterIVDetails" + posterIVDetails);
//        } catch (NullPointerException e) {
//            System.out.println("NULLPOINTEREXCEPTION!!!");
//        }
//        try {
//            System.out.println("posterIVDetails.getScene()" + posterIVDetails.getScene());
//        } catch (NullPointerException e) {
//            System.out.println("NULLPOINTEREXCEPTION!!!");
//        }


    }
}
