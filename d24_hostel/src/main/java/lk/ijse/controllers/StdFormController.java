package lk.ijse.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Line;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.tm.StudentTM;

public class StdFormController {
    @FXML
    private Button addBtn1;

    @FXML
    private TableColumn<?, ?> addressColm;

    @FXML
    private Line addressLine;

    @FXML
    private TextField addressTxt;

    @FXML
    private TableColumn<?, ?> contactColm;

    @FXML
    private Line contactLine;

    @FXML
    private TextField contactTxt;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<?, ?> dobColm;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private TableColumn<?, ?> genColm;

    @FXML
    private Line genLine;

    @FXML
    private TextField genTxt;

    @FXML
    private TableColumn<?, ?> idColm;

    @FXML
    private Line idLine;

    @FXML
    private TextField idTxt;

    @FXML
    private TableColumn<?, ?> nameColm;

    @FXML
    private Line nameLine;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<StudentTM> stdTbl;

    @FXML
    private Button svBtn;

    @FXML
    private Button upBtn;
    private final StudentBO studentBO=BoFactory.getInstance().getBo(BoFactory.BOTypes.STUDENT);
    @FXML
    void initialize(){
        initUi();
        setCellValueFactory();
        fillTable();
    }

    private void fillTable() {
        ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList();
        for (StudentDTO studentDTO : studentBO.getAll()) {
            System.out.println(studentDTO.getGen());
            studentTMS.add(new StudentTM(
                    studentDTO.getSId(),
                    studentDTO.getName(),
                    studentDTO.getDob(),
                    studentDTO.getContact(),
                    studentDTO.getAddress(),
                    studentDTO.getGen())
            );
        }
        stdTbl.setItems(studentTMS);
    }

    private void setCellValueFactory() {
        idColm.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColm.setCellValueFactory(new PropertyValueFactory<>("name"));
        genColm.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dobColm.setCellValueFactory(new PropertyValueFactory<>("dob"));
        contactColm.setCellValueFactory(new PropertyValueFactory<>("contact"));
        addressColm.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    private void initUi(){
        idTxt.clear();
        nameTxt.clear();
        genTxt.clear();
        dobPicker.setValue(null);
        contactTxt.clear();
        addressTxt.clear();
        idTxt.setDisable(true);
        nameTxt.setDisable(true);
        genTxt.setDisable(true);
        dobPicker.setDisable(true);
        contactTxt.setDisable(true);
        addressTxt.setDisable(true);
        deleteBtn.setDisable(true);
        upBtn.setDisable(true);
        svBtn.setDisable(true);
    }
    @FXML
    void addNewBtnOnAction(ActionEvent event) {
        idTxt.setDisable(false);
        nameTxt.setDisable(false);
        genTxt.setDisable(false);
        dobPicker.setDisable(false);
        contactTxt.setDisable(false);
        addressTxt.setDisable(false);
        idTxt.requestFocus();
        svBtn.setDisable(false);
    }

    @FXML
    void addressTxtOnAction(ActionEvent event) {

    }

    @FXML
    void contactTxtOnAction(ActionEvent event) {
        addressTxt.requestFocus();
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void genTxtOnAction(ActionEvent event) {
        dobPicker.requestFocus();
    }

    @FXML
    void idTxtOnAction(ActionEvent event) {
        nameTxt.requestFocus();
    }

    @FXML
    void nameTxtOnAction(ActionEvent event) {
        genTxt.requestFocus();
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
}
