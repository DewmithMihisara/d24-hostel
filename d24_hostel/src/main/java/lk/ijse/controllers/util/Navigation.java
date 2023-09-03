package lk.ijse.controllers.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Navigation {
    private static AnchorPane root;
    public static void navigation(Rout rout,AnchorPane root) throws IOException {
        Navigation.root = root;
        Navigation.root.getChildren().clear();
        Stage window = (Stage) Navigation.root.getScene().getWindow();
        switch (rout) {
            case LOGIN -> initUi("logInForm.fxml");
            case SIGN_UP -> initUi("signUpForm.fxml");
            case DASH_BOARD -> initUi("dashBoardForm.fxml");
            case HOME -> initUi("homeForm.fxml");
            case SETTINGS -> initUi("settingsForm.fxml");
            case ROOMS -> initUi("roomForm.fxml");
            case STUDENT -> initUi("stdForm.fxml");
            case RESERVATION -> initUi("reservationForm.fxml");
        }
    }
    private static void initUi(String location) throws IOException {
        Navigation.root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(Navigation.class.getResource("/views/" + location))));
    }
}
