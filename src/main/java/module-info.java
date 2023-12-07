module com.example.liarsdiceclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.liarsdiceclient to javafx.fxml;
    exports com.example.liarsdiceclient;
}