package uk.ac.soton.comp1206;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SchedulerExample extends Application {

    private Label timerLabel;
    private int secondsPassed = 0;
    Timeline timeline;
    private Label countdownLabel = new Label();


    @Override
    public void start(Stage primaryStage) throws Exception {
        IntegerProperty counter = new SimpleIntegerProperty(10);
        Text myText = new Text();
        myText.textProperty().bind(counter.asString());
        myText.setStyle("-fx-font-size: 48px");

        var executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            counter.set(counter.get() - 1);
            System.out.println(" Counter = "+counter.get());
            if (counter.get()== 0)
                executor.shutdown();
        }, 1, 1, TimeUnit.SECONDS);
        StackPane pane = new StackPane();
        pane.getChildren().add(myText);
        primaryStage.setScene(new Scene(pane,640,480));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}
