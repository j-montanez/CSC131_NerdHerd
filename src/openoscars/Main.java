package openoscars;

//javafx imports
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.LineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import static javafx.application.Application.launch;
import static javafx.scene.layout.GridPane.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception
    {
        //text
        Label logo = new Label("Open Oscars");
        logo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Text search= new Text("Search:");
        search.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        Text welcome= new Text("Welcome!");
        welcome.setFont(Font.font("verdana", FontWeight.BOLD, 30));
        Text image= new Text("image placeholder");
        image.setFont(Font.font(20));


        //Buttons main
        Button winners= new Button("Winners");
        Button nominate= new Button("Nominate");
        Button vote= new Button("Vote");
        Button account= new Button("Account");
        Button settings= new Button("Settings");
        TextField searchbar= new TextField();
        Button searchgo = new Button("Go" );

        //setting up panel main
        GridPane gridpane= new GridPane();
        gridpane.setPadding(new Insets(10,10,10,10));
        gridpane.setHgap(15);
        gridpane.setVgap(10);


        //add the children!
        gridpane.add(logo, 0, 0, 1, 4);
        gridpane.add(winners, 4, 1);
        gridpane.add(nominate, 5, 1);
        gridpane.add(vote, 6, 1);
        gridpane.add(search, 20, 1);
        gridpane.add(searchbar, 21, 1);
        gridpane.add(searchgo, 22, 1);
        gridpane.add(account, 23, 1);
        gridpane.add(settings, 24, 1);
        gridpane.add(image, 1, 20, 6,20);
        gridpane.add(welcome, 21,6,2 ,20);

        //setting up main stage

        Scene main= new Scene(gridpane, 1200, 600);
        stage.setTitle("Open Oscars");
        stage.setScene(main);
        stage.show();

        /* creating a new scene for logging in to account-------------------------------------*/
        Text text1 = new Text("Email");

        //creating label password
        Text text2 = new Text("Password");

        //Creating Text Filed for email
        TextField textField1 = new TextField();

        //Creating Text Filed for password
        PasswordField textField2 = new PasswordField();

        //Creating Buttons
        Button loginButton = new Button("Sign In");
        Button homeButton = new Button("Home");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(400, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(loginButton, 0, 2);
        gridPane.add(homeButton, 1, 2);

        //Styling nodes
        loginButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        homeButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        text1.setStyle("-fx-font: normal bold 20px 'serif' ");
        text2.setStyle("-fx-font: normal bold 20px 'serif' ");


        //Creating a scene object
        Scene loginScene = new Scene(gridPane);

        /* creating a new scene for settings  -------------------------------------*/
        Text settingsText= new Text("Settings");
        settingsText.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

        //buttons
        Button homeS= new Button("Home");
        Button saveS= new Button("Save Settings");


        GridPane settingsGridpane= new GridPane();
        settingsGridpane.setAlignment(Pos.CENTER);
        settingsGridpane.setPadding(new Insets(10,10,10,10));
        settingsGridpane.setHgap(15);
        settingsGridpane.setVgap(10);

        settingsGridpane.add(settingsText, 0, 0, 2, 1);
        settingsGridpane.add(homeS, 0,15);
        settingsGridpane.add(saveS, 1, 15);

        Scene accountScene= new Scene(settingsGridpane, 1000, 600);

        /* creating a new scene for Vote  -------------------------------------*/
        Text voteTxt= new Text("Vote for the Oscars");
        voteTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

        Button homeV= new Button("Home");

        GridPane voteGrid= new GridPane();
        voteGrid.setAlignment((Pos.CENTER));
        voteGrid.setPadding(new Insets(10,10,10,10));
        voteGrid.setHgap(15);
        voteGrid.setVgap(10);

        voteGrid.add(voteTxt, 0,0,20,1);
        voteGrid.add(homeV, 12,20);

        Scene voteScene= new Scene(voteGrid, 1000,600);

        /* creating a new scene for Nominate  -------------------------------------*/
        Text nominateTxt= new Text("Nominate");
        nominateTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

        Button homeN= new Button("Home");

        GridPane nominateGrid= new GridPane();
        nominateGrid.setAlignment((Pos.CENTER));
        nominateGrid.setPadding(new Insets(10,10,10,10));
        nominateGrid.setHgap(15);
        nominateGrid.setVgap(10);

        nominateGrid.add(nominateTxt, 0, 0, 10, 1);
        nominateGrid.add(homeN, 5, 20);

        Scene nomScene= new Scene(nominateGrid, 1000, 600);

        /* creating a new scene for Winners  -------------------------------------*/
        Text pastWin= new Text("Past Winners");
        pastWin.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

        Text yr= new Text("2019");
        yr.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        Button homeW= new Button("Home");

        GridPane winGrid= new GridPane();
        winGrid.setAlignment((Pos.CENTER));
        winGrid.setPadding(new Insets(10,10,10,10));
        winGrid.setHgap(15);
        winGrid.setVgap(10);

        winGrid.add(pastWin, 0,0,20,1);
        winGrid.add(yr, 7,1,5,1);
        winGrid.add(homeW, 8, 30);

        Scene winScene= new Scene(winGrid, 1000,600);



        //Event handling----------------------------------------------------
        //when account is clicked
        account.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(loginScene);
                stage.setTitle("Sign In");
                stage.show();
            }
        });
        //when home is clicked
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(main);
                stage.setTitle("Open Oscars");
                stage.show();
            }
        });
        //When the settings button is clicked
        settings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(accountScene);
                stage.show();
            }
        });
        homeS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(main);
                stage.show();
            }
        });
        vote.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(voteScene);
                stage.show();
            }
        });
        homeV.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(main);
                stage.show();
            }
        });
        nominate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(nomScene);
                stage.show();
            }
        });
        homeN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(main);
                stage.show();
            }
        });
        winners.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(winScene);
                stage.show();
            }
        });
        homeW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(main);
                stage.show();
            }
        });
        searchgo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            //search for movie
            }
        });

    }



    public static void main(String[] args)
    {


        launch(args);
    }
}
