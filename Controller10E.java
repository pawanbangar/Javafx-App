package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.annotation.Resources;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller10E implements Initializable {

    public ObservableList<Data10E> List= FXCollections.observableArrayList(
            new Data10E("Salary u/s 15 excluding arrears",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Arrears of salary",null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null),
            new Data10E("Income Excempt(included in arrears)",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E(null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E(null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax on employement",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Other income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Deduction under Chapter VI-A",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Qualifying amount of Investments u/s 88",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E(null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax on accrual basis",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Salary excluding arrears",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Add:arrears of salary on accrual basis",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Gross salary",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Deductions",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Standard deduction u/s 16(i)",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax on employment",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Income chargeable under \"Salaries\" ",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Other income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Gross Total Income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Deductions under chapter VI-A",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Total Income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax on total Income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Rebate u/s 88B",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Rebate u/s 88C",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Rebate u/s 88D",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Rebate u/s 87A",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Allowable rebate Under Chapter VIII",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax after rebate",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Add-Surcharge",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax with Surcharge",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Add-Education cess",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax with surcharge and cess",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E(null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax on reciept basis",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Asst. Year","2018-19","2017-18","2016-17","2015-16","2014-15",
                    "2013-14","2012-13","2011-12","2010-11","2009-10","2008-09","2007-08","2006-07",
                    "2005-06","2004-05","2003-04","2002-03","2001-02","2000-01"),
            new Data10E("Salary u/s 15 excluding arrears",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Arrears of salary",null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null),
            new Data10E("Income Excempt(included in arrears)",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E(null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E(null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax on employement",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Other income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Deduction under Chapter VI-A",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Qualifying amount of Investments u/s 88",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E(null,null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax on accrual basis",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Salary excluding arrears",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Add:arrears of salary on accrual basis",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Gross salary",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Deductions",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Standard deduction u/s 16(i)",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax on employment",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Income chargeable under \"Salaries\" ",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Other income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Gross Total Income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Deductions under chapter VI-A",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Total Income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax on total Income",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Rebate u/s 88B",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Rebate u/s 88C",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Rebate u/s 88D",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Rebate u/s 87A",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Allowable rebate Under Chapter VIII",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax after rebate",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Add-Surcharge",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax with Surcharge",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Add-Education cess",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax with surcharge and cess",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E(null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null,null),
            new Data10E("Total Tax on accrual basis (a)",null,null,null,null,null,
            null,null,null,null,null,null,null,null,
            null,null,null,null,null,null),
            new Data10E("Total tax on reciept basis (b)",null,null,null,null,null,
                    null,null,null,null,null,null,null,null,
                    null,null,null,null,null,null),
            new Data10E("Tax relief U/s 89 (b-a)",null,null,null,null,null,
            null,null,null,null,null,null,null,null,
            null,null,null,null,null,null)
);
    @FXML
    private TableView<Data10E> table;

    @FXML
    private TableColumn<Data10E,String> asst_year;

    @FXML
    private TableColumn<Data10E,String> column_18_19;

    @FXML
    private TableColumn<Data10E, String> column_17_18;

    @FXML
    private TableColumn<Data10E,String> column_16_17;

    @FXML
    private TableColumn<Data10E,String> column_15_16;

    @FXML
    private TableColumn<Data10E,String> column_14_15;

    @FXML
    private TableColumn<Data10E,String> column_13_14;

    @FXML
    private TableColumn<Data10E,String> column_12_13;

    @FXML
    private TableColumn<Data10E,String> column_11_12;

    @FXML
    private TableColumn<Data10E,String> column_10_11;

    @FXML
    private TableColumn<Data10E,String> column_09_10;

    @FXML
    private TableColumn<Data10E,String> column_08_09;

    @FXML
    private TableColumn<Data10E,String> column_07_08;

    @FXML
    private TableColumn<Data10E,String> column_06_07;

    @FXML
    private TableColumn<Data10E,String> column_05_06;

    @FXML
    private TableColumn<Data10E,String> column_04_05;

    @FXML
    private TableColumn<Data10E,String> column_03_04;

    @FXML
    private TableColumn<Data10E,String> column_02_03;

    @FXML
    private TableColumn<Data10E,String> column_01_02;

    @FXML
    private TableColumn<Data10E,String> column_00_01;
    @Override
    public void initialize(URL location, ResourceBundle Resources)
    {
        TableView.TableViewSelectionModel<Data10E> select= table.getSelectionModel();
        select.setCellSelectionEnabled(true);
        select.setSelectionMode(SelectionMode.SINGLE);
        column_00_01.setCellValueFactory(new PropertyValueFactory<Data10E, String>("Year_00_01"));
        column_01_02.setCellValueFactory(new PropertyValueFactory<Data10E, String>("Year_01_02"));
        column_02_03.setCellValueFactory(new PropertyValueFactory<Data10E, String>("Year_02_03"));
        asst_year.setCellValueFactory(new PropertyValueFactory<Data10E, String>("Asst_Year"));
        table.setItems(List);
       table.setSortPolicy(null);
    }
}
