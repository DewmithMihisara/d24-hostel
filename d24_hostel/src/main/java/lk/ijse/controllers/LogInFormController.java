package lk.ijse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.controllers.util.Navigation;
import lk.ijse.controllers.util.Rout;
import lk.ijse.controllers.util.Validation;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.io.IOException;

public class LogInFormController {
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView viewImg;
    @FXML
    private Button loginBtn;

    @FXML
    private Line pwLine;

    @FXML
    private PasswordField pwTxt;

    @FXML
    private Button pwViewBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField userNameTxt;

    @FXML
    private Line usrNameLine;
    private final UserBo userBo = BoFactory.getInstance().getBo(BoFactory.BOTypes.USER);
    boolean pw, usr;
    public static String Gl0bUsrName;
    @FXML
    void loginBtnOnAction(ActionEvent event) {
        validation();
        if (usr && pw ){
            UserDTO isUser=userBo.getUser(new UserDTO(userNameTxt.getText(),pwTxt.getText()));
            if (isUser!=null){
                Gl0bUsrName=userNameTxt.getText();

                if (pwTxt.getText().equals(isUser.getPassword())){
                    try {
                        Navigation.navigation(Rout.DASH_BOARD,root);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    Validation.shakeLine(pwLine);
                }
            }else {
                Validation.shakeLine(usrNameLine);
                Validation.shakeLine(pwLine);
            }
        }
    }

    @FXML
    void pwTxtOnAction(ActionEvent event) {
        loginBtn.fire();
    }

    @FXML
    void pwViewBtnOnAction(ActionEvent event) {
    }

    @FXML
    void signUpBtnOnAction(ActionEvent event)  {
        try {
            Navigation.navigation(Rout.SIGN_UP, root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void userNameTxtOnAction(ActionEvent event) {
        pwTxt.requestFocus();
    }

    private void validation() {
        pw = false;
        usr = false;
        usr = Validation.txtValidation(userNameTxt, usrNameLine);
        pw = Validation.pwValidation(pwTxt, pwLine);
    }
}
