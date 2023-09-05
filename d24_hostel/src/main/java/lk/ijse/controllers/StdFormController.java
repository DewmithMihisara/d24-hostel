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
import lk.ijse.controllers.util.CustomAlert;
import lk.ijse.controllers.util.Validation;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.tm.StudentTM;

import java.sql.Date;

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
    private Button searchBtn;

    @FXML
    private TableView<StudentTM> stdTbl;

    @FXML
    private Button svBtn;

    @FXML
    private Button upBtn;
    private final StudentBO studentBO=BoFactory.getInstance().getBo(BoFactory.BOTypes.STUDENT);
    boolean id, name, gen, dob, contact, address;
    @FXML
    void initialize(){
        initUi();
        setCellValueFactory();
        fillTable();
    }

    private void fillTable() {
        ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList();
        for (StudentDTO studentDTO : studentBO.getAll()) {
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
    void contactTxtOnAction(ActionEvent event) {
        addressTxt.requestFocus();
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
        String sid=searchTxt.getText();
        StudentDTO studentDTO=studentBO.getStudent(sid);
        if (studentDTO!=null){
            svBtn.setDisable(true);
            upBtn.setDisable(false);
            deleteBtn.setDisable(false);
            idTxt.setDisable(true);
            nameTxt.setDisable(false);
            genTxt.setDisable(false);
            dobPicker.setDisable(false);
            contactTxt.setDisable(false);
            addressTxt.setDisable(false);
            idTxt.requestFocus();

            idTxt.setText(studentDTO.getSId());
            nameTxt.setText(studentDTO.getName());
            genTxt.setText(studentDTO.getGen());
            dobPicker.setValue(studentDTO.getDob().toLocalDate());
            contactTxt.setText(studentDTO.getContact());
            addressTxt.setText(studentDTO.getAddress());
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Error ","Invalid","Invalid student id !").show();
        }
        searchTxt.clear();
    }
    @FXML
    void searchTxtOnAction(ActionEvent event) {
        searchBtn.fire();
    }
    @FXML
    void svBtnOnAction(ActionEvent event) {
        validate();
        if (studentBO.saveStd(new StudentDTO(idTxt.getText(),nameTxt.getText(),addressTxt.getText(),contactTxt.getText(),Date.valueOf(dobPicker.getValue()),genTxt.getText()))){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Student Update successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        }
    }

    @FXML
    void upBtnOnAction(ActionEvent event) {
        validate();
        if (studentBO.updateStd(new StudentDTO(idTxt.getText(),nameTxt.getText(),addressTxt.getText(),contactTxt.getText(),Date.valueOf(dobPicker.getValue()),genTxt.getText()))){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Update ","Updated !","Student Update successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Update ","Not Update !","Update not successful !").show();
        }
    }
    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        if (studentBO.deleteStd(idTxt.getText())){
            new CustomAlert(Alert.AlertType.CONFIRMATION,"Delete ","Deleted !","Student Deleted successful !").show();
            fillTable();
            initUi();
        }else {
            new CustomAlert(Alert.AlertType.ERROR,"Delete ","Not Deleted !","Delete not successful !").show();
        }
    }
    private void validate() {
        id=false;
        name=false;
        gen=false;
        dob=false;
        contact=false;
        address=false;
        id= Validation.txtValidation(idTxt,idLine);
        name=Validation.txtValidation(nameTxt,nameLine);
        gen=Validation.txtValidation(genTxt,genLine);
        dob=Validation.dateValidation(dobPicker);
        contact=Validation.txtValidation(contactTxt,contactLine);
        address=Validation.txtValidation(addressTxt,addressLine);
    }
}
