module org.example.csc311_lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc311_lab2 to javafx.fxml;
    exports org.example.csc311_lab2;
}