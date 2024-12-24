module com.example.assignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.apache.poi.ooxml;
    requires org.apache.poi.ooxml.schemas;
    requires org.apache.poi.poi;
    requires org.apache.commons.configuration2;
    requires org.apache.commons.logging;



    opens com.example.assignment to javafx.fxml;
    exports com.example.assignment;
    exports com.example.assignment.backend.services;
    exports com.example.assignment.backend.models;


}