package lk.ijse.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.tm.RoomTM;

public class RoomFormController {
    @FXML
    private Button addBtn1;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<?, ?> idColm;

    @FXML
    private Line idLine;

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
    private TableView<RoomTM> rmTbl;

    @FXML
    private TextField roomIdTxt;

    @FXML
    private Line roomTypeLine;

    @FXML
    private TextField roomTypeTxt;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchTxt;

    @FXML
    private Button svBtn;

    @FXML
    private TableColumn<?, ?> typeColm;

    @FXML
    private Button upBtn;
    private final RoomBO roomBO = BoFactory.getInstance().getBo(BoFactory.BOTypes.ROOM);

    @FXML
    void initialize() {
        initUi();
        setCellValueFactory();
        fillTable();
    }

    private void fillTable() {
        ObservableList<RoomTM> roomTMS = FXCollections.observableArrayList();
        for (RoomDTO roomDTO : roomBO.getAll()) {
            roomTMS.add(new RoomTM(
                    roomDTO.getId(),
                    roomDTO.getType(),
                    roomDTO.getQty(),
                    roomDTO.getKeyMoney())
            );
        }
        rmTbl.setItems(roomTMS);
    }

    private void setCellValueFactory() {
        idColm.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeColm.setCellValueFactory(new PropertyValueFactory<>("type"));
        qtyColm.setCellValueFactory(new PropertyValueFactory<>("qty"));
        kyMoneyColm.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
    }

    private void initUi() {
        roomIdTxt.clear();
        roomTypeTxt.clear();
        qtyTxt.clear();
        keyMoneyTxt.clear();

        roomIdTxt.setDisable(true);
        roomTypeTxt.setDisable(true);
        qtyTxt.setDisable(true);
        keyMoneyTxt.setDisable(true);

        svBtn.setDisable(true);
        upBtn.setDisable(true);
        deleteBtn.setDisable(true);
        searchTxt.requestFocus();
    }

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
    void svBtnOnAction(ActionEvent event) {

    }

    @FXML
    void upBtnOnAction(ActionEvent event) {

    }

    @FXML
    void addNewBtnOnAction(ActionEvent event) {
        roomIdTxt.setDisable(false);
        roomTypeTxt.setDisable(false);
        qtyTxt.setDisable(false);
        keyMoneyTxt.setDisable(false);
        svBtn.setDisable(false);
        idTxt.requestFocus();
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }
}
