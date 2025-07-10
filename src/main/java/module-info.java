module com.checklist.checklist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.checklist.checklist to javafx.fxml;
    exports com.checklist.checklist;
    exports com.checklist.checklist.controllers;
    opens com.checklist.checklist.controllers to javafx.fxml;
}