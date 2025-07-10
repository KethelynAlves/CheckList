module com.checklist.checklist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.checklist.checklist to javafx.fxml;
    exports com.checklist.checklist;
    exports controllers;
    opens controllers to javafx.fxml;
}