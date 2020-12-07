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

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
    @FXML
    public ScrollPane castDetailsScrollPane;
    @FXML
    public Label castDetails;
    @FXML
    public ImageView imdbLink;

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
        String director = "Chris Columbus";
        String actors = "Richard Harris \t... \tAlbus Dumbledore\n" +
                "Maggie Smith \t... \tProfessor McGonagall\n" +
                "Robbie Coltrane \t... \tHagrid\n" +
                "Saunders Triplets \t... \tBaby Harry Potter\n" +
                "Daniel Radcliffe \t... \tHarry Potter\n" +
                "Fiona Shaw \t... \tAunt Petunia Dursley\n" +
                "Harry Melling \t... \tDudley Dursley\n" +
                "Richard Griffiths \t... \tUncle Vernon Dursley\n" +
                "Derek Deadman \t... \tBartender in Leaky Cauldron\n" +
                "Ian Hart \t... \tProfessor Quirrell\n" +
                "Ben Borowiecki \t... \tDiagon Alley Boy\n" +
                "Warwick Davis \t... \tGoblin Bank Teller / Professor Flitwick / Voice of Griphook\n" +
                "Verne Troyer \t... \tGriphook (as Vern Troyer)\n" +
                "tJohn Hurt \t... \tMr. Ollivander\n" +
                "Richard Bremmer \t... \tHe Who Must Not Be Named\n" +
                "Geraldine Somerville \t... \tLily Potter\n" +
                "Harry Taylor \t... \tStation Guard\n" +
                "Julie Walters \t... \tMrs. Weasley\n" +
                "Bonnie Wright \t... \tGinny Weasley\n" +
                "Chris Rankin \t... \tPercy Weasley\n" +
                "James Phelps \t... \tFred Weasley\n" +
                "Oliver Phelps \t... \tGeorge Weasley\n" +
                "Rupert Grint \t... \tRon Weasley\n" +
                "Jean Southern \t... \tDimpled Woman on Train\n" +
                "Emma Watson \t... \tHermione Granger\n" +
                "Matthew Lewis \t... \tNeville Longbottom\n" +
                "Tom Felton \t... \tDraco Malfoy\n" +
                "Jamie Waylett \t... \tCrabbe\n" +
                "Josh Herdman \t... \tGoyle\n" +
                "Devon Murray \t... \tSeamus Finnigan\n" +
                "Alfred Enoch \t... \tDean Thomas\n" +
                "Leslie Phillips \t... \tThe Sorting Hat (voice)\n" +
                "Eleanor Columbus \t... \tSusan Bones\n" +
                "John Cleese \t... \tNearly Headless Nick\n" +
                "Terence Bayler \t... \tThe Bloody Barron\n" +
                "Simon Fisher-Becker \t... \tFat Friar (as Simon Fisher Becker)\n" +
                "Nina Young \t... \tThe Grey Lady\n" +
                "David Bradley \t... \tMr. Filch\n" +
                "Alan Rickman \t... \tProfessor Snape\n" +
                "Zoë Wanamaker \t... \tMadame Hooch\n" +
                "Luke Youngblood \t... \tLee Jordan\n" +
                "Sean Biggerstaff \t... \tOliver Wood\n" +
                "Elizabeth Spriggs \t... \tFat Lady\n" +
                "Danielle Tabor \t... \tAngelina Johnson (as Danielle Taylor)";
        String cast = director + " \t... \tDirector\n" + actors;
        String imdbID = "tt0241527";
        String imdbURL = "https://www.imdb.com/title/" + imdbID;

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
        plotDetailsScrollpane.setPrefSize(400,200);
        plotDetailsScrollpane.setMaxWidth(Region.USE_PREF_SIZE);
        Label description = new Label(plot);
        description.setWrapText(true);
        description.setMaxWidth(390);
        plotDetailsScrollpane.setContent(description);

        //Cast
        castDetailsScrollPane.setPrefSize(400,200);
        castDetailsScrollPane.setMaxWidth(Region.USE_PREF_SIZE);
        castDetails.setText(cast);
        castDetails.setWrapText(true);
        castDetails.setMaxWidth(390);
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
