package com.example.assignment4oop;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        // Labels
        Label lblInvestment = new Label("Investment Amount:");
        Label lblYears = new Label("Number of Years:");
        Label lblRate = new Label("Annual Interest Rate:");
        Label lblFuture = new Label("Future value:");

        // Text fields
        TextField txtInvestment = new TextField();
        TextField txtYears = new TextField();
        TextField txtRate = new TextField();
        TextField txtFuture = new TextField();
        txtFuture.setEditable(false);

        // right align text field to match assignment requirement
        txtInvestment.setAlignment(Pos.CENTER_RIGHT);
        txtYears.setAlignment(Pos.CENTER_RIGHT);
        txtRate.setAlignment(Pos.CENTER_RIGHT);
        txtFuture.setAlignment(Pos.CENTER_RIGHT);

        // Button
        Button btnCalculate = new Button("Calculate");

        // Button event handler
        btnCalculate.setOnAction(e -> {
            try {
                double investmentAmount = Double.parseDouble(txtInvestment.getText());
                double years = Double.parseDouble(txtYears.getText());
                double annualRate = Double.parseDouble(txtRate.getText());

                // Convert to monthly rate (percent → decimal → per month)
                double monthlyInterestRate = annualRate / 1200.0;
                double futureValue = investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);

                txtFuture.setText(String.format("$%,.2f", futureValue));
            } catch (NumberFormatException ex) {
                txtFuture.setText("Invalid input");
            }
        });

        // Layout using GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        // Add nodes to grid
        grid.add(lblInvestment, 0, 0);
        grid.add(txtInvestment, 1, 0);

        grid.add(lblYears, 0, 1);
        grid.add(txtYears, 1, 1);

        grid.add(lblRate, 0, 2);
        grid.add(txtRate, 1, 2);

        grid.add(lblFuture, 0, 3);
        grid.add(txtFuture, 1, 3);

        grid.add(btnCalculate, 1, 4);

        //calculate button to right
        GridPane.setHalignment(btnCalculate, HPos.RIGHT);

        // Scene
        Scene scene = new Scene(grid, 350, 220);
        stage.setTitle("Investment-value calculator");
        stage.setScene(scene);
        stage.show();
    }
}
