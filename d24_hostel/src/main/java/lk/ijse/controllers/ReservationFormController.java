package lk.ijse.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.controllers.util.CustomAlert;
import lk.ijse.controllers.util.Navigation;
import lk.ijse.controllers.util.Rout;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.tm.ReservationTM;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
    private DatePicker dtPicketr;
    @FXML
    private Button searchBtn;
    @FXML
    private ComboBox<String> rmIdCmb;
    @FXML
    private TableColumn<?, ?> epireDtColm;


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
        dtPicketr.setDisable(false);
        idCmb.setDisable(false);
        rmIdCmb.setDisable(false);
        stsCmb.setDisable(false);
        svBtn.setDisable(false);
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        if (reservationBO.deleteRes(idTxt.getText())) {
            new CustomAlert(Alert.AlertType.CONFIRMATION, "Delete ", "Deleted !", "Reservation Deleted successful !").show();
            fillTable();
            initUi();
        } else {
            new CustomAlert(Alert.AlertType.ERROR, "Delete ", "Not Deleted !", "Delete not successful !").show();
        }
    }

    @FXML
    void idCmbOnAction(ActionEvent event) {
        StudentDTO studentDTO = reservationBO.getStd(idCmb.getValue());
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
        String rid = searchTxt.getText();
        ReservationDTO reservationDTO = reservationBO.getResevertion(rid);
        if (reservationDTO != null) {
            svBtn.setDisable(true);
            upBtn.setDisable(false);
            deleteBtn.setDisable(false);
            stsCmb.setDisable(true);
            idCmb.setDisable(true);
            rmIdCmb.setDisable(true);

            idCmb.getSelectionModel().select(getCmbIndex(idCmb, reservationDTO.getStdId()));
            rmIdCmb.getSelectionModel().select(getCmbIndex(rmIdCmb, reservationDTO.getRoomId()));
            stsCmb.getSelectionModel().select(getCmbIndex(stsCmb, reservationDTO.getSts()));
            idTxt.setText(reservationDTO.getResId());
            dtPicketr.setValue(reservationDTO.getDate().toLocalDate());
        } else {
            new CustomAlert(Alert.AlertType.ERROR, "Error ", "Invalid", "Invalid Room id !").show();
        }
        searchTxt.clear();
    }

    int getCmbIndex(ComboBox<String> cmb, String value) {
        List<String> cmbList = cmb.getItems();
        for (int i = 0; i < cmbList.size(); i++) {
            if (cmbList.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @FXML
    void searchTxtOnAction(ActionEvent event) {
        searchBtn.fire();
    }

    @FXML
    void svBtnOnAction(ActionEvent event) {
        if (reservationBO.saveRes(new ReservationDTO(idTxt.getText(), Date.valueOf(dtPicketr.getValue()), idCmb.getValue(), rmIdCmb.getValue(), stsCmb.getValue(), stNameTxt.getText(), rmTypeTxt.getText(), kMnyTxt.getText()))) {
            new CustomAlert(Alert.AlertType.CONFIRMATION, "Save ", "Saved !", "Reservation Update successful !").show();
            fillTable();
        } else {
            new CustomAlert(Alert.AlertType.ERROR, "Update ", "Not Update !", "Update not successful !").show();
        }
    }

    @FXML
    void upBtnOnAction(ActionEvent event) {
        if (reservationBO.updateRes(new ReservationDTO(idTxt.getText(), Date.valueOf(dtPicketr.getValue()), idCmb.getValue(), rmIdCmb.getValue(), stsCmb.getValue(), stNameTxt.getText(), rmTypeTxt.getText(), kMnyTxt.getText()))) {
            new CustomAlert(Alert.AlertType.CONFIRMATION, "Update ", "Updated !", "Student Update successful !").show();
            fillTable();
            initUi();
        } else {
            new CustomAlert(Alert.AlertType.ERROR, "Update ", "Not Update !", "Update not successful !").show();
        }
    }

    @FXML
    void initialize() {
        fillTable();
        setRoomIds();
        setStdId();
        setSts();
        initUi();
        setValueFactory();
    }

    private void initUi() {
//        idTxt.setDisable(true);
        dtPicketr.setDisable(true);
        idCmb.setDisable(true);
        rmIdCmb.setDisable(true);
        stsCmb.setDisable(true);
        svBtn.setDisable(true);
        upBtn.setDisable(true);
        deleteBtn.setDisable(true);

        dtPicketr.setValue(null);
        idCmb.setValue(null);
        rmIdCmb.setValue(null);
        stsCmb.setValue(null);
    }

    private void setValueFactory() {
        reIdColm.setCellValueFactory(new PropertyValueFactory<>("resId"));
        stIdColm.setCellValueFactory(new PropertyValueFactory<>("stdId"));
        rmColm.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        stNameColm.setCellValueFactory(new PropertyValueFactory<>("stdName"));
        kyMoneyColm.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        dateColm.setCellValueFactory(new PropertyValueFactory<>("date"));
        epireDtColm.setCellValueFactory(new PropertyValueFactory<>("exDate"));
        stsColm.setCellValueFactory(new PropertyValueFactory<>("sts"));
    }

    private void setSts() {
        stsCmb.getItems().setAll("Paid", "Not-Paid");
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
        ObservableList<ReservationTM> reservationTMS = FXCollections.observableArrayList();
        for (ReservationDTO reservationDTO : reservationBO.getAllReservation()) {
            reservationTMS.add(new ReservationTM(
                    reservationDTO.getResId(),
                    reservationDTO.getRoomId(),
                    reservationDTO.getStdId(),
                    reservationDTO.getStdNameTxt(),
                    reservationDTO.getDate(),
                    reservationDTO.getKeyMoney(),
                    reservationDTO.getSts(),
                    genarateExpDate(reservationDTO.getDate().toLocalDate())
            ));
        }
        resTbl.setItems(reservationTMS);
    }

    private Date genarateExpDate(LocalDate date) {
        LocalDate genDate = date.plusMonths(1);
        return Date.valueOf(genDate);
    }
}
