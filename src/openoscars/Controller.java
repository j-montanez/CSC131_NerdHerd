package openoscars;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

// The Controller is the class that should handle actions and logic.
public class Controller {


    // Initializing the FXML Scenes

    @FXML
    public BorderPane home;

    @FXML
    public BorderPane winners;

    @FXML
    public BorderPane nominate;

    @FXML
    public BorderPane search;

    @FXML
    public BorderPane vote;

    @FXML
    private BorderPane mainBorderPane;



    //Navigation Button Handling

    @FXML
    private void navigateHome(ActionEvent event){
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/home.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(view);
    }

    @FXML
    private void navigateWinners(ActionEvent event){
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/winners.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(view);
    }

    @FXML
    private void navigateNominate(ActionEvent event){
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/nominate.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(view);
    }

    @FXML
    private void navigateSearch(ActionEvent event){
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/search.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(view);
    }

    @FXML
    private void navigateVote(ActionEvent event){
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/vote.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(view);
    }

}
