package lk.ijse.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.tm.RoomTM;

public class ReservationFormController {


    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<?, ?> dateColm;

    @FXML
    private Button deleteBtn;

    @FXML
    private ComboBox<?> idCmb;

    @FXML
    private Line idLine;

    @FXML
    private TextField idTxt;

    @FXML
    private Text kMnyTxt;

    @FXML
    private TableColumn<?, ?> kyMoneyColm;

    @FXML
    private TableColumn<?, ?> reIdColm;

    @FXML
    private TableView<?> resTbl;

    @FXML
    private TableColumn<?, ?> rmColm;

    @FXML
    private ComboBox<?> rmIdCmb;

    @FXML
    private Text rmTypeTxt;

    @FXML
    private TextField roomIdTxt;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableColumn<?, ?> stIdColm;

    @FXML
    private TableColumn<?, ?> stNameColm;

    @FXML
    private Text stNameTxt;

    @FXML
    private ComboBox<?> stsCmb;

    @FXML
    private TableColumn<?, ?> stsColm;

    @FXML
    private Button svBtn;

    @FXML
    private Button upBtn;

    @FXML
    void addNewBtnOnAction(ActionEvent event) {

    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void idCmbOnAction(ActionEvent event) {

    }

    @FXML
    void rmIdCmbOnAction(ActionEvent event) {

    }

    @FXML
    void roomIdTxtOnAction(ActionEvent event) {

    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {

    }

    @FXML
    void searchTxtOnAction(ActionEvent event) {

    }

    @FXML
    void svBtnOnAction(ActionEvent event) {

    }

    @FXML
    void upBtnOnAction(ActionEvent event) {

    }
    @FXML
    void initialize(){
        fillTable();
    }
    private void fillTable() {
//        ObservableList<RoomTM> roomTMS = FXCollections.observableArrayList();
//        for (RoomDTO roomDTO : roomBO.getAll()) {
//            roomTMS.add(new RoomTM(
//                    roomDTO.getId(),
//                    roomDTO.getType(),
//                    roomDTO.getQty(),
//                    roomDTO.getKeyMoney())
//            );
//        }
//        rmTbl.setItems(roomTMS);
    }
}
