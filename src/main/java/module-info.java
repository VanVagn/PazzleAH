module com.example.pazzleah {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.pazzleah to javafx.fxml;
    exports com.example.pazzleah;
}