package uk.ac.soton.comp1206;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleListExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating the ObservableList with initial data
        ObservableList<String> players = FXCollections.observableArrayList("Raya","White","Gabriel","Saliba");

        // Creating a ListView and binding it to the ObservableList
        ListView<String> listView = new ListView<>(players);
        Button b = new Button("Add Player to List");
        TextField f= new TextField();
        b.setOnAction(event->players.add(f.getText()));
        // Add a new username to the list and observe the ListView updating

        // The rest of the code to set up the JavaFX stage
        VBox root = new VBox(listView, b, f);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Observable List Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
