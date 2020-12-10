package openoscars;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    public static String yearGlobal = "2018";
    public static List<MovieNS> movies = null;
    public GridPane gridPane;
    public Button prevArrowWinners;
    public Button nextArrowWinners;
    public Button prevArrowNominate;
    public Button nextArrowNominate;
    public Button prevArrowVote;
    public Button nextArrowVote;
    public Button prevArrowSearch;
    public Button nextArrowSearch;
    public Label nominateText;
    public Label voteTextLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(!(winnersPane == null)){
            addComboBox();
            getMovieByYear(Integer.parseInt(yearGlobal));
            cardGrid(createGrid());
        }
        if(!(nominatePane == null)){
            getMovieByYear(2019);
            cardGrid(createGrid());
        }
        if(!(votePane == null)){
            getMovieByYear(2019);
            cardGrid(createGrid());
        }
        if(!(searchPane == null)){
           getMovieBySearch(User.getSearch());
           cardGrid(createGrid());

        }
    }

    public void getMovieBySearch(String search){
        if(movies!=null){
            movies.clear();
        }
        MovieArraySearch mv = new MovieArraySearch(search);
        movies = mv.getMovies();
    }

    public void getMovieByYear(int year){
        if(movies!=null){
            movies.clear();
        }
        MovieArray mv = new MovieArray(year);
        movies = mv.getMovies();
    }

    public void addComboBox(){
        final ComboBox<String> yearComboBox = new ComboBox<>();
        for(int i = 2018; i>=1927; i--){
            yearComboBox.getItems().add(Integer.toString(i));
        }
        yearComboBox.setEditable(false);
        yearComboBox.setValue(Integer.toString(2018));
        VBox yearComboBoxHolder = new VBox();
        Label winnerText = new Label("Past Winners");
        winnerText.setId("winnerTextLabel");
        HBox container = new HBox();
        Label selectYear = new Label("Select Year");
        selectYear.setId("selectYearLabel");
        container.getChildren().add(selectYear);
        container.getChildren().add(yearComboBox);
        container.setAlignment(Pos.CENTER);
        container.setSpacing(10);

        yearComboBoxHolder.setAlignment(Pos.CENTER);
        yearComboBoxHolder.getChildren().add(winnerText);
        yearComboBoxHolder.getChildren().add(container);
        if(winnersPane != null) {
            winnersPane.setTop(yearComboBoxHolder);
        } else if(nominatePane != null) {
            nominatePane.setTop(yearComboBoxHolder);
        } else if(votePane != null) {
            votePane.setTop(yearComboBoxHolder);
        } else if(searchPane != null) {
            searchPane.setTop(yearComboBoxHolder);
        }
        yearComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                yearGlobal = t1;
                movies.clear();
                getMovieByYear(Integer.parseInt(yearGlobal));

                //clear old
                index = 0;
                cardGrid(createGrid());
            }
        });


    }

    public void cardGrid(GridPane gridPane){
        for (int j=0;j<2;j++) {             // rows
            for (int i=0;i<3;i++) {         // columns
                if(movies != null && index < movies.size()){

                    if(winnersPane != null){
                        while(movies.get(index).getAwards().isEmpty() && index < movies.size()) {
                            index++;
                        }
                        if(!(movies.get(index).getAwards()==null) && index < movies.size())
                            createCard(j,i,movies.get(index).getTitle(), movies.get(index).getPoster(),movies.get(index).getPlot(),movies.get(index).getYear(), movies.get(index).getAwards(), gridPane);
                            index++;
                    } else if(nominatePane != null ){
                        createCard(j,i,movies.get(index).getTitle(), movies.get(index).getPoster(),movies.get(index).getPlot(),movies.get(index).getYear(), movies.get(index).getAwards(), gridPane);
                        index++;
                    } else if(votePane != null){
                        while(movies.get(index).getAwards().isEmpty() && index < movies.size()) {
                            index++;
                        }
                        if(!(movies.get(index).getAwards()==null) && index < movies.size())
                            createCard(j,i,movies.get(index).getTitle(), movies.get(index).getPoster(),movies.get(index).getPlot(),movies.get(index).getYear(), movies.get(index).getAwards(), gridPane);
                        index++;
                    } else if(searchPane != null){
                        createCard(j,i,movies.get(index).getTitle(), movies.get(index).getPoster(),movies.get(index).getPlot(),movies.get(index).getYear(), movies.get(index).getAwards(), gridPane);
                        index++;
                    }
                }

            }



        }
    }

        public GridPane createGrid(){

            GridPane gridPane = new GridPane();
            ColumnConstraints col1 = new ColumnConstraints();
            col1.setPercentWidth(33.3);
            ColumnConstraints col2 = new ColumnConstraints();
            col2.setPercentWidth(33.3);
            ColumnConstraints col3 = new ColumnConstraints();
            col3.setPercentWidth(33.3);
            gridPane.getColumnConstraints().addAll(col1,col2,col3);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setHgap(50);
            gridPane.setVgap(35);

            if(winnersPane != null) {
                winnersPane.setCenter(gridPane);
            } else if(nominatePane != null) {
                nominatePane.setCenter(gridPane);
            } else if(votePane != null) {
                votePane.setCenter(gridPane);
            } else if(searchPane != null) {
                searchPane.setCenter(gridPane);
            }

            return gridPane;
        }

        public void createCard(int row, int column, String titleIn, String posterIn, String plotIn, String yearIn, List awards, GridPane gridPane) {

        // Card Creation
        HBox card = new HBox();
        card.setId("mainCard");
        card.setMaxWidth(Region.USE_COMPUTED_SIZE);
        card.setSpacing(20);
        gridPane.add(card, column, row);
            final Image[] poster = new Image[1];

        // Poster
        if(!posterIn.contains("http")){
            File noImg = new File("/src/openoscars/resources/imgs/noimage.png");
            String absolute = System.getProperty("user.dir") + noImg ;
            poster[0] = new Image("file:" + absolute);
        } else {
            poster[0] = new Image(posterIn);
        }
        if(poster[0].isError()){
            File noImg = new File("/src/openoscars/resources/imgs/noimage.png");
            String absolute = System.getProperty("user.dir") + noImg ;
            poster[0] = new Image("file:" + absolute);
        }

        ImageView iv = new ImageView();
        iv.setId("smallPoster");
        iv.setImage(poster[0]);
        iv.setPreserveRatio(false);
        iv.setFitHeight(197.0);
        iv.setFitWidth(125.0);
        iv.setCache(true);


        // Details side of card
        VBox details = new VBox();
        details.setAlignment(Pos.CENTER);
        details.setId("detailsVBox");
        Label title = new Label(titleIn);
        title.setId("titleCard");
        String awardsString = "";
        if(!awards.isEmpty() && winnersPane != null){
            for(int i = 0 ; i<awards.size() ; i++)
            awardsString += awards.get(i) + "\n";
        }
        Label category = new Label(awardsString);
        category.setId("categoryCard");
        ScrollPane detailsPane = new ScrollPane();
        detailsPane.setId("scrollPaneCard");
        detailsPane.setPrefSize(250,130);
        Label description = new Label(plotIn);
        description.setWrapText(true);
        description.setMaxWidth(230);
        detailsPane.setContent(description);
        // add to details
        details.getChildren().add(title);
        details.getChildren().add(category);
        details.getChildren().add(detailsPane);
        if(nominatePane != null){
            Button nominateButton = new Button("Nominate");
            nominateButton.setMaxWidth(Double.MAX_VALUE);
            nominateButton.setId("nominateButtonCard");
            nominateButton.setOnAction(event -> {
                nominateButton.setStyle("-fx-background-color:#B09951;-fx-text-fill: #220404;");
                User.setNominatedMovie(titleIn);
                    });
            details.getChildren().add(nominateButton);
        } else if(votePane != null){
            Button voteButton = new Button("Vote");
            voteButton.setMaxWidth(Double.MAX_VALUE);
            voteButton.setId("votingButtonCard");
            voteButton.setOnAction(event -> {
                voteButton.setStyle("-fx-background-color:#B09951;-fx-text-fill: #220404;");
                User.setVotedMovie(titleIn);
            });
            details.getChildren().add(voteButton);
        }


        // add to card
        card.getChildren().add(iv);
        card.getChildren().add(details);
        card.setAlignment(Pos.CENTER);



//      Click on the Card's poster
        iv.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // find movie object. Send to user
                File noImg = new File("/src/openoscars/resources/imgs/noimage.png");
                String absolute = System.getProperty("user.dir") + noImg ;
                poster[0] = new Image("file:" + absolute);
                for(int i = index; i > 0; i--){
                    if (movies.get(index-i).getPoster().equals( iv.getImage().getUrl())){
                        User.setCurrentMovie(movies.get(index-i));
                    } else if (movies.get(index-i).getPoster().equals(poster[0].getUrl())){
                        User.setCurrentMovie(movies.get(index-i));
                    } else {
                        System.out.println("Not found");
                    }
                }

                // display the detail page
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
        if(index<movies.size()-5){
            GridPane gridPane = createGrid();
            if(winnersPane != null) {
                winnersPane.setCenter(gridPane);
            } else if(nominatePane != null) {
                nominatePane.setCenter(gridPane);
            } else if(votePane != null) {
                votePane.setCenter(gridPane);
            } else if(searchPane != null) {
                searchPane.setCenter(gridPane);
            }
            cardGrid(gridPane);
        }

    }

    @FXML
    public void prevPage(MouseEvent mouseEvent) {
        if(index>=12){
            index-=12;

            GridPane gridPane = createGrid();
            if(winnersPane != null) {
                winnersPane.setCenter(gridPane);
            } else if(nominatePane != null) {
                nominatePane.setCenter(gridPane);
            } else if(votePane != null) {
                votePane.setCenter(gridPane);
            } else if(searchPane != null) {
                searchPane.setCenter(gridPane);
            }

            cardGrid(gridPane);
        }

    }
}
