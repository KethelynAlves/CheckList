module com.checklist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.checklist to javafx.fxml;
    exports com.checklist;
    exports com.checklist.controllers;
    opens com.checklist.controllers to javafx.fxml;
}