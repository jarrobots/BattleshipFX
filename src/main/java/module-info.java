module pl.jarrobots.battleshipfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens pl.jarrobots.battleshipfx to javafx.fxml;
    exports pl.jarrobots.battleshipfx;
}