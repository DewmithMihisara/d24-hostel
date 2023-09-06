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
    private static int round=0;
    @FXML
    void setingBtn(ActionEvent event) {
        try {
            switch (round) {
                case 0 -> {
                    Navigation.navigation(Rout.SETTINGS, setingPane);
                    round = 1;
                }
                case 1 -> {
                    setingPane.getChildren().clear();
                    round = 0;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
