module edu.fiuba.algo3 {
    requires javafx.controls;
    requires org.json;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;
    requires java.logging;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;

    opens edu.fiuba.algo3.vista to javafx.fxml;
    exports edu.fiuba.algo3;
}