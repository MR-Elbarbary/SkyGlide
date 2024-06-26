module skyglide {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens skyglide to javafx.fxml;
    opens skyglide.classes.flight to javafx.base;
    opens skyglide.classes.user to javafx.base;
    opens skyglide.classes.airport to javafx.base;
    opens skyglide.classes.aircraft to javafx.base;
    opens skyglide.classes.ticket to javafx.base;
    exports skyglide;
}
