package sample;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

 public class Controller1 implements Initializable {
     public static Stage window;
     public static IntegerProperty businessProf;
     static int EMPCTR = 1,SIZE=48,PROFCTR=12,DEPRCTR=17,LESSCTR=20,OTHERCTR=31,CHAPTERCTR=34,INVESTCTR=36,RELIEFCTR=41;
     public ObservableList<String> emp1List=FXCollections.observableArrayList("Salaries,allowances and perquisites",
             "Salary as per monthly table","Salary: as per form 16 / Certificate");

     public ObservableList<String> spbusList=FXCollections.observableArrayList("35AD -Specified business profits",
             "Commision / Agency Business without books","Commision with adhoc deduction",
             "Income from partnership firm","Non-specified Profession without books of a/c",
             "Presumptive profits- 44B to 44DA,44,tonnage tax.","Speculation business profits",
             "Transport business - U/s 44AE");

     public ObservableList<String> DeprecList=FXCollections.observableArrayList("36 disallowance","37 disallowance",
             "40 disallowancew","40A disallowance","43B disallowance","Deemed Incomes",
             "Effect of deviation from ICDS and Valuation method u/s 145A","Expenses / Losses considered under other heads",
             "Income not credited to p & L A/c","Other additions");

     public ObservableList<String> LessdedList=FXCollections.observableArrayList("35 to 35E,32AD,33AB,33ABA deductions",
             "Excempt income included in net profit","Income tax refund","Incomes Considered seperately",
             "Other Deductions");

     public ObservableList<String> othersourcesList = FXCollections.observableArrayList("Advance received but foreited", "Amount taxable u/s 58 & 59"
             , "Bank Interest", "Dividends", "DTAA income,Family pension", "Gifts received", "Income of minor child", "Income of other person"
             , "Income taxable at DTAA rates", "Income taxable at special rates", "Interest income others", "Interes on bank deposits"
             , "Interest on Income Tax refund", "Interest on KVP", "Interest on NSC", "Interest on NSC-year of maturity", "KVP Interest"
             , "Minor child income:", "NSC Interest", "Other person's income", "Other:", "Re-invested interest on NSC(VII/IX Issue)"
             , "Rental income: from plant & machinary etc.", "Transactions without adequate consideration", "Winning: Lotteries,Games,Bettings");

     public ObservableList<String> chapterviaList=FXCollections.observableArrayList("80CCG:Equity saving scheme",
             "80D:Medical Insurance Prema","80DD:Medical treatment of Handicapped",
             "80DDB:Medical Treatment of specified diseases","80E:Interest on education loan repayment",
             "80E:Interest on Housing Loan","80G-Donations","80GG-Rent paid",
             "80GGA:Donatiom for specific research etc","80GGC:Contribution to political party",
             "80IA:Infrastructure Developement etc","80IAB","80IB:Other industrial undertakings",
             "80IBA:Housing projects","80IC or 80IE:Special category states","80JJA",
             "80JJA:Deduction for Additional employee cost","80QQB:Royalty income of authors",
             "80RRB:Royalty on patents","80TTA:Interest on saving Bank a/c",
             "80U:Income of person with disability","CCG:Equity saving scheme",
             "D:Medical Insurance Premia","DD-Medical Treatment of Handicapped",
             "DDB-Medical treatment of specific diseases","E:Interest on education loan repayment",
             "EE:Interest on Housing Loan","G-Donations","GG-Rent paid",
             "GGA-Domain for scientic research etc.","GGC-Contribution to political party",
             "GGC-Contribution to political party","IA=Infrastructure Developement etc.","IAB:","IB",
             "IBA:Housing projects","IC or IE:","JJA:","JJAA-Deduction for Addtional employee cost",
             "QQB:Royalty income of authors","RRB-Royalty on patents","TTA:Interest on saving Bank a/c",
             "U-income of person with disability"
             );

     public ObservableList<String> investList=FXCollections.observableArrayList("Bank Deposit","Deferred Annuity",
             "Deposit in Sukanya Samriddhi Account","Duty/fees/expenses for transfer of Residential Property",
             "ELSS:","Hounsing loan repayment","Installment towards cost of Residential Property",
             "Life insurance premium","NPS-Assessee's contribution u/s 80CCD(1) & (1B)"
             ,"NPS Contribution by Employer u/s 80CCD(2)","NSC","NSC interest","Pension fund coontribution u/s 80CCC","PF cvontribution",
             "Post Office Time Deposit","PPF contribution","Senior citizen savings scheme deposit","Superannuation fund contribution"
             ,"Tuition fees");

     public ObservableList<String> reliefList=FXCollections.observableArrayList("Arrears of Salary",
             "Commutation of Pension","Compensation on Termination","Gratuity Relief",
             "Relief u/s 89-Arrears of Salary","Relief u/s 89-Commutation of Pension",
             "Relief u/s 89-Compensation on Termination","Relief u/s 89-Gratuity","Relief u/s 90 to 91"
     );
     static ObservableList<String> EMPIndexList=FXCollections.observableArrayList();
     static ObservableList<String> PROFIndexList=FXCollections.observableArrayList();
     static ObservableList<String> DEPRECIndexList=FXCollections.observableArrayList();
     static ObservableList<String> LESSIndexList=FXCollections.observableArrayList();
     static ObservableList<String> OtherIndexList=FXCollections.observableArrayList();
     static ObservableList<String> ChapterIndexList=FXCollections.observableArrayList();
     static ObservableList<String> INVESTIndexList=FXCollections.observableArrayList();
     static ObservableList<String> ReliefIndexList=FXCollections.observableArrayList();

     public static ObservableList<String> cellIndexes=FXCollections.observableArrayList();
     public static ObservableList<String> cellIndexesdeprec=FXCollections.observableArrayList();
     public static ObservableList<String> cellIndexprof=FXCollections.observableArrayList();
     public static ObservableList<String> cellIndexLess=FXCollections.observableArrayList();

     static int EMPIndex=0,PROFIndex=0,DEPRECIndex=0,LESSIndex=0,OtherIndex=0,ChapterIndex=0,INVESTINDEX=0,REliefIndex=0,VAR,VAR1=0;
    static int TotalSalary=2,DEPRECTRIncrease=0,LESSCTRIncrease=0;
     public static ObservableList<Data> list = FXCollections.observableArrayList(
             new Data("Employer-1:",null,null,null),
             new Data(null,null,null,null),
             new Data("Total salary",null,null,null),
             new Data("Less: Tax on employement u/s 16(iii)",null,null,null),
             new Data("Income from House Property",null,null,null),
             new Data("Self occupied property:",null,null,null),
             new Data("Interest on borrowed capital",null,null,null),
             new Data("Let out properties",null,null,null),
             new Data("Profits and gains of business or profession",null,null,null),
             new Data(" ","Turnover/Receipts","Profit",null),
             new Data("Business:Presumptive profits u/s 44AD",null,null,null),
             new Data("Special Business:Income from Firm,speculation,without books,44AE...",null,null,null),
             new Data(null,null,null,null),
             new Data("Business-1:",null,null,null),
             new Data("Net Profit Before Tax as per P & L a/c",null,null,null),
             new Data("Add:Indamissible expenses & income not included",null,null,null),
             new Data("Depreciation debited to P & L a/c:",null,null,null),
             new Data(null,null,null,null),
             new Data(" ",null,null,null),
             new Data("Less: Deductible expenditure & income to be excluded",null,null,null),
             new Data(null,null,null,null),
             new Data("Adjusted Profit of Business-1",null,null,null),
             new Data("Total income of Business and Profession",null,null,null),
             new Data("Less:Depreciation as per IT Act",null,null,null),
             new Data("Capital Gains",null,null,null),
             new Data("LTCG-1:",null,null,null),
             new Data("Long Term Capital Gain exempt u/s 10(38)",null,null,null),
             new Data("Long-term Capital Gain from Auto-classification table",null,null,null),
             new Data("STCG-1:",null,null,null),
             new Data("Auto-classification of STCG/LTCG",null,null,null),
             new Data("Income From Other Sources",null,null,null),
             new Data(null,null,null,null),
             new Data("Brought forward losses set off", " ", " ", " "),
             new Data("Deductions under Chapter VI-A",null,null,null),
             new Data(null,null,null,null),
             new Data("Investment u/s 80C,CCC,CCD",null,null,null),
             new Data(null,null,null,null),
             new Data("Total Income",null,null,"0"),
             new Data("Agricultural Income",null,null,null),
             new Data("Tax on Total Income",null,null,null),
             new Data("Relief U/s 89to 91",null,null,null),
             new Data(null,null,null,null),
             new Data("TDS:"," "," "," "),
             new Data("Advance Tax"," "," "," "),
             new Data("Self-assessment tax paid",null,null,null),
             new Data("Balance tax payable",null,null,"0"),
             new Data("Incomes Fully exempt",null,null,null),
             new Data("Footnotes/Pending Issues",null,"Prepared by",null),
             new Data("List of Documents",null,"Approved by",null));

     @FXML
    AnchorPane ParentContainer;
     @FXML
    JFXScrollPane Container;
     @FXML
     TableView<Data> table;
     @FXML
     TableColumn<Data, String> t1;
     @FXML
     TableColumn<Data, String> t2;
     @FXML
     TableColumn<Data, String> t3;
     @FXML
     TableColumn<Data, String> t4;
     @Override
     public void initialize(URL location, ResourceBundle Resources) {
         TableView.TableViewSelectionModel<Data> select= table.getSelectionModel();
         select.setCellSelectionEnabled(true);
         select.setSelectionMode(SelectionMode.SINGLE);
         t1.setCellValueFactory(new PropertyValueFactory<Data, String>("c1"));
         t2.setCellValueFactory(new PropertyValueFactory<Data, String>("c2"));
         t3.setCellValueFactory(new PropertyValueFactory<Data, String>("c3"));
         t4.setCellValueFactory(new PropertyValueFactory<Data, String>("c4"));
         table.setSortPolicy(null);
         t1.setEditable(true);
         t2.setEditable(true);
         table.setEditable(true);
        // businessProf.addListener(Controller1::changed);

         // Create a cell value factory object
         Callback<TableColumn<Data, String>, TableCell<Data, String>> cellFactoryFort1 =
                 new Callback<TableColumn<Data, String>, TableCell<Data, String>>() {
                     @Override
                     public TableCell<Data, String> call(TableColumn<Data, String> param) {
                         TableCell<Data, String> cell = new TableCell<Data, String>() {

                             @Override
                             public void updateItem(String item, boolean empty) {
                                 super.updateItem(item, empty);
                                 setGraphic(null);
                                 setText(null);
                                 if (item == null) {
                                     if (getIndex() == EMPCTR) {
                                         setEditable(true);
                                             JFXComboBox emp1 = new JFXComboBox();
                                             emp1.setItems(emp1List);
                                             setGraphic(emp1);
                                             emp1.setFocusColor(Color.AQUA);
                                             emp1.setPadding(new Insets(-1, 0, -1, 0));
                                             emp1.setOnAction(e -> {
                                                 int i = emp1.getSelectionModel().getSelectedIndex();
                                                 table.edit(getTableRow().getIndex(), t1);
                                                 cellIndexes.add(Integer.toString(getIndex()));
                                                 VAR1++;
                                                 select.clearSelection();
                                                 EMPIndexList.add(emp1List.get(i));
                                                 updateT1(emp1List.get(i),getIndex());
                                                 TotalSalary++;
                                                 EMPIndex++;
                                                 EMPCTR++;
                                                 PROFCTR++;
                                                 DEPRCTR++;
                                                 LESSCTR++;
                                                 OTHERCTR++;
                                                 CHAPTERCTR++;
                                                 INVESTCTR++;
                                                 RELIEFCTR++;
                                                  Platform.runLater(() -> emp1List.remove(i));
                                                 emp1.setOnAction(null);
                                                 setGraphic(null);
                                             });
                                     }
                                     if (getIndex() == PROFCTR) {

                                             JFXComboBox spbus = new JFXComboBox();
                                             spbus.setItems(spbusList);
                                             setGraphic(spbus);
                                             spbus.setPadding(new Insets(-1, 0, -1, 0));
                                             spbus.setOnAction(event -> {
                                                 table.edit(getTableRow().getIndex(), t1);
                                                 int i = spbus.getSelectionModel().getSelectedIndex();
                                               //  cellIndexes.add(Integer.toString(getIndex()));
                                               //  VAR1++;
                                                 select.clearSelection();
                                                 cellIndexprof.add(Integer.toString(getIndex()));
                                                 updateT1(spbusList.get(i),getIndex());
                                                 PROFIndexList.add(spbusList.get(i));
                                                 PROFIndex++;
                                                 PROFCTR++;
                                                 DEPRCTR++;
                                                 LESSCTR++;
                                                 OTHERCTR++;
                                                 CHAPTERCTR++;
                                                 INVESTCTR++;
                                                 RELIEFCTR++;

                                                 setGraphic(null);
                                                 spbus.setOnAction(null);
                                                 Platform.runLater(() -> spbusList.remove(i));
                                             });
                                     }
                                     if (getIndex() == DEPRCTR) {
                                             JFXComboBox deprec = new JFXComboBox();
                                             deprec.setItems(DeprecList);
                                             setGraphic(deprec);
                                             deprec.setPadding(new Insets(-1, 0, -1, 0));
                                             deprec.setOnAction(e -> {
                                                 table.edit(getTableRow().getIndex(), t1);
                                                 int i = deprec.getSelectionModel().getSelectedIndex();
                                                // cellIndexes.add(Integer.toString(getIndex()));
                                                // VAR1++;
                                                 cellIndexesdeprec.add(Integer.toString(getIndex()));
                                                 updateT1(DeprecList.get(i),getIndex());
                                                 DEPRECIndexList.add(DeprecList.get(i));
                                                 DEPRECIndex++;
                                                 DEPRCTR++;
                                                 LESSCTR++;
                                                 OTHERCTR++;
                                                 CHAPTERCTR++;
                                                 INVESTCTR++;
                                                 RELIEFCTR++;
                                                 setGraphic(null);
                                                 deprec.setOnAction(null);
                                                 Platform.runLater(() -> DeprecList.remove(i));
                                             });
                                     }
                                     if (getIndex() == LESSCTR) {
                                             JFXComboBox lessded = new JFXComboBox();
                                             lessded.setItems(LessdedList);
                                             setGraphic(lessded);
                                             lessded.setPadding(new Insets(-1, 0, -1, 0));
                                             lessded.setOnAction(event -> {
                                                 table.edit(getTableRow().getIndex(), t1);
                                                 int i = lessded.getSelectionModel().getSelectedIndex();
                                                 cellIndexLess.add(Integer.toString(getIndex()));
                                                 updateT1(LessdedList.get(i),getIndex());
                                              //   cellIndexes.add(Integer.toString(getIndex()));
                                                // VAR1++;
                                                 LESSIndexList.add(LessdedList.get(i));
                                                 LESSIndex++;
                                                 LESSCTR++;
                                                 OTHERCTR++;
                                                 CHAPTERCTR++;
                                                 INVESTCTR++;
                                                 RELIEFCTR++;
                                                 setGraphic(null);
                                                 lessded.setOnAction(null);
                                                 Platform.runLater(() -> LessdedList.remove(i));
                                             });

                                     }
                                     if (getIndex() == OTHERCTR) {

                                         JFXComboBox other = new JFXComboBox();
                                         other.setItems(othersourcesList);
                                         setGraphic(other);
                                         other.setPadding(new Insets(-1, 0, -1, 0));
                                         other.setOnAction(e -> {
                                             table.edit(getTableRow().getIndex(), t1);
                                             int i = other.getSelectionModel().getSelectedIndex();
                                             updateT1(othersourcesList.get(i),getIndex());
                                           //  cellIndexes.add(Integer.toString(getIndex()));
                                           //  VAR1++;
                                             LESSIndexList.add(Integer.toString(getTableRow().getIndex()));
                                             LESSIndex++;
                                             OTHERCTR++;
                                             CHAPTERCTR++;
                                             INVESTCTR++;
                                             RELIEFCTR++;

                                             setGraphic(null);
                                             other.setOnAction(null);
                                             Platform.runLater(() -> othersourcesList.remove(i));
                                           });

                                     }
                                     if (getIndex() == CHAPTERCTR) {

                                         JFXComboBox chaptervia = new JFXComboBox();
                                         chaptervia.setItems(chapterviaList);
                                         setGraphic(chaptervia);
                                         chaptervia.setPadding(new Insets(-1, 0, -1, 0));
                                         chaptervia.setOnAction(e -> {
                                             table.edit(getTableRow().getIndex(), t1);
                                             int i = chaptervia.getSelectionModel().getSelectedIndex();
                                           //  cellIndexes.add(Integer.toString(getIndex()));
                                          //   VAR1++;
                                             updateT1(chapterviaList.get(i),getIndex());
                                             ChapterIndexList.add(chapterviaList.get(i));
                                             ChapterIndex++;
                                             CHAPTERCTR++;
                                             INVESTCTR++;
                                             RELIEFCTR++;
                                             setGraphic(null);
                                             chaptervia.setOnAction(null);
                                             Platform.runLater(() -> chapterviaList.remove(i));
                                         });

                                     }
                                     if (getIndex() == INVESTCTR) {

                                         JFXComboBox invest = new JFXComboBox();
                                         invest.setItems(investList);
                                         setGraphic(invest);
                                         invest.setPadding(new Insets(-1, 0, -1, 0));
                                         invest.setOnAction(e -> {
                                             table.edit(getTableRow().getIndex(), t1);
                                             int i = invest.getSelectionModel().getSelectedIndex();
                                             INVESTIndexList.add(investList.get(i));
                                           //  cellIndexes.add(Integer.toString(getIndex()));
                                           //  VAR1++;
                                             updateT1(investList.get(i),getIndex());
                                             INVESTINDEX++;
                                             INVESTCTR++;
                                             RELIEFCTR++;
                                             setGraphic(null);
                                             invest.setOnAction(null);
                                             Platform.runLater(() -> investList.remove(i));
                                         });
                                     }
                                     if (getIndex() == RELIEFCTR) {

                                             JFXComboBox relief = new JFXComboBox();
                                             relief.setItems(reliefList);
                                             setGraphic(relief);
                                             relief.setPadding(new Insets(-1, 0, -1, 0));

                                             relief.setOnAction(e -> {
                                                 table.edit(getTableRow().getIndex(), t1);
                                                 int i = relief.getSelectionModel().getSelectedIndex();
                                                 ReliefIndexList.add(reliefList.get(i));
                                              //   cellIndexes.add(Integer.toString(getIndex()));
                                              //   VAR1++;
                                                 updateT1(reliefList.get(i),getIndex());
                                                 REliefIndex++;
                                                 RELIEFCTR++;
                                                 setGraphic(null);
                                                 relief.setOnAction(null);
                                                 Platform.runLater(() -> reliefList.remove(i));
                                             });
                                     }

                                 }
                                 else{
                                     setText(item);
                                     setGraphic(null);
                                 }
                             }
                             @Override
                             public void startEdit() {
                                 super.startEdit();
                                for(int i=0;i<EMPIndex;i++)
                                {
                                    if(getText()==EMPIndexList.get(i))
                                    {
                                        JFXTextField textField=new JFXTextField();
                                        textField.setText(getText());
                                        setGraphic(textField);
                                        VAR=i;
                                        textField.setOnKeyPressed(event ->{
                                            if(event.getCode()==KeyCode.BACK_SPACE)
                                            {
                                                select.clearSelection();
                                                String str=getItem();
                                                reverseList(str,getIndex());
                                                cellIndexes.remove(VAR);
                                                TotalSalary--;
                                                VAR1--;
                                                EMPCTR--;
                                                PROFCTR--;
                                                DEPRCTR--;
                                                LESSCTR--;
                                                OTHERCTR--;
                                                CHAPTERCTR--;
                                                INVESTCTR--;
                                                RELIEFCTR--;
                                                textField.setOnKeyPressed(null);
                                                setGraphic(null);
                                            }
                                            if(event.getCode()==KeyCode.ENTER) {
                                                setGraphic(null);
                                                setText(textField.getText());
                                                commitEdit(textField.getText());
                                            }
                                        });
                                    }
                                }
                                for(int i=0;i<PROFIndex;i++)
                                 {
                                     if(getText()==PROFIndexList.get(i))
                                     {

                                         JFXTextField textField=new JFXTextField();
                                         textField.setText(getText());
                                         setGraphic(textField);
                                         VAR=i;
                                         textField.setOnKeyPressed(event ->{
                                             if(event.getCode()==KeyCode.BACK_SPACE)
                                             {
                                                 String str=getItem();
                                                 if(list.get(getIndex()).getC2()!=null)
                                                 {
                                                     list.get(TotalSalary+6).setC4(Integer.toString(Integer.parseInt(list.get(TotalSalary+6).getC4())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                 }
                                                 reverseListPROF(str,getIndex());
                                               //  cellIndexprof.remove(VAR);
                                              //   VAR1--;
                                                 PROFCTR--;
                                                 DEPRCTR--;
                                                 LESSCTR--;
                                                 OTHERCTR--;
                                                 CHAPTERCTR--;
                                                 INVESTCTR--;
                                                 RELIEFCTR--;
                                                 setGraphic(null);
                                                 setOnKeyPressed(null);

                                             }
                                             if(event.getCode()==KeyCode.ENTER)
                                             {
                                                 setGraphic(null);
                                                 setText(textField.getText());
                                                 commitEdit(textField.getText());
                                             }
                                         });
                                     }
                                 }
                                 for(int i=0;i<DEPRECIndex;i++)
                                 {
                                     if(getText()==DEPRECIndexList.get(i))
                                     {
                                         JFXTextField textField=new JFXTextField();

                                         textField.setText(getText());
                                         setGraphic(textField);
                                         VAR=i;
                                         textField.setOnKeyPressed(event ->{
                                             if(event.getCode()==KeyCode.BACK_SPACE)
                                             {
                                                 String str=getItem();
                                                 if(list.get(getIndex()).getC2()!=null)
                                                 {

                                                     list.get(TotalSalary+6).setC4(Integer.toString(Integer.parseInt(list.get(TotalSalary+6).getC4())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                     if(getIndex()==DEPRCTR-1){
                                                         list.get(DEPRCTR-2).setC3(Integer.toString(Integer.parseInt(list.get(DEPRECTRIncrease).getC3())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                         DEPRECTRIncrease=DEPRCTR-2;
                                                     }
                                                     else{
                                                         list.get(DEPRCTR-1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRECTRIncrease).getC3())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                         DEPRECTRIncrease=DEPRCTR-2;
                                                     }
                                                     list.get(DEPRCTR+1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR+1).getC3())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                 }
                                                 else{
                                                     if(getIndex()==DEPRCTR-1){
                                                         list.get(DEPRCTR-2).setC3(list.get(DEPRECTRIncrease).getC3());
                                                     }
                                                     else{
                                                         list.get(DEPRCTR-1).setC3(list.get(DEPRECTRIncrease).getC3());
                                                     }
                                                     DEPRECTRIncrease=DEPRCTR-2;
                                                 }
                                                 reverseListDeprec(str,getIndex());
                                               //  cellIndexes.remove(VAR);
                                              //   VAR1--;
                                                 DEPRCTR--;
                                                 LESSCTR--;
                                                 OTHERCTR--;
                                                 CHAPTERCTR--;
                                                 INVESTCTR--;
                                                 RELIEFCTR--;
                                                 setGraphic(null);
                                                 setOnKeyPressed(null);

                                             }
                                             if(event.getCode()==KeyCode.ENTER)
                                             {
                                                 setGraphic(null);
                                                 setText(textField.getText());
                                                 commitEdit(textField.getText());
                                             }
                                         });
                                     }
                                 }
                                 for(int i=0;i<LESSIndex;i++)
                                 {
                                     if(getText()==LESSIndexList.get(i))
                                     {
                                         JFXTextField textField=new JFXTextField();
                                         textField.setText(getText());
                                         setGraphic(textField);
                                         VAR=i;
                                         textField.setOnKeyPressed(event ->{
                                             if(event.getCode()==KeyCode.BACK_SPACE)
                                             {
                                                 setContentDisplay(null);
                                                 String str=getItem();
                                                 reverseListLESS(str,getIndex());
                                                // cellIndexes.remove(VAR);
                                               //  VAR1--;
                                                 LESSCTR--;
                                                 OTHERCTR--;
                                                 CHAPTERCTR--;
                                                 INVESTCTR--;
                                                 RELIEFCTR--;
                                                 setGraphic(null);
                                                 setOnKeyPressed(null);

                                             }
                                             if(event.getCode()==KeyCode.ENTER)
                                             {
                                                 setGraphic(null);
                                                 setText(textField.getText());
                                                 commitEdit(textField.getText());
                                             }
                                         });
                                     }
                                 }
                                 for(int i=0;i<OtherIndex;i++)
                                 {
                                     if(getText()==OtherIndexList.get(i))
                                     {
                                         JFXTextField textField=new JFXTextField();
                                         textField.setText(getText());
                                         setGraphic(textField);
                                         VAR=i;
                                         textField.setOnKeyPressed(event ->{
                                             if(event.getCode()==KeyCode.BACK_SPACE)
                                             {
                                                 String str=getItem();
                                                 reverseListOther(str,getIndex());
                                                 cellIndexes.remove(VAR);
                                                 VAR1--;
                                                 OTHERCTR--;
                                                 CHAPTERCTR--;
                                                 INVESTCTR--;
                                                 RELIEFCTR--;
                                                 setGraphic(null);
                                                 setOnKeyPressed(null);

                                             }
                                             if(event.getCode()==KeyCode.ENTER)
                                             {
                                                 setGraphic(null);
                                                 setText(textField.getText());
                                                 commitEdit(textField.getText());
                                             }
                                         });
                                     }
                                 }
                                 for(int i=0;i<ChapterIndex;i++)
                                 {
                                     if(getText()==ChapterIndexList.get(i))
                                     {
                                         JFXTextField textField=new JFXTextField();
                                         textField.setText(getText());
                                         setGraphic(textField);
                                         VAR=i;
                                         textField.setOnKeyPressed(event ->{
                                             if(event.getCode()==KeyCode.BACK_SPACE)
                                             {
                                                 String str=getItem();
                                                 reverseListCHAPTER(str,getIndex());
                                               //  cellIndexes.remove(VAR);
                                               //  VAR1--;
                                                 CHAPTERCTR--;
                                                 INVESTCTR--;
                                                 RELIEFCTR--;
                                                 setGraphic(null);
                                                 setOnKeyPressed(null);

                                             }
                                             if(event.getCode()==KeyCode.ENTER)
                                             {
                                                 setGraphic(null);
                                                 setText(textField.getText());
                                                 commitEdit(textField.getText());
                                             }
                                         });
                                     }
                                 }
                                 for(int i=0;i<INVESTINDEX;i++)
                                 {
                                     if(getText()==INVESTIndexList.get(i))
                                     {
                                         JFXTextField textField=new JFXTextField();
                                         textField.setText(getText());
                                         setGraphic(textField);
                                         VAR=i;
                                         textField.setOnKeyPressed(event ->{
                                             if(event.getCode()==KeyCode.BACK_SPACE)
                                             {
                                                 String str=getItem();
                                                 reverseListINVEST(str,getIndex());
                                              //   cellIndexes.remove(VAR);
                                               //  VAR1--;
                                                 INVESTCTR--;
                                                 RELIEFCTR--;
                                                 setGraphic(null);
                                                 setOnKeyPressed(null);

                                             }
                                             if(event.getCode()==KeyCode.ENTER)
                                             {
                                                 setGraphic(null);
                                                 setText(textField.getText());
                                                 commitEdit(textField.getText());
                                             }
                                         });
                                     }
                                 }
                                 for(int i=0;i<REliefIndex;i++)
                                 {
                                     if(getText()==ReliefIndexList.get(i))
                                     {
                                         JFXTextField textField=new JFXTextField();
                                         textField.setText(getText());
                                         setGraphic(textField);
                                         VAR=i;
                                         textField.setOnKeyPressed(event ->{
                                             if(event.getCode()==KeyCode.BACK_SPACE)
                                             {
                                                 String str=getItem();
                                                 reverseListRELIEF(str,getIndex());
                                              //   cellIndexes.remove(VAR);
                                               //  VAR1--;
                                                 RELIEFCTR--;
                                                 setGraphic(null);
                                                 setOnKeyPressed(null);

                                             }
                                             if(event.getCode()==KeyCode.ACCEPT)
                                             {
                                                 setGraphic(null);
                                                 setText(textField.getText());
                                                 commitEdit(textField.getText());
                                             }

                                         });
                                     }
                                 }

                             }
                             @Override
                             public void cancelEdit() {
                                 super.cancelEdit();

                                 setText(String.valueOf(getItem()));
                                 setGraphic(null);
                             }
                         };
                         return cell;
                     }
                 };
         t1.setCellFactory(cellFactoryFort1);
         table.setItems(list);
         Callback<TableColumn<Data, String>, TableCell<Data, String>> cellFactoryFort2 =
                 new Callback<TableColumn<Data, String>, TableCell<Data, String>>() {
                     @Override
                     public TableCell<Data, String> call(TableColumn<Data, String> param) {
                         TableCell<Data, String> cell = new TableCell<Data, String>() {
                             @Override
                             public void updateItem(String item, boolean empty) {
                                 super.updateItem(item, empty);
                                 setGraphic(null);
                                 setText(getItem());
                                 for(int i=0;i<EMPIndex;i++)
                                 {
                                    /* if(this.getIndex()==(Integer.parseInt(EMPIndexList.get(i))))
                                     {
                                         this.setId("9d");
                                     }*/
                                 }
                             }
                             @Override
                             public void startEdit(){
                                 super.startEdit();
                                 JFXTextField textField=new JFXTextField();
                                 setGraphic(null);
                                 for(int i=0;i<VAR1;i++)
                                 {
                                     if(getIndex()==Integer.parseInt(cellIndexes.get(i)))
                                     {

                                         textField.setText(getText());
                                         setGraphic(textField);
                                        // setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                                         VAR=i;
                                         textField.setOnKeyPressed(event ->{
                                             if(event.getCode()==KeyCode.ENTER)
                                             {
                                               setContentDisplay(null);
                                                 String str=textField.getText();
                                                 if((list.get(getIndex()).getC2())==(getText())&&(list.get(getIndex()).getC2()!=null))
                                                 {
                                                     list.get(TotalSalary).setC3(Integer.toString(Integer.parseInt(list.get(TotalSalary).getC3())-Integer.parseInt(list.get(getIndex()).getC2())+Integer.parseInt(textField.getText())));
                                                     if(list.get(TotalSalary+1).getC2()!=null) {

                                                         list.get(0).setC4(Integer.toString(Integer.parseInt(list.get(TotalSalary).getC3()) - Integer.parseInt(list.get(TotalSalary + 1).getC2())));
                                                     }
                                                     else
                                                     {
                                                         list.get(0).setC4(Integer.toString(Integer.parseInt(list.get(TotalSalary).getC3())));
                                                     }
                                                     list.get(getIndex()).setC2(str);
                                                     setGraphic(null);
                                                     setOnKeyPressed(null);

                                                 }
                                                 else
                                                 {
                                                         commitEdit(str);
                                                 }
                                                 setGraphic(null);
                                                 setOnKeyPressed(null);
                                             }
                                             if(event.getCode()==KeyCode.ESCAPE)
                                             {
                                                 try {
                                                     window=new Stage();
                                                     Parent root1= FXMLLoader.load(getClass().getResource("10EController.fxml"));
                                                     Scene scene=new Scene(root1,900,300);
                                                     window.setTitle(list.get(getIndex()).getC1());
                                                     window.setScene(scene);
                                                     window.show();
                                                 }
                                                 catch(IOException ex)
                                                 {
                                                     System.out.println(ex);
                                                 }
                                             }
                                         });
                                     }
                                 }
                                 for(String str:cellIndexesdeprec)
                                 {
                                     if(getIndex()==Integer.parseInt(str))
                                     {
                                         if(list.get(getIndex()).getC2()!=null)
                                         {
                                             textField.setText(list.get(getIndex()).getC2());
                                         }
                                         setGraphic(textField);
                                         textField.setOnKeyPressed(e ->{
                                             if(e.getCode()==KeyCode.ENTER)
                                             {
                                                     if (list.get(TotalSalary + 6).getC4() == null) {
                                                         list.get(TotalSalary + 6).setC4(textField.getText());
                                                     } else {
                                                         if(list.get(getIndex()).getC2()!=null)
                                                         {
                                                             list.get(TotalSalary+6).setC4(Integer.toString(Integer.parseInt(list.get(TotalSalary+6).getC4())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                         }
                                                         list.get(TotalSalary + 6).setC4((Integer.toString(Integer.parseInt(list.get(TotalSalary + 6).getC4()) + Integer.parseInt(textField.getText()))));
                                                     }
                                                     if(list.get(DEPRECTRIncrease).getC3()!=null)
                                                     {
                                                         list.get(DEPRCTR-1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRECTRIncrease).getC3())+Integer.parseInt(textField.getText())));
                                                         if(list.get(getIndex()).getC2()!=null)
                                                         {
                                                             list.get(DEPRCTR-1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRECTRIncrease).getC3())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                         }
                                                         if(DEPRECTRIncrease!=DEPRCTR-1)
                                                         {
                                                             list.get(DEPRECTRIncrease).setC3(null);
                                                         }
                                                         if(list.get(DEPRCTR+1).getC3()!=null) {
                                                             if(list.get(getIndex()).getC2()!=null)
                                                             {
                                                                 list.get(DEPRCTR+1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR+1).getC3())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                             }
                                                             list.get(DEPRCTR + 1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR + 1).getC3())+Integer.parseInt(textField.getText())));
                                                         }
                                                         DEPRECTRIncrease=DEPRCTR-1;
                                                     }
                                                     else
                                                     {
                                                         list.get(DEPRCTR-1).setC3(textField.getText());
                                                         DEPRECTRIncrease=DEPRCTR-1;
                                                         if(list.get(DEPRCTR+1).getC3()==null)
                                                         {
                                                             list.get(DEPRCTR+1).setC3(textField.getText());
                                                         }
                                                     }
                                                 commitEdit(textField.getText());
                                                  /*   if(list.get(DEPRCTR+1).getC3()!=null)
                                                     {

                                                     }
                                                     else{
                                                         list.get(DEPRCTR+1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR-1).getC3())+Integer.parseInt(list.get(getIndex()).getC2())+Integer.parseInt(list.get(PROFCTR+2).getC2())));
                                                     }
                                                     */

                                                 setOnKeyPressed(null);
                                                 setGraphic(null);
                                             }
                                         });

                                     }
                                 }
                                 for(String str:cellIndexprof)
                                 {
                                     if(getIndex()==Integer.parseInt(str))
                                     {
                                         if(list.get(getIndex()).getC2()!=null)
                                         {
                                             textField.setText(list.get(getIndex()).getC2());
                                         }
                                         setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                                         setGraphic(textField);
                                         textField.setOnKeyPressed(e ->{
                                             if(e.getCode()==KeyCode.ENTER)
                                             {
                                                 if(textField.getText()!=list.get(getIndex()).getC2()) {
                                                     if (list.get(TotalSalary + 6).getC4() == null) {
                                                         list.get(TotalSalary + 6).setC4(textField.getText());
                                                     } else {
                                                         if(list.get(getIndex()).getC2()!=null)
                                                         {
                                                             list.get(TotalSalary+6).setC4(Integer.toString(Integer.parseInt(list.get(TotalSalary+6).getC4())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                         }
                                                         list.get(TotalSalary + 6).setC4((Integer.toString(Integer.parseInt(list.get(TotalSalary + 6).getC4()) + Integer.parseInt(textField.getText()))));
                                                     }
                                                 }
                                                 commitEdit(textField.getText());
                                                 setOnKeyPressed(null);
                                                 setGraphic(null);
                                                 setContentDisplay(ContentDisplay.CENTER);
                                             }
                                         });

                                     }
                                 }
                                 if(list.get(getIndex()).getC1()=="Less: Tax on employement u/s 16(iii)")
                                 {
                                     setGraphic(null);
                                         textField.setText(getText());
                                         setGraphic(textField);
                                         textField.setOnKeyPressed(event ->{
                                             if(event.getCode()==KeyCode.ENTER)
                                             {
                                                 int num;
                                                 setContentDisplay(null);
                                                 String str=textField.getText();
                                                 commitEdit(str);
                                                 str=list.get(0).getC4();
                                                 if(str==null){
                                                 str="0";
                                                 }
                                                 else{

                                                 str=list.get(getIndex()-1).getC3();
                                                        if(str==null)
                                                        {
                                                            str="0";
                                                        }
                                                 }
                                                 if(list.get(getIndex()).getC1()==textField.getText())
                                                 {
                                                     num=Integer.parseInt(list.get(0).getC4());
                                                 }
                                                 else {
                                                     num = Integer.parseInt(str) - Integer.parseInt(textField.getText());
                                                 }
                                                 list.get(0).setC4(Integer.toString(num));
                                                 list.get(getIndex()).setC3(textField.getText());
                                                 setGraphic(null);
                                                 setOnKeyPressed(null);
                                             }
                                         });
                                 }
                                 if(list.get(getIndex()).getC1()=="Interest on borrowed capital") {
                                     setGraphic(null);
                                     textField.setText(getText());
                                     setGraphic(textField);
                                     textField.setOnKeyPressed(event -> {
                                         if (event.getCode() == KeyCode.ENTER) {
                                             int num;
                                             setContentDisplay(null);
                                             String str = textField.getText();
                                             commitEdit(str);
                                             num = 0-Integer.parseInt(str);
                                             list.get(getIndex()-2).setC4(Integer.toString(num));
                                         }
                                     });
                                 }
                                 if(list.get(getIndex()).getC1()=="Business:Presumptive profits u/s 44AD"){
                                     setGraphic(null);
                                     textField.setText(getText());
                                     setGraphic(textField);
                                     textField.setOnMouseDragged(event ->{
                                         try {
                                         window=new Stage();
                                         Parent root1= FXMLLoader.load(getClass().getResource("BusinessProf.fxml"));
                                         Scene scene=new Scene(root1,900,300);
                                         window.setTitle(list.get(getIndex()).getC1());
                                         window.setScene(scene);
                                         window.show();
                                         }
                                         catch(IOException ex)
                                         {
                                             System.out.println(ex);
                                         }
                                         textField.setOnMouseDragged(null);
                                         setGraphic(null);
                                     });
                                     textField.setOnKeyPressed(event ->{
                                         if(event.getCode()==KeyCode.ENTER)
                                         {
                                             if(list.get(getIndex()-2).getC4()==null)
                                             {

                                                 list.get(getIndex()-2).setC4(list.get(getIndex()).getC3());
                                             }
                                             else
                                             {
                                                 list.get(getIndex()-2).setC4(Integer.toString(Integer.parseInt(list.get(getIndex()-2).getC4())+Integer.parseInt(list.get(getIndex()-2).getC3())));
                                             }
                                             setGraphic(null);
                                         }
                                     });

                                 }
                                 if((list.get(getIndex()).getC1()=="Net Profit Before Tax as per P & L a/c") || (list.get(getIndex()).getC1()=="Depreciation debited to P & L a/c:"))
                                 {
                                     setGraphic(null);
                                     textField.setText(getText());
                                     setGraphic(textField);
                                     textField.setOnKeyPressed(e->{
                                         if(KeyCode.ENTER==e.getCode())
                                         {
                                             if(list.get(TotalSalary+6).getC4()!=null)
                                             {
                                                 if(list.get(getIndex()).getC2()!=null)
                                                 {
                                                     list.get(TotalSalary+6).setC4(Integer.toString(Integer.parseInt(list.get(TotalSalary+6).getC4())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                 }
                                                 list.get(TotalSalary + 6).setC4(Integer.toString(Integer.parseInt(list.get(TotalSalary + 6).getC4()) + Integer.parseInt(textField.getText())));
                                             }
                                           if(list.get(TotalSalary+6).getC4()==null)
                                             {
                                                 list.get(TotalSalary + 6).setC4(textField.getText());
                                             }
                                             if(list.get(getIndex()).getC1()==("Depreciation debited to P & L a/c:")){
                                                     if (list.get(DEPRCTR-1).getC3() == null) {
                                                         list.get(DEPRCTR-1).setC3(textField.getText());
                                                         DEPRECTRIncrease=DEPRCTR-1;
                                                         if(list.get(DEPRCTR+1).getC3()==null)
                                                         {
                                                             list.get(DEPRCTR+1).setC3(textField.getText());
                                                         }
                                                         else{
                                                             if(list.get(getIndex()).getC2()!=null) {
                                                                 list.get(DEPRCTR + 1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR + 1).getC3()) - Integer.parseInt(list.get(getIndex()).getC2())));
                                                             }
                                                             list.get(DEPRCTR + 1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR + 1).getC3()) + Integer.parseInt(textField.getText())));
                                                         }
                                                     } else {
                                                         if(list.get(getIndex()).getC2()!=null){
                                                             list.get(DEPRCTR-1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRECTRIncrease).getC3())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                         }
                                                         list.get(DEPRCTR-1).setC3(Integer.toString(Integer.parseInt(textField.getText()) + Integer.parseInt(list.get(DEPRECTRIncrease).getC3())));
                                                         DEPRECTRIncrease=DEPRCTR-1;
                                                         if(list.get(DEPRCTR+1).getC3()!=null) {
                                                             if(list.get(getIndex()).getC2()!=null) {
                                                                 list.get(DEPRCTR + 1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR + 1).getC3()) - Integer.parseInt(list.get(getIndex()).getC2())));
                                                             }
                                                             list.get(DEPRCTR + 1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR + 1).getC3()) + Integer.parseInt(textField.getText())));
                                                         }
                                                         else{
                                                             list.get(DEPRCTR+1).setC3(textField.getText());
                                                         }
                                                     }
                                                 }
                                             if(list.get(getIndex()).getC1()=="Net Profit Before Tax as per P & L a/c")
                                             {
                                                 if(list.get(DEPRCTR+1).getC3()==null)
                                                 {
                                                     list.get(DEPRCTR+1).setC3(textField.getText());
                                                 }
                                                 else
                                                 {
                                                     if(list.get(getIndex()).getC2()!=null){
                                                         list.get(DEPRCTR+1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR+1).getC3())-Integer.parseInt(list.get(getIndex()).getC2())));
                                                     }
                                                    list.get(DEPRCTR+1).setC3(Integer.toString(Integer.parseInt(list.get(DEPRCTR+1).getC3())+Integer.parseInt(textField.getText())));
                                                 }
                                             }
                                                 commitEdit(textField.getText());
                                             setGraphic(null);
                                             }
                                     });
                                 }
                                 for(String str:cellIndexLess){
                                     if(getIndex()==Integer.parseInt(str)){
                                         setGraphic(null);
                                         textField.setText(getText());
                                         setGraphic(textField);
                                         textField.setOnKeyPressed(e->{
                                             if(e.getCode()==KeyCode.ENTER) {
                                                 if (list.get(LESSCTRIncrease).getC3() == null) {
                                                     list.get(LESSCTR - 1).setC3(textField.getText());
                                                     LESSCTRIncrease=LESSCTR-1;
                                                     commitEdit(textField.getText());
                                                 }
                                                 else
                                                 {
                                                     if (list.get(getIndex()).getC2() != null) {
                                                         list.get(getIndex()).setC3(Integer.toString(Integer.parseInt(list.get(LESSCTRIncrease).getC3()) - Integer.parseInt(list.get(getIndex()).getC2())));
                                                     }
                                                     commitEdit(textField.getText());
                                                     list.get(LESSCTR-1).setC3(Integer.toString(Integer.parseInt(list.get(LESSCTRIncrease).getC3())+Integer.parseInt(list.get(getIndex()).getC2())));

                                                     if(LESSCTRIncrease!=LESSCTR-1)
                                                         list.get(LESSCTRIncrease).setC3(null);
                                                         LESSCTRIncrease=LESSCTR-1;
                                                     }
                                                 }
                                             }
                                         });
                                     }
                                 }
                             }
                             @Override
                             public void cancelEdit() {
                                 super.cancelEdit();
                                 for(int i=0;i<VAR1;i++) {
                                     if (getIndex() == Integer.parseInt(cellIndexes.get(i))) {
                                         setGraphic(null);
                                     }
                                 }
                                 setGraphic(null);
                             }
                         };
                         return cell;
                     }
                 };
         t2.setOnEditCommit(e ->{
             String str=e.getNewValue();
             int i=table.getSelectionModel().getSelectedIndex();
           //  for(int j=0;j<EMPIndex;j++) {
                 if ((i <= EMPIndex)&&(i>0)) {
                     if (list.get(0).getC4() == null) {
                         Data up = list.get(0);
                         up.setC4(str);
                         list.set(0, up);
                         list.get(TotalSalary).setC3(str);

                     }
                      else {
                         Data up1 = list.get(0);
                         int temp = Integer.parseInt(str) + Integer.parseInt(up1.getC4());
                         up1.setC4(Integer.toString(temp));
                         list.set(0, up1);
                         if(list.get(TotalSalary).getC3()!=null){
                        temp= Integer.parseInt(list.get(TotalSalary).getC3())+Integer.parseInt(str);
                         }
                         else{
                             temp=Integer.parseInt(str);
                         }
                         list.get(TotalSalary).setC3(Integer.toString(temp));
                       //  break;
                     }
                 }
             //}
                 /*if(i==3)
                 {
                     Data up1 = list.get(0);
                     int temp = Integer.parseInt(str) + Integer.parseInt(up1.getC4());
                     up1.setC4(Integer.toString(temp));
                     list.set(0, up1);
                     list.get(TotalSalary).setC3(Integer.toString(temp));
                     //d2.setC3();
                     break;
                 }*/
             Data temp=list.get(i);
             temp.setC2(str);
             list.set(i,temp);
         });
         t2.setCellFactory(cellFactoryFort2);
     }
     public void updateT1(String newValue,int i){
         String str = newValue;
       //  int i=table.getSelectionModel().getSelectedIndex();
         Data newitem = new Data(str, null, null, null);
         list.add(new Data(null, null, null, null));
         SIZE++;
         for (int j = SIZE - 2; j > i; j--) {
             Data temp = list.get(j);
             list.set(j + 1, temp);
         }
         list.set(i, newitem);
         list.set(i + 1, new Data(null, null, null, null));

     }
     public void reverseList(String str,int index)
     {
         emp1List.add(str);
         EMPIndexList.remove(str);
         EMPIndex--;
         Data d1=list.get(index);
         int tmp=Integer.parseInt(list.get(0).getC4())-Integer.parseInt(d1.getC2());
         list.get(0).setC4(Integer.toString(tmp));
         list.get(TotalSalary).setC3(Integer.toString(Integer.parseInt(list.get(TotalSalary).getC3())-Integer.parseInt(d1.getC2())));
         int j;
         for ( j = index; j < SIZE-2; j++) {
             Data temp = list.get(j+1);
             list.set(j , temp);
         }
         SIZE--;
        list.remove(j);

     }
    public void reverseListPROF(String str,int index)
    {
        spbusList.add(str);
        PROFIndexList.remove(str);
        PROFIndex--;
        int j;
        for ( j = index; j < SIZE-2; j++) {
            Data temp = list.get(j+1);
            list.set(j , temp);
        }
        list.remove(j);
        SIZE--;

    }
     public void reverseListDeprec(String str,int index)
     {
         DeprecList.add(str);
         DEPRECIndexList.remove(str);
         DEPRECIndex--;
         int j;
         for ( j = index; j < SIZE-2; j++) {
             Data temp = list.get(j+1);
             list.set(j , temp);
         }
         list.remove(j);
         SIZE--;

     }
     public void reverseListLESS(String str,int index)
     {
         LessdedList.add(str);
         LESSIndexList.remove(str);
         LESSIndex--;
         int j;
         for ( j = index; j < SIZE-2; j++) {
             Data temp = list.get(j+1);
             list.set(j , temp);
         }
         list.remove(j);
         SIZE--;
     }
     public void reverseListOther(String str,int index)
     {
         othersourcesList.add(str);
         OtherIndexList.remove(str);
         OtherIndex--;
         int j;
         for ( j = index; j < SIZE-2; j++) {
             Data temp = list.get(j+1);
             list.set(j , temp);
         }
         list.remove(j);
         SIZE--;


     }
     public void reverseListCHAPTER(String str,int index)
     {
         chapterviaList.add(str);
         ChapterIndexList.remove(str);
         ChapterIndex--;
         int j;
         for ( j = index; j < SIZE-2; j++) {
             Data temp = list.get(j+1);
             list.set(j , temp);
         }
         list.remove(j);
         SIZE--;


     }
     public void reverseListINVEST(String str,int index)
     {
         investList.add(str);
         INVESTIndexList.remove(str);
         INVESTINDEX--;
         int j;
         for ( j = index; j < SIZE-2; j++) {
             Data temp = list.get(j+1);
             list.set(j , temp);
         }
         list.remove(j);
         SIZE--;

     }
     public void reverseListRELIEF(String str,int index)
     {
         reliefList.add(str);
         ReliefIndexList.remove(str);
         REliefIndex--;
         int j;
         for ( j = index; j < SIZE-2; j++) {
             Data temp = list.get(j+1);
             list.set(j , temp);
         }
         list.remove(j);
         SIZE--;
     }
 }

