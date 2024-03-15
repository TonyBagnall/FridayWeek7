package uk.ac.soton.comp1206;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimerExample extends Application {

    private Label timerLabel;
    private int secondsPassed = 0;
    IntegerProperty counter;
    Timeline timeline;
    private Label countdownLabel = new Label();
    private void simpleTimer(Stage primaryStage) throws Exception {
        timerLabel = new Label("Seconds: 0");

        // Create a Timeline that calls the updateTimer method every second
        timeline= new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimer()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play(); // Start the timer

        VBox root = new VBox(timerLabel);
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setTitle("Timer Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void countdownTimer(Stage primaryStage) throws Exception {
        counter = new SimpleIntegerProperty(10);
        countdownLabel = new Label();
        countdownLabel.textProperty().bind(
                Bindings.when(counter.isEqualTo(0))
                        .then("BLAST OFF")
                        .otherwise(counter.asString())
        );         // Create a Timeline that calls the updateTimer method every second
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (counter.get() > 0) {
                counter.set(counter.get() - 1);
            } else {
                timeline.stop();
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play(); // Start the timer
        Button resetButton = new Button("Reset Countdown");
        resetButton.setOnAction(event -> {
            counter.set(10); // Reset the timer to 10 seconds
            if (timeline.getStatus() != Timeline.Status.RUNNING) {
                timeline.play(); // Restart the timeline if it's not running
            }
        });


        VBox root = new VBox(countdownLabel, resetButton);
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setTitle("Countdown Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void countdown() {
        // This method is called every second
        counter.setValue(counter.getValue()-1);
        System.out.println(" Countdown "+counter.getValue());
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
//        simpleTimer(primaryStage);
        countdownTimer(primaryStage);
    }
    private void updateTimer() {
        // This method is called every second
        secondsPassed++;
        timerLabel.setText("Seconds: " + secondsPassed);
    }

    public static void main(String[] args) {
        launch();
    }

}
