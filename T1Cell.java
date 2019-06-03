
/*
rol.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class testController implements Initializable {

    @FXML
    private TableColumn<Account, String> usernameCol;

    @FXML
    private TableColumn<Account, String> balanceCol;

    @FXML
    private TableView<Account> accountTable;

    @FXML
    private TableColumn<Account, String> bookieCol;

    @FXML
    private TableColumn<Account, String> passwordCol;

    private ObservableList<Account> dataList =
            FXCollections.observableArrayList(
                    new Account("bookie", "username", "password", "0"));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Callback<TableColumn, TableCell> cellFactory =
                new Callback<TableColumn, TableCell>() {
                    public TableCell call(TableColumn p) {
                        return new EditingCell();
                    }
                };

        bookieCol.setCellValueFactory(
                new PropertyValueFactory<>("fieldBookie"));

        usernameCol.setCellValueFactory(
                new PropertyValueFactory<>("fieldUsername"));

        usernameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Account, String>>() {
                    @Override public void handle(TableColumn.CellEditEvent<Account, String> t) {
                        ((Account)t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setFieldUsername(t.getNewValue());
                    }
                });

        passwordCol.setCellValueFactory(
                new PropertyValueFactory<Account, String>("fieldPassword"));

        balanceCol.setCellValueFactory(
                new PropertyValueFactory<Account, String>("fieldBalance"));

        accountTable.setItems(dataList);

    }

    class EditingCell extends TableCell<Account, String> {

        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }

            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.selectAll();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText(String.valueOf(getItem()));
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(textField);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                } else {
                    setText(getString());
                    setContentDisplay(ContentDisplay.TEXT_ONLY);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.setOnKeyPressed(t -> {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(textField.getText());
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem();
        }
    }
}
*/