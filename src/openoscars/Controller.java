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
    public BorderPane settings;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private BorderPane about;



    // Navigation Button Handling
    // Note that on the last line, the current window must be referenced.
    // It doesn't matter for the nav bar because it's still part of mainBorderPane.
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

    @FXML
    private void navigateSettings(ActionEvent event){
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/settings.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainBorderPane.setCenter(view);
    }

    @FXML
    private void navigateAbout(ActionEvent event){
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/about.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        settings.setCenter(view);
    }

    @FXML
    private void navigateWebsite(ActionEvent event) {
        System.out.println("Website Activated (Not really)");
    }

}
