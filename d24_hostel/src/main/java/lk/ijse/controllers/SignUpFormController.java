package lk.ijse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.controllers.util.CustomAlert;
import lk.ijse.controllers.util.Navigation;
import lk.ijse.controllers.util.Rout;
import lk.ijse.controllers.util.Validation;
import lk.ijse.dto.UserDTO;

import java.io.IOException;

public class SignUpFormController {
    @FXML
    private PasswordField pwTxt;

    @FXML
    private Button pwViewBtn;

    @FXML
    private PasswordField rePwTxt;

    @FXML
    private Button rePwViewBtn;

    @FXML
    private AnchorPane root;

    @FXML
    private Button signInBtn;

    @FXML
    private TextField userNameTxt;

    @FXML
    private Line usrNameLine;

    @FXML
    private Line rePwLine;
    @FXML
    private Line pwLine;

    @FXML
    private ImageView viewImg;

    @FXML
    private ImageView viewImg1;
    boolean usr,pw,rePw;
    private final UserBo userBo= BoFactory.getInstance().getBo(BoFactory.BOTypes.USER);
    @FXML
    void userNameTxtOnAction(ActionEvent event) {
        pwTxt.requestFocus();
    }

    @FXML
    void pwTxtOnAction(ActionEvent event) {
        rePwTxt.requestFocus();
    }

    @FXML
    void rePwTxtOnAction(ActionEvent event) {
        signInBtn.fire();
    }

    @FXML
    void pwViewBtnOnAction(ActionEvent event) {

    }

    @FXML
    void rePwViewBtnOnAction(ActionEvent event) {

    }
    @FXML
    void backBtnOnAction(ActionEvent event) {
        try {
            Navigation.navigation(Rout.LOGIN,root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void signInBtnOnAction(ActionEvent event) {
        usrValidation();
        if (usr && pw && rePw){
            boolean save= userBo.saveUser(new UserDTO(userNameTxt.getText(),pwTxt.getText()));
            if (save){
                new CustomAlert(Alert.AlertType.CONFIRMATION,"Save ","Saved !","Save successful !").show();
                userNameTxt.setText("");
                pwTxt.setText("");
                rePwTxt.setText("");
            }else {
                new CustomAlert(Alert.AlertType.ERROR,"Save ","Not Saved !","Save not successful !").show();
            }
        }
    }

    private void usrValidation() {
        usr=false;
        pw=false;
        rePw=false;
        usr= Validation.txtValidation(userNameTxt,usrNameLine);
        pw=Validation.pwValidation(pwTxt,pwLine);
        rePw=Validation.pwValidation(rePwTxt,rePwLine);
        if (!pwTxt.getText().equals(rePwTxt.getText())){
            Validation.shakeLine(pwLine);
            Validation.shakeLine(rePwLine);
        }else {
            Validation.defaultLine(pwLine);
            Validation.defaultLine(rePwLine);
        }
    }
}
