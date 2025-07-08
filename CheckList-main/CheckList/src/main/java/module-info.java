module checklist.checklist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens checklist.checklist to javafx.fxml;
    exports checklist.checklist;
}