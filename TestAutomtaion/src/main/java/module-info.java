module com.example.testautomtaion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testautomtaion to javafx.fxml;
    exports com.example.testautomtaion;
}