package uk.ac.soton.comp1206;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class SimplePropertyExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the title label
        Label titleLabel = new Label("Lecture 5");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #333;");
        // Create the text field for name input
        SimpleStringProperty stringProperty =new SimpleStringProperty("Untitled");
        TextField nameField = new TextField();
        nameField.textProperty().bindBidirectional(stringProperty);
        Button nameButton = new Button("I am Tony");
        nameButton.setOnAction(actionEvent->stringProperty.set("Tony"));
        Label nameLabel = new Label();
        nameLabel.textProperty().bind(stringProperty);
        VBox root = new VBox(10); // 10 is the spacing between elements
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(nameField, nameLabel, nameButton);

        // Set the VBox as the root of the scene and set the scene on the stage
        Scene scene = new Scene(root, 100, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lecture 5");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }


    public static void main(String[] args) {
        launch();
    }

}