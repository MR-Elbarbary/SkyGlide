module skyglide {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens skyglide to javafx.fxml;
    opens skyglide.classes.user to javafx.base;
    exports skyglide;
}
