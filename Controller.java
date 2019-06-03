package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoZonedDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.ThaiBuddhistChronology;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ObservableList<String> YearList= FXCollections.observableArrayList("2017-18","2018-19","2019-20","2020-21");
    ObservableList<String> statlist=FXCollections.observableArrayList("Individual","Domestic Company","Foreign Company","Partnership Form","LLP","HUF","TRUST(ITR7)","AOP","BOI","PDT","AOP-MMR","BOI");
    ObservableList<String> c1list=FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
    ObservableList<String> c2list=FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75");
    @FXML
    private ChoiceBox Year,stat,c1,c2,c3,c4,c5,c6;
    @FXML
    private JFXButton next;
    @FXML
    private VBox ParentContainer;
    @FXML
    private AnchorPane Anchorp;
    @FXML
    private JFXDatePicker date;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Year.setItems(YearList);
        stat.setItems(statlist);
        c1.setItems(c1list);
        c2.setItems(c2list);
        c3.setItems(c1list);
        c4.setItems(c1list);
        c5.setItems(c2list);
        c6.setItems(c2list);
    }
    @FXML
    public void buttonpressed(ActionEvent ae)
    {
     try {
         Parent root1 = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
         ParentContainer.getChildren().add(root1);
         ParentContainer.getChildren().remove(Anchorp);
     }
     catch(IOException ex)
     {
         System.out.println(ex);
     }

    }
}