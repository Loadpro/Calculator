module com.example.kata_test {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kata_test to javafx.fxml;
    exports com.example.kata_test;
}