package com.example.assignment4oop_1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
}

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<Person> people = FXCollections.observableArrayList(
                new Person("Ian", "Bergstrom"),
                new Person("Carter", "Daniel"),
                new Person("March", "Hill"),
                new Person("Samuel", "Boye"),
                new Person("Martin", "Boye")
        );

        // Create the ListView
        ListView<Person> listView = new ListView<>(people);
        listView.setPrefWidth(230); // make list wider
        listView.setFixedCellSize(28); // evenly spaced cells
        listView.setStyle("""
                -fx-font-size: 14px;
                -fx-background-radius: 0;
                -fx-border-radius: 0;
                """);

        // Label for selected name
        Label lblSelected = new Label("Select a person...");
        lblSelected.setStyle("""
                -fx-font-size: 14px;
                -fx-padding: 5;
                """);

        // Event listener
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                lblSelected.setText(newVal.getFirstName() + " " + newVal.getLastName());
            }
        });

        // Layout
        VBox layout = new VBox(8);
        layout.setStyle("""
                -fx-background-color: white;
                -fx-border-color: black;
                -fx-border-width: 2;
                -fx-background-radius: 0;
                -fx-border-radius: 0;
                """);
        layout.getChildren().addAll(listView, lblSelected);

        // Scene setup
        Scene scene = new Scene(layout, 260, 270);
        stage.setTitle("ListView Assignment");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
