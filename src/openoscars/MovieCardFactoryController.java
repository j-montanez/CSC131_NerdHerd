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
            System.out.println("index+=6 " + index + " : " + movies.size());
        }
        if(!(nominatePane == null)){
            getMovieByYear(2019);
            cardGrid(createGrid());
            System.out.println("index+=6 " + index + " : " + movies.size());
        }
        if(!(votePane == null)){
            getMovieByYear(2019);
            cardGrid(createGrid());
            System.out.println("index+=6 " + index + " : " + movies.size());
        }
        if(!(searchPane == null)){
           System.out.println("User.getSearch() " + User.getSearch());
           getMovieBySearch(User.getSearch());
           System.out.println(movies.get(index).getTitle());
           cardGrid(createGrid());
           System.out.println("index+=6 " + index + " : " + movies.size());

        }
    }

    public void getMovieBySearch(String search){
        MovieArraySearch mv = new MovieArraySearch(search);
        movies = mv.getMovies();
//        for(int i = 0; i<6;i++) {
//            System.out.println(i + " " + movies.get(i).getTitle());
//        }
    }

    public void getMovieByYear(int year){
        MovieArray mv = new MovieArray(year);
        movies = mv.getMovies();
        System.out.println("Elements in movies: " + movies.size());

    }

    public void addComboBox(){
        final ComboBox<String> yearComboBox = new ComboBox<>();
        for(int i = 2020; i>=1927; i--){
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
                System.out.println(yearGlobal);
                getMovieByYear(Integer.parseInt(yearGlobal));

//            //     Test for MovieArray
//        for(int i = 0; i<movies.size();i++) {
//            System.out.println("Index: " + i + " Title:" + movies.get(i).getTitle());
//        }
                //clear old
                index = 0;
                cardGrid(createGrid());
                System.out.println("index+=6 " + index + " : " + movies.size());
            }
        });


    }

    public void cardGrid(GridPane gridPane){
        for (int j=0;j<2;j++) {             // rows
            for (int i=0;i<3;i++) {         // columns
                if(movies.get(index) != null){
//                        System.out.println(movies.get(index));
                        System.out.println(movies.get(index).getTitle() + "movies.get(index) != null");
                    createCard(j,i,movies.get(index).getTitle(),"category",movies.get(index).getPoster(),movies.get(index).getPlot(), gridPane);
                    index++;
//                    System.out.println("CardGrid Current index: " + index);
                }
//                System.out.println(index + " " + movies.get(index).getTitle() + " " + movies.get(index).getPoster() + " " + movies.get(index).getPlot());

            }



        }
    }

        public GridPane createGrid(){

//            System.out.println("Grid Creation top index: " + index);
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
//            winnersPane.setCenter(null);
                winnersPane.setCenter(gridPane);
            } else if(nominatePane != null) {
//            nominatePane.setCenter(null);
                nominatePane.setCenter(gridPane);
            } else if(votePane != null) {
//            votePane.setCenter(null);
                votePane.setCenter(gridPane);
            } else if(searchPane != null) {
//            searchPane.setCenter(null);
                searchPane.setCenter(gridPane);
            }

            System.out.println("Grid Creation bottom index: " + index);
//            System.out.println("Movies: " + movies.get(index));
            return gridPane;
        }

        public void createCard(int row, int column, String titleIn, String categoryIn, String posterIn, String plotIn, GridPane gridPane) {

        // Variables
//            System.out.println("Card Creation top index: " + index);
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
        Label title = new Label(titleIn);
        title.setId("titleCard");
        Label category = new Label(categoryIn);
        category.setId("categoryCard");
        ScrollPane detailsPane = new ScrollPane();
        detailsPane.setId("scrollPaneCard");
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
//        System.out.println("Card Creation bottom index: " + index);


//      Click on the Card's poster
        iv.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // find movie object. Send to user
                File noImg = new File("/src/openoscars/resources/imgs/noimage.png");
                String absolute = System.getProperty("user.dir") + noImg ;
                poster[0] = new Image("file:" + absolute);
                for(int i = 0; i < 7; i++){
                    if (movies.get(index-i).getPoster().equals( iv.getImage().getUrl())){
                        User.setCurrentMovie(movies.get(index-i));
                        System.out.println(movies.get(index-i).getTitle());
                    } else if (movies.get(index-i).getPoster().equals(poster[0].getUrl())){
                        User.setCurrentMovie(movies.get(index-i));
                        System.out.println(movies.get(index-i).getTitle());
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
//            index+=1;
            System.out.println("index+=6 " + index + " : " + movies.size());

            GridPane gridPane = createGrid();
            if(winnersPane != null) {
//            winnersPane.setCenter(null);
                winnersPane.setCenter(gridPane);
            } else if(nominatePane != null) {
//            nominatePane.setCenter(null);
                nominatePane.setCenter(gridPane);
            } else if(votePane != null) {
//            votePane.setCenter(null);
                votePane.setCenter(gridPane);
            } else if(searchPane != null) {
//            searchPane.setCenter(null);
                searchPane.setCenter(gridPane);
            }

            cardGrid(gridPane);
            System.out.println("Next page bottom index: " + index );
        }

    }

    @FXML
    public void prevPage(MouseEvent mouseEvent) {
        System.out.println("in prev button");
        if(index>=12){
            index-=12;
            System.out.println("index-=12 " + index + " : " + movies.size());

            GridPane gridPane = createGrid();
            if(winnersPane != null) {
//            winnersPane.setCenter(null);
                winnersPane.setCenter(gridPane);
            } else if(nominatePane != null) {
//            nominatePane.setCenter(null);
                nominatePane.setCenter(gridPane);
            } else if(votePane != null) {
//            votePane.setCenter(null);
                votePane.setCenter(gridPane);
            } else if(searchPane != null) {
//            searchPane.setCenter(null);
                searchPane.setCenter(gridPane);
            }

            cardGrid(gridPane);
            System.out.println("Next page bottom index: " + index );
        }

    }
}
