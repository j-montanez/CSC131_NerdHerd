package openoscars;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class movieCardFactoryController implements Initializable {

    @FXML
    public GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int j=0;j<2;j++) {             // rows
            for (int i=0;i<3;i++) {         // columns
                createCard(j, i);
            }
        }

    }


        public void createCard(int row, int column) {
        // Card Creation
        HBox card = new HBox();
        card.setMaxWidth(Region.USE_COMPUTED_SIZE);
        gridPane.add(card, column, row);
        card.setAlignment(Pos.CENTER);

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
        Label title = new Label("Movie Title");
        Label category = new Label("Category");
        ScrollPane detailsPane = new ScrollPane();
        detailsPane.setPrefSize(250,130);
        Label description = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi hendrerit dolor in est congue, a placerat eros congue." +
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
    }
}
