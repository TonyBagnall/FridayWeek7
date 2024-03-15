package uk.ac.soton.comp1206.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.ac.soton.comp1206.App;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Displays the Login Window, to collect the username and then start the chat
 */
public class LoginWindow {

    private static final Logger logger = LogManager.getLogger(LoginWindow.class);
    private final App app;

    Scene scene = null;
    Parent root = null;

    /**
     * Create a new Login Window, linked to the main app. This should get the username of the user.
     * @param app the main app
     */
    public LoginWindow(App app) {
        this.app = app;
        app.setUsername("Guest");
        app.openChat();
    }

/*
        this.app = app;
        Image image = new Image("/ECS.png");

        // Create components
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name:");
        Button signInButton = new Button("Sign In");
        class LoginButton implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent actionEvent) {
                app.setUsername(nameField.getText());
                app.openChat();
            }
        }
        signInButton.setOnAction(new LoginButton());
        // Create a VBox layout and add components
        VBox vBox = new VBox(10, imageView, nameField, signInButton);
        vBox.setAlignment(Pos.CENTER);

        // Set the scene and stage
        scene = new Scene(vBox, 600, 700);
        app.stage.setScene(scene);

 */

    /**
     * Get the scene contained inside the Login Window
     * @return login window scene
     */
    public Scene getScene() {
        return scene;
    }
}
