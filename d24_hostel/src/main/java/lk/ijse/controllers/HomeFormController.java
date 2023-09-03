package lk.ijse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.controllers.util.Navigation;
import lk.ijse.controllers.util.Rout;

import java.io.IOException;

public class HomeFormController {
    @FXML
    private AnchorPane setingPane;
    @FXML
    void setingBtn(ActionEvent event) {
        try {
            Navigation.navigation(Rout.SETTINGS,setingPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
