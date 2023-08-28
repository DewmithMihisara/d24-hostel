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
import lk.ijse.controllers.util.Navigation;
import lk.ijse.controllers.util.Rout;

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

    @FXML
    void loginBtnOnAction(ActionEvent event) {

    }

    @FXML
    void pwTxtOnAction(ActionEvent event) {

    }

    @FXML
    void pwViewBtnOnAction(ActionEvent event) {

    }

    @FXML
    void signUpBtnOnAction(ActionEvent event) throws IOException {
        Navigation.navigation(Rout.SIGN_UP,root);
    }

    @FXML
    void userNameTxtOnAction(ActionEvent event) {

    }

}
