module com.example.pazzleah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pazzleah to javafx.fxml;
    exports com.example.pazzleah;
}