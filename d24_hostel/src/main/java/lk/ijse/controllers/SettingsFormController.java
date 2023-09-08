package lk.ijse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.controllers.util.CustomAlert;
import lk.ijse.controllers.util.Validation;
import lk.ijse.dto.UserDTO;

public class SettingsFormController {
    @FXML
    private Button checkBtn;

    @FXML
    private Line newPwLine;

    @FXML
    private PasswordField newPwTxt;

    @FXML
    private Button newPwViewBtn;

    @FXML
    private Line oldPwLine;

    @FXML
    private TextField oldPwTxt;

    @FXML
    private Line pwLine;

    @FXML
    private Button rPwViewBtn;

    @FXML
    private PasswordField reEntrPw;

    @FXML
    private Button svBtn;

    @FXML
    private ImageView viewImg1;

    @FXML
    private ImageView viewImg11;
    private final UserBo userBo = BoFactory.getInstance().getBo(BoFactory.BOTypes.USER);

    @FXML
    void initialize(){
        initUi();
        oldPwLine.requestFocus();
    }

    private void initUi() {
        reEntrPw.setDisable(true);
        newPwTxt.setDisable(true);
        svBtn.setDisable(true);
    }

    @FXML
    void checkBtnOnActon(ActionEvent event) {
        if (!oldPwTxt.getText().equals("")){
            if (userBo.getUser(new UserDTO(LogInFormController.Gl0bUsrName,oldPwTxt.getText()))){
                reEntrPw.setDisable(false);
                svBtn.setDisable(false);
                newPwTxt.setDisable(false);
                newPwTxt.requestFocus();
            }else{
                new CustomAlert(Alert.AlertType.ERROR,"Invalid","Invalid Password!","password is wrong. Try again !").show();
            }
        }else {
            Validation.shakeLine(oldPwLine);
        }
    }

    @FXML
    void newPwTxtOnAction(ActionEvent event) {
        reEntrPw.requestFocus();
    }

    @FXML
    void newPwViewBtnOnAction(ActionEvent event) {

    }

    @FXML
    void oldPwTxtOnAction(ActionEvent event) {
        checkBtn.fire();
    }
    @FXML
    void reEntrPwOnAction(ActionEvent event) {
        svBtn.fire();
    }

    @FXML
    void svBtnOAction(ActionEvent event) {
        if(Validation.pwValidation(reEntrPw,pwLine) && Validation.pwValidation(newPwTxt,newPwLine)){
            if (userBo.uptdUsr(new UserDTO(LogInFormController.Gl0bUsrName,newPwTxt.getText()))){
                new CustomAlert(Alert.AlertType.CONFIRMATION,"Save ","Saved !","Save successful !").show();
                initUi();
            }else {
                new CustomAlert(Alert.AlertType.ERROR,"Save ","Not Saved !","Save not successful !").show();
            }
        }
    }

    @FXML
    void rPwViewBtnOnAction(ActionEvent event) {

    }
}
