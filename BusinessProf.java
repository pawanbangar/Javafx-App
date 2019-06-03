package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BusinessProf implements Initializable {
    @FXML
    JFXTextField Turn1,Turn2,prof1,prof2,pre1,pre2;
    @FXML
    Label per1,per2;
    String Turn1Val=null,Prof1Val=null,Turn2Val=null,Prof2Val=null;
    Double val1,val2;
    public static int finalTurnVal,finalProfVal;
    @FXML
    AnchorPane Container;
    @FXML
    JFXButton saveButton,cancelButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) throws NumberFormatException
    {

        pre1.setOnAction(e -> {
           String str=pre1.getText();
           System.out.println(str);
        });
        pre2.setOnAction(e ->{
        });

        Turn1.setOnAction(e ->{
            if(Turn1.getText()!=Turn1Val) {
                if (Prof1Val != null) {
                    Turn1Val = Turn1.getText();
                    val1 = Double.parseDouble(Turn1Val);
                    val2 = Double.parseDouble(Prof1Val);
                    final double result = Double.parseDouble(String.format("%.2f", val2 * 100 / val1));
                    per1.setText(Double.toString(result));
                } else {
                    Turn1Val = Turn1.getText();
                    Turn1.setText(Turn1Val);
                }
            }

        });
        Turn2.setOnAction(e ->{
            if(Turn2.getText()!=Turn2Val) {
                if (Prof2Val != null) {
                    Turn2Val = Turn2.getText();
                    double val1 = Double.parseDouble(Turn2Val);
                    int val2 = Integer.parseInt(Prof2Val);
                    final double result = Double.parseDouble(String.format("%.2f", val2 * 100 / val1));
                    per2.setText((Double.toString(result)));
                } else {
                    Turn2Val = Turn2.getText();
                }
            }
        });
        prof1.setOnAction(e ->{
            if(Turn1.getText()!=Turn1Val) {
                if (Turn1Val != null) {
                    Prof1Val = prof1.getText();
                    val1 = Double.parseDouble(Turn1Val);
                    val2 = Double.parseDouble(Prof1Val);
                    final double result = Double.parseDouble(String.format("%.2f", val2 * 100 / val1));
                    per1.setText((Double.toString(result)));
                } else {
                    Prof1Val = prof1.getText();
                }
            }
        });
        prof2.setOnAction(e ->{
            if(prof2.getText()!=Prof2Val) {
                if (Turn2Val != null) {
                    Prof2Val = prof2.getText();
                    val1 = Double.parseDouble(Turn2Val);
                    val2 = Double.parseDouble(Prof2Val);
                    final double result = Double.parseDouble(String.format("%.2f", val2 * 100 / val1));
                    per2.setText((Double.toString(result)));
                } else {
                    Prof2Val = prof1.getText();
                }
            }

        });
        saveButton.setOnAction(e->{
            if((Prof1Val!=null)&&(Prof2Val==null))
            {
                finalProfVal=Integer.parseInt(Prof1Val);
                finalTurnVal=Integer.parseInt(Turn1Val);
                System.out.println(finalProfVal);
                System.out.println(finalTurnVal);
            }
            else if((Prof2Val!=null)&&(Prof1Val==null))
            {
                finalTurnVal=Integer.parseInt(Turn2Val);
                finalProfVal=Integer.parseInt(Prof2Val);
                System.out.println(finalProfVal);
                System.out.println(finalTurnVal);
            }
            else
            {
                finalProfVal=Integer.parseInt(Prof2Val)+Integer.parseInt(Prof1Val);
                finalTurnVal=Integer.parseInt(Turn2Val)+Integer.parseInt(Turn1Val);
                System.out.println(finalProfVal);
                System.out.println(finalTurnVal);
            }
            Controller1.list.get(Controller1.TotalSalary+8).setC2(Integer.toString(finalTurnVal));
            Controller1.list.get(Controller1.TotalSalary+8).setC3(Integer.toString(finalProfVal));
            if(Controller1.list.get(Controller1.TotalSalary+6).getC4()==null)
            {
                Controller1.list.get(Controller1.TotalSalary+6).setC4(Integer.toString(finalProfVal));
            }
            else
            {
                Controller1.list.get(Controller1.TotalSalary+6).setC4(Integer.toString(Integer.parseInt(Controller1.list.get(Controller1.TotalSalary+6).getC4())+finalProfVal));
            }
            Controller1.window.close();

        });
        cancelButton.setOnAction(e->{
            Prof1Val=null;Prof2Val=null;Turn1Val=null;Turn2Val=null;
            prof1.setText(null);prof2.setText(null);Turn1.setText(null);Turn2.setText(null);
            per1.setText(" ");per2.setText(" ");
            Controller1.window.close();

        });
    }
  //  catch(NumberFormatException ex){
    //    String str=ex.toString();
    //}
}
