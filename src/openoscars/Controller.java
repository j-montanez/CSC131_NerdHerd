package openoscars;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

// The Controller is the class that should handle actions and logic.
public class Controller {


    // Declaring the FXML Scenes

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
    private BorderPane login;

    @FXML
    private BorderPane register;

    @FXML
    private BorderPane about;


    // Declaring the FXML ID's
    @FXML
    public javafx.scene.control.TextField registerEmail;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private CheckBox tosCheckbox;

    @FXML
    public javafx.scene.control.TextField loginEmail;

    @FXML
    private PasswordField loginPassword;




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
    private void navigateRegister(ActionEvent event){
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/register.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        login.setCenter(view);
    }

    @FXML
    private void navigateLogin(ActionEvent event){
        Stage stage = (Stage) login.getScene().getWindow();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("resources/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 426, 300);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void navigateWebsite(ActionEvent event) {
        if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI("https://j-montanez.github.io/CSC131_NerdHerd/"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

    @FXML
    private void registerUser(ActionEvent event) throws IOException {
        if (!registerEmail.getText().trim().isEmpty() && !registerPassword.getText().trim().isEmpty() && tosCheckbox.isSelected()) {
            String email = registerEmail.getText().trim();
            String password = registerPassword.getText().trim();
            File usernames = new File("/src/openoscars/resources/users.txt");
//            System.out.println( System.getProperty("user.dir") + usernames);
            String absolute = System.getProperty("user.dir") + usernames ;
            FileWriter fw = new FileWriter(absolute, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(email + "/" + password);
            bw.newLine();
            bw.close();
            Alert a = new Alert(Alert.AlertType.NONE, "Account Created", ButtonType.OK);
            a.show();
        } else if(!tosCheckbox.isSelected()) {
            Alert a = new Alert(Alert.AlertType.NONE, "Please agree to the terms of service.", ButtonType.OK);
            a.show();
        } else {
            Alert a = new Alert(Alert.AlertType.NONE, "Please enter your email and password", ButtonType.OK);
            a.show();
        }

    }

    @FXML
    public void loginButton(ActionEvent event) throws FileNotFoundException {
        File usernames = new File("/src/openoscars/resources/users.txt");
        String absolute = System.getProperty("user.dir") + usernames ;
        String search = new String(loginEmail.getText().trim() + "/" + loginPassword.getText().trim());


//        Scanner scanner = new Scanner(absolute);

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(absolute)))) {

            String line = reader.readLine();
            while (line  != null){
                System.out.println("Line: " + line + " Search: " +  search + " Is equal? " + Objects.equals(line, search));

                if (line != null && line.equals(search)) {
                    System.out.println("ho hum, i found it");
                    Stage stage = new Stage();
                    Parent root = null;

                    try {
                        root = FXMLLoader.load(getClass().getResource("resources/mainWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root, 1366, 768);
                    stage.setScene(scene);
                    stage.show();
                    Stage oldStage = (Stage) login.getScene().getWindow();
                    oldStage.close();
                    return;
                }
                line = reader.readLine();
            }
            Alert a = new Alert(Alert.AlertType.NONE, "Username or Password incorrect. Please try again.", ButtonType.OK);
            a.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        //now read the file line by line...
//        int lineNum = 0;
//        System.out.println(scanner.hasNextLine());
//        while (scanner.hasNext()) {
//            System.out.println(scanner.next());
////            System.out.println("In while");
//            String line = scanner.nextLine();
//            System.out.println(line);
//            System.out.println(lineNum);
//            lineNum++;

//        }
//
//    }

}
