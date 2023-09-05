package lk.ijse.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.controllers.util.CustomAlert;
import lk.ijse.controllers.util.Validation;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.tm.RoomTM;

import java.sql.Date;

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
    boolean id, type, qty, keyMoney;
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
        String rid=searchTxt.getText();
        RoomDTO roomDTO=roomBO.getRoom(rid);
        if (roomDTO!=null){
            svBtn.setDisable(true);
            upBtn.setDisable(false);
            deleteBtn.setDisable(false);
            roomIdTxt.setDisable(true);
            roomTypeTxt.setDisable(false);
            qtyTxt.setDisable(false);
            keyMoneyTxt.setDisable(false);

            roomIdTxt.setText(roomDTO.getId());
            roomTypeTxt.setText(roomDTO.getType());
            qtyTxt.setText(String.valueOf(roomDTO.getQty()));
            keyMoneyTxt.setText(roomDTO.getKeyMoney());
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Error ","Invalid","Invalid Room id !").show();
        }
        searchTxt.clear();
    }

    @FXML
    void svBtnOnAction(ActionEvent event) {
        validation();
        if (roomBO.saveRoom(new RoomDTO(roomIdTxt.getText(),roomTypeTxt.getText(),Integer.parseInt(qtyTxt.getText()),keyMoneyTxt.getText()))){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Room Update successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        }
    }

    @FXML
    void upBtnOnAction(ActionEvent event) {
        validation();
        if (roomBO.updateRoom(new RoomDTO(roomIdTxt.getText(),roomTypeTxt.getText(),Integer.parseInt(qtyTxt.getText()),keyMoneyTxt.getText()))){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Student Update successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        }
    }
    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        if (roomBO.deleteRoom(roomIdTxt.getText())){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Delete ","Deleted !","Room Deleted successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Deleted !","Delete not successful !").show();
        }
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
    private void validation() {
        id=false;
        type=false;
        qty=false;
        keyMoney=false;
        id= Validation.txtValidation(roomIdTxt,idLine);
        type=Validation.txtValidation(roomTypeTxt,roomTypeLine);
        qty=Validation.txtValidation(qtyTxt,qtyLine);
        keyMoney=Validation.txtValidation(keyMoneyTxt,kyMoneyLine);
    }
}
