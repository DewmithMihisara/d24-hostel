package lk.ijse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import lk.ijse.controllers.util.Validation;

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
    private Line usrNameLine1;

    @FXML
    private Line usrNameLine2;

    @FXML
    private ImageView viewImg;

    @FXML
    private ImageView viewImg1;
    boolean usr,pw,rePw;
    {
        usr=false;
        pw=false;
        rePw=false;
    }
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
    void signInBtnOnAction(ActionEvent event) {
        usr= Validation.txtValidation(userNameTxt,usrNameLine);
    }
}
