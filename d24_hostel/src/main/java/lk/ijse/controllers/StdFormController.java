package lk.ijse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class StdFormController {
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
    private TableColumn<?, ?> dobColm;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private ComboBox<?> genBox;

    @FXML
    private TableColumn<?, ?> genColm;

    @FXML
    private TableColumn<?, ?> idColm;

    @FXML
    private Text idTxt;

    @FXML
    private TableColumn<?, ?> nameColm;

    @FXML
    private Line nameLine;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<?> stdTbl;

    @FXML
    void addressTxtOnAction(ActionEvent event) {

    }

    @FXML
    void contactTxtOnAction(ActionEvent event) {

    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void nameTxtOnAction(ActionEvent event) {

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

}
