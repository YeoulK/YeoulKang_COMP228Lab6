module com.example.yeoulkang_comp228lab6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.yeoulkang_comp228lab6 to javafx.fxml;
    exports com.example.yeoulkang_comp228lab6;
}