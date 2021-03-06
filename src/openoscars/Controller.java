package openoscars;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

// The Controller is the class that should handle actions and logic.
public class Controller implements Initializable {


    // Declaring the FXML Scenes

    @FXML
    public BorderPane homePane;

    @FXML
    public BorderPane searchPane;

    @FXML
    public BorderPane settingsPane;

    @FXML
    public Label userEmail;

    @FXML
    public Button signOutButton;
    @FXML
    public RadioButton defaultThemeSelector;
    @FXML
    public RadioButton plainThemeSelector;
    @FXML
    public RadioButton darkModeThemeSelector;
    @FXML
    public HBox navBar;
    @FXML
    public TextField searchBox;
    public Button toRegister;
    public Button toSignin;
    public Button signInButton;
    public Hyperlink forgotPassword;
    public Label agreeText;
    public Hyperlink tosHyper;
    public Button joinButton;
    public Button homeButton;
    public Button winnersButton;
    public Button nominateButton;
    public Button voteButton;
    public Button searchButton;
    public Button accountButton;
    public Button settingsButton;
    public Label welcomeHeader;
    public Label welcomeBody;
    public Label createdBy;
    public Label Jose;
    public Label Evelyn;
    public Label Skyler;
    public Label Alex;
    public Label Steven;
    public Label Phuc;
    public Button website;
    public VBox vboxAccount;
    public Label votedTextAccount;
    public Label nominatedTextAccount;

    @FXML
    private BorderPane loginPane;


    // Declaring the FXML ID's
    @FXML
    public javafx.scene.control.TextField registerEmail;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private CheckBox tosCheckbox;

    @FXML
    public javafx.scene.control.Button backButton;

    @FXML
    public javafx.scene.control.TextField loginEmail;

    @FXML
    public ToggleGroup styleToggleGroup;

    @FXML
    private PasswordField loginPassword;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(userEmail != null){
            User user = new User();
            String email = user.getEmail();
            userEmail.setText(email);
        }

        if(loginPane != null && votedTextAccount != null){
            votedTextAccount.setText("You have voted for: " + User.getVotedMovie());
        }
        if(loginPane != null && nominatedTextAccount != null){
            nominatedTextAccount.setText("You have nominated: " + User.getNominatedMovie());
        }

    }

    // Navigation Button Handling
    // Note that on the last line, the current window must be referenced.
    // It doesn't matter for the nav bar because it's still part of home.
    @FXML
    private void navigateHome(ActionEvent event){
        MovieCardFactoryController.index = 0;
        Stage stage = (Stage) homePane.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("resources/home.fxml"));
            root.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 1366, 768);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    private void navigateWinners(ActionEvent event){
        MovieCardFactoryController.index = 0;
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/winners.fxml"));
            view.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        } catch (LoadException e){
            Label noConnection = new Label("No Connection");
            noConnection.setMaxWidth(Double.MAX_VALUE);
            GridPane accidentPane = new GridPane();
            accidentPane.add(noConnection, 0, 0);
            accidentPane.setAlignment(Pos.CENTER);

            view = accidentPane;

        } catch (IOException e) {
            e.printStackTrace();
        }
        homePane.setCenter(view);

    }

    @FXML
    private void navigateNominate(ActionEvent event){
        MovieCardFactoryController.index = 0;
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/nominate.fxml"));
            view.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
        homePane.setCenter(view);
    }

    @FXML
    private void navigateSearch(ActionEvent event){
        MovieCardFactoryController.index = 0;
        User.setSearch(searchBox.getText().replace(" ","%20"));
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/search.fxml"));
            view.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
        homePane.setCenter(view);
    }

    @FXML
    private void navigateVote(ActionEvent event){
        MovieCardFactoryController.index = 0;
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/vote.fxml"));
            view.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
        homePane.setCenter(view);
    }

//  This goes to About now, and not settings. Settings was abandoned.
    @FXML
    private void navigateSettings(ActionEvent event){
        MovieCardFactoryController.index = 0;
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/about.fxml"));
            view.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
        homePane.setCenter(view);


    }

    @FXML
    private void navigateRegister(ActionEvent event){
        Pane view = null;
        try {
            view = FXMLLoader.load(getClass().getResource("resources/register.fxml"));
            view.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginPane.setCenter(view);
    }

    @FXML
    private void navigateLogin(ActionEvent event){
        Stage stage = (Stage) loginPane.getScene().getWindow();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("resources/login.fxml"));
            root.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
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
            String absolute = System.getProperty("user.dir") + usernames ;
            FileWriter fw = new FileWriter(absolute, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(email + "/" + password);
            bw.newLine();
            bw.close();
            Alert alert = new Alert(Alert.AlertType.NONE, "Account Created", ButtonType.OK);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("iconSmall.png")));
            alert.show();
        } else if(!tosCheckbox.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Please agree to the terms of service.", ButtonType.OK);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("iconSmall.png")));
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.NONE, "Please enter your email and password", ButtonType.OK);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("iconSmall.png")));
            alert.show();
        }

    }

    @FXML
    public void loginButton(ActionEvent event) throws FileNotFoundException {
        File usernames = new File("/src/openoscars/resources/users.txt");
        String absolute = System.getProperty("user.dir") + usernames ;
        String email = loginEmail.getText().trim();
        String search = email + "/" + loginPassword.getText().trim();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(absolute)))) {

            String line = reader.readLine();
            while (line  != null){

                if (line != null && line.equals(search)) {

                    Stage stage = new Stage();
                    Parent root = null;

                    try {
                        root = FXMLLoader.load(getClass().getResource("resources/home.fxml"));
                        root.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root, 1366, 768);
                    stage.setScene(scene);
                    stage.getIcons().add(new Image(getClass().getResourceAsStream("iconSmall.png")));
                    stage.show();
                    Stage oldStage = (Stage) loginPane.getScene().getWindow();
                    oldStage.close();

                    //Saving User
                    User user = new User();
                    user.setEmail(email);

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


    @FXML
    public void popupAccount(ActionEvent event) throws InterruptedException {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("resources/account.fxml"));
            root.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 426, 300);
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("iconSmall.png")));
        stage.show();

        // close main window
        Stage oldStage = (Stage) homePane.getScene().getWindow();
        oldStage.close();
    }

    @FXML
    public void logoutButton(ActionEvent event) throws IOException, InterruptedException {

        // Close logout window
        Stage stage = (Stage) backButton.getScene().getWindow();
        User.setNominatedMovie(null);
        User.setVotedMovie(null);

        stage.close();


        // Restart login window
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("resources/login.fxml"));
        root.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        newStage.setTitle("OpenOscars");
        newStage.setScene(new Scene(root, 426, 300));
        newStage.getIcons().add(new Image(getClass().getResourceAsStream("iconSmall.png")));
        newStage.show();
    }

    @FXML
    public void logoutBackButton(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("resources/home.fxml"));
            root.getStylesheets().add(getClass().getResource(User.getTheme()).toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 1366, 768);
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("iconSmall.png")));
        stage.show();
        Stage oldStage = (Stage) backButton.getScene().getWindow();
        oldStage.close();
    }

}
