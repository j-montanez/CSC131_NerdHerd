package openoscars;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MovieCardFactoryController implements Initializable {

    @FXML
    public GridPane gridPane;

    @FXML
    public BorderPane winnersPane;

    @FXML
    public BorderPane nominatePane;

    @FXML
    public BorderPane votePane;

    @FXML
    public BorderPane searchPane;

    @FXML
    public Button nextButton;

    // global
    public static int index = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MovieArray mv = new MovieArray(1957);
        List<MovieNS> movies = mv.getMovies();
        List<String> tit = mv.getYup();
        for (int j=0;j<2;j++) {             // rows
            for (int i=0;i<3;i++) {         // columns
                createCard(j,i,movies.get(index).getTitle(),"category",movies.get(index).getPoster(),movies.get(index).getPlot());
                index++;
//                System.out.println(index + " " + movies.get(index).getTitle() + " " + movies.get(index).getPoster() + " " + movies.get(index).getPlot());

            }


        }

    }


        public void createCard(int row, int column, String titleIn, String categoryIn, String posterIn, String plotIn) {

        // Variables

        // Card Creation
        HBox card = new HBox();
        card.setMaxWidth(Region.USE_COMPUTED_SIZE);
        gridPane.add(card, column, row);

        // Poster
        Image poster = new Image(posterIn);
        if(poster.isError()) {
            File noImg = new File("/src/openoscars/resources/imgs/noimage.png");
            String absolute = System.getProperty("user.dir") + noImg ;
            poster = new Image("file:" + absolute); // Find out why this doesn't display
//            System.out.println(poster);
        }
        ImageView iv = new ImageView();
        iv.setImage(poster);
        iv.setPreserveRatio(false);
        iv.setFitHeight(197.0);
        iv.setFitWidth(125.0);
        iv.setCache(true);

        // Details side of card
        VBox details = new VBox();
        Label title = new Label(titleIn);
        Label category = new Label(categoryIn);
        ScrollPane detailsPane = new ScrollPane();
        detailsPane.setPrefSize(250,130);
        Label description = new Label(plotIn);
        description.setWrapText(true);
        description.setMaxWidth(230);
        detailsPane.setContent(description);
//        Button button = new Button("Click");
//        button.setMaxWidth(Double.MAX_VALUE);

        // add to details
        details.getChildren().add(title);
        details.getChildren().add(category);
        details.getChildren().add(detailsPane);
//        details.getChildren().add(button);

        // add to card
        card.getChildren().add(iv);
        card.getChildren().add(details);
        card.setAlignment(Pos.CENTER);

        iv.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Pane view = null;
                try {
                    view = FXMLLoader.load(getClass().getResource("resources/detail.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    if(winnersPane != null) {
                        winnersPane.setCenter(view);
                        winnersPane.setTop(null);
                        winnersPane.setLeft(null);
                        winnersPane.setRight(null);
                    } else if(nominatePane != null) {
                        nominatePane.setCenter(view);
                        nominatePane.setTop(null);
                        nominatePane.setLeft(null);
                        nominatePane.setRight(null);
                    } else if(votePane != null) {
                        votePane.setCenter(view);
                        votePane.setTop(null);
                        votePane.setLeft(null);
                        votePane.setRight(null);
                    } else if(searchPane != null) {
                        searchPane.setCenter(view);
                        searchPane.setTop(null);
                        searchPane.setLeft(null);
                        searchPane.setRight(null);
                    }


            }
        });
        }

    @FXML
    public void nextPage(MouseEvent mouseEvent) {
        //Next: figure out why mouse event doesn't trigger
        System.out.println("in next button");
        // clear out the old cards
        gridPane.getChildren().removeAll();
    }

    @FXML
    public void prevPage(MouseEvent mouseEvent) {
        //Next: figure out why mouse event doesn't trigger
        System.out.println("in prev button");
        // clear out the old cards
        gridPane.getChildren().removeAll();
    }
}
