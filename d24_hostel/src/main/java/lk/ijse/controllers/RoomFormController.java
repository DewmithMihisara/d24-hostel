package lk.ijse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class RoomFormController {
    @FXML
    private TableColumn<?, ?> idColm;

    @FXML
    private Text idTxt;

    @FXML
    private TextField keyMoneyTxt;

    @FXML
    private TableColumn<?, ?> kyMoneyColm;

    @FXML
    private Line kyMoneyLine;

    @FXML
    private TableColumn<?, ?> qtyColm;

    @FXML
    private Line qtyLine;

    @FXML
    private TextField qtyTxt;

    @FXML
    private TableView<?> rmTbl;

    @FXML
    private TextField roomIdTxt;

    @FXML
    private Line roomTypeLine;

    @FXML
    private Line roomTypeLine1;

    @FXML
    private TextField roomTypeTxt;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableColumn<?, ?> typeColm;
    @FXML
    void qtyTxtOnAction(ActionEvent event) {
        keyMoneyTxt.requestFocus();
    }

    @FXML
    void roomIdTxtOnAction(ActionEvent event) {
        roomTypeTxt.requestFocus();
    }

    @FXML
    void roomTypeOnAction(ActionEvent event) {
        qtyTxt.requestFocus();
    }
    @FXML
    void searchTxtOnAction(ActionEvent event) {
        searchBtn.fire();
    }
    @FXML
    void searchBtnOnCtion(ActionEvent event) {

    }
    @FXML
    void svBtnOAction(ActionEvent event) {

    }
    @FXML
    void updateBtnOnAction(ActionEvent event) {

    }
    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }
}
