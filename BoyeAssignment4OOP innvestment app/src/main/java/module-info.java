module com.example.assignment4oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment4oop to javafx.fxml;
    exports com.example.assignment4oop;
}