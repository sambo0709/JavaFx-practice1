module com.example.assignment4oop_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment4oop_1 to javafx.fxml;
    exports com.example.assignment4oop_1;
}