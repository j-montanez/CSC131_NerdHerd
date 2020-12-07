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

import java.io.IOException;
import java.net.URL;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int j=0;j<2;j++) {             // rows
            for (int i=0;i<3;i++) {         // columns
                createCard(j,i);
            }

        }

    }


        public void createCard(int row, int column) {

//      Variables
        String posterLink = new String();
        String titleText = new String("Movie Title");
        String categoryText = new String("Category");
        String descriptionText = new String("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi hendrerit dolor in est congue, a placerat eros congue." +
                "Vestibulum cursus hendrerit aliquet. Sed accumsan magna sed lectus mattis ornare non in ipsum. Donec sodales nisl justo, at dapibus quam aliquam vi" +
                "Donec sollicitudin in nisi fringilla suscipit. Duis eu enim interdum, varius nunc eu, ultrices turpis. Nullam turpis mi, ornare nec semper et, scel" +
                "eget ligula. Nullam non ex consectetur, malesuada metus vel, fringilla orci. Quisque est enim, molestie quis congue ac, vestibulum b.&#10;&#10;Duis" +
                " elementum nisi lorem, sed ullamcorper dolor dignissim quis. Pellentesque lobortis est ut hendrerit placerat. Etiam porttitor tellus vel pharetra  " +
                "Mauris sodales odio suscipit ornare ullamcorper. Mauris porta nisi augue, eu sagittis sapien finibus et. Nulla blandit, mi vel congue lacinia, tur " +
                "congue purus, vehicula vehicula dolor ligula a odio. Sed auctor eu felis sit amet laoreet. Vivamus scelerisque enim tellus, vel egestas leo digniss" +
                " vitae urna vitae felis porta pulvinar. Duis vestibulum neque turpis, eget rhoncus magna vestibulum eu. Curabitur sed nunc id nulla faucibus ullamc" +
                " gravida ornare lacus, in rutrum nisi tempus in. Morbi non nibh eu augue volutpat consectetur eu sed ipsum.&#10;&#10;Donec laoreet arcu ut vehiculs" +
                " tristique a tortor ac dapibus. Cras metus neque, semper consequat ex quis, pretium luctus tellus. Sed pretium a sem id sollicitudin. Suspendisse a" +
                " lobortis. Fusce pretium posuere bibendum. Morbi pharetra ante porttitor dignissim imperdiet. Duis nec magna enim. Nulla varius arcu id pellentesqu" +
                " rutrum ultricies pellentesque. Vestibulum venenatis mauris non pharetra efficitur. Nullam tempus eros viverra accumsan auctor. Morbi mollis, massa" +
                " pellentesque, magna nunc bibendum sem, vel fringilla lectus elit quis turpis.&#10;&#10;Integer bibendum lorem et libero tempor, a molestie ipsum." +
                " Integer placerat eros sit amet arcu cursus");


        // Card Creation
        HBox card = new HBox();
        card.setMaxWidth(Region.USE_COMPUTED_SIZE);
        gridPane.add(card, column, row);

        // Poster
        Image poster = new Image("https://maxcdn.icons8.com/app/uploads/2019/05/poster-for-movie.png");
        ImageView iv = new ImageView();
        iv.setImage(poster);
        iv.setPreserveRatio(false);
        iv.setFitHeight(197.0);
        iv.setFitWidth(125.0);
        iv.setCache(true);

        // Details side of card
        VBox details = new VBox();
        Label title = new Label(titleText);
        Label category = new Label(categoryText);
        ScrollPane detailsPane = new ScrollPane();
        detailsPane.setPrefSize(250,130);
        Label description = new Label(descriptionText);
        description.setWrapText(true);
        description.setMaxWidth(230);
        detailsPane.setContent(description);
        Button button = new Button("Click");
        button.setMaxWidth(Double.MAX_VALUE);

        // add to details
        details.getChildren().add(title);
        details.getChildren().add(category);
        details.getChildren().add(detailsPane);
        details.getChildren().add(button);

        // add to card
        card.getChildren().add(iv);
        card.getChildren().add(details);
        card.setAlignment(Pos.CENTER);

        iv.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Clicked");
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
}
