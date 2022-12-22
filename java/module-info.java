module mod3.pruefung {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens mod3.pruefung to javafx.fxml;
    exports mod3.pruefung;
}