package openoscars;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
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
    @FXML
    public ScrollPane castDetailsScrollPane;
    @FXML
    public Label castDetails;
    @FXML
    public ImageView imdbLink;
    public Label movieDetailsText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Variables
        String poster = User.getCurrentMovie().getPoster();
        String plot = User.getCurrentMovie().getPlot();
        String title = User.getCurrentMovie().getTitle();
        String year = User.getCurrentMovie().getYear();
        String genre = User.getCurrentMovie().getGenre();
        String mpaRating = User.getCurrentMovie().getRated();
        String imdbRating = User.getCurrentMovie().getimdbRating();
        String imdbVotes = User.getCurrentMovie().getimdbVotes();
        String metacritic = User.getCurrentMovie().getMetascore();
        List<String> awards = User.getCurrentMovie().getAwards();
        String oscarWins = null;
        String director = User.getCurrentMovie().getDirector();
        String actors = User.getCurrentMovie().getActors();
        String cast =  "Directed by " +  director + "\n" + actors.replace(",","\n");
        String imdbID = User.getCurrentMovie().getTitle().replace(" ", "+") ;
        String imdbURL = "https://www.imdb.com/find?q=" + imdbID;

        // Poster
        Image image = new Image(poster);
        posterDetails.setImage(image);
        posterDetails.setFitWidth(300);
        posterDetails.setId("posterDetails");

        // Title
        movieTitleDetails.setText(title);
        movieTitleDetails.setId("movieTitleDetails");
        yearGenreDetails.setText(year + " (" + genre + ") " + mpaRating);
        yearGenreDetails.setId("yearGenreDetails");
        imdbRatingAndVotesDetails.setText("IMDb Rating: " + imdbRating + " (" + imdbVotes + ")" );
        imdbRatingAndVotesDetails.setId("imdbRatingAndVotesDetails");
        metaCriticScoreDetails.setText("Metacritic Rating: " + metacritic);
        metaCriticScoreDetails.setId("metaCriticScoreDetails");

        // ScrollPane
        plotDetailsScrollpane.setPrefSize(400,200);
        plotDetailsScrollpane.setMaxWidth(Region.USE_PREF_SIZE);
        plotDetailsScrollpane.setId("plotDetailsScrollPane");
        Label description = new Label(plot);
        description.setWrapText(true);
        description.setMaxWidth(395);
        description.setId("plotDetails");
        plotDetailsScrollpane.setContent(description);

        //Cast
        castDetailsScrollPane.setPrefSize(400,200);
        castDetailsScrollPane.setMaxWidth(Region.USE_PREF_SIZE);
        castDetailsScrollPane.setId("castDetailsScrollPane");
        castDetails.setText(cast);
        castDetails.setTextAlignment(TextAlignment.CENTER);
        castDetails.setId("castDetails");
        castDetails.setWrapText(true);
        castDetails.setMaxWidth(395);
        castDetailsScrollPane.setContent(castDetails);

        imdbLink.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(Desktop.isDesktopSupported())
                {
                    try {
                        Desktop.getDesktop().browse(new URI(imdbURL));
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

    }
}
