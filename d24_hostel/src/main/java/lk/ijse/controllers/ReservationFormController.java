package lk.ijse.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.tm.ReservationTM;

import java.util.List;

public class ReservationFormController {


    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<?, ?> dateColm;

    @FXML
    private Button deleteBtn;

    @FXML
    private ComboBox<String> idCmb;

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
    private TableView<ReservationTM> resTbl;

    @FXML
    private TableColumn<?, ?> rmColm;

    @FXML
    private ComboBox<String> rmIdCmb;

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
    private ComboBox<String> stsCmb;

    @FXML
    private TableColumn<?, ?> stsColm;

    @FXML
    private Button svBtn;

    @FXML
    private Button upBtn;
    private final ReservationBO reservationBO = BoFactory.getInstance().getBo(BoFactory.BOTypes.RESERVATION);

    @FXML
    void addNewBtnOnAction(ActionEvent event) {

    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void idCmbOnAction(ActionEvent event) {
        StudentDTO studentDTO=reservationBO.getStd(idCmb.getValue());
        stNameTxt.setText(studentDTO.getName());
    }

    @FXML
    void rmIdCmbOnAction(ActionEvent event) {
        RoomDTO roomDTO = reservationBO.getRoom(rmIdCmb.getValue());
        rmTypeTxt.setText(roomDTO.getType());
        kMnyTxt.setText(roomDTO.getKeyMoney());
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
        setRoomIds();
        setStdId();
        setSts();
    }

    private void setSts() {
        stsCmb.getItems().setAll("Paid", "Not-Paid", "Pending");
    }

    private void setStdId() {
        ObservableList<String> stdIdList = FXCollections.observableArrayList();
        stdIdList.addAll(reservationBO.getStdId());
        idCmb.setItems(stdIdList);
    }

    private void setRoomIds() {
        ObservableList<String> roomIdList = FXCollections.observableArrayList();
        roomIdList.addAll(reservationBO.getRoomIds());
        rmIdCmb.setItems(roomIdList);
    }

    private void fillTable() {
//        ObservableList<ReservationTM> reservationTMS = FXCollections.observableArrayList();
//        for (ReservationDTO reservationDTO : reservationBO.getAllReservation()) {
//            reservationTMS.add(new ReservationTM(
//                    reservationDTO.getResId(),
//                    reservationDTO.getRoomId(),
//                    reservationDTO.getStdId(),
//                    reservationDTO.getStdNameTxt(),
//                    reservationDTO.getDate(),
//                    reservationDTO.getKeyMoney(),
//                    reservationDTO.getSts()
//                    ));
//        }
//        resTbl.setItems(reservationTMS);
    }
}
