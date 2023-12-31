package lk.ijse.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import lk.ijse.configaration.SessionFactoryConfig;
import lk.ijse.controllers.util.Navigation;
import lk.ijse.controllers.util.Rout;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeFormController implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private Label loadingLbl;

    @FXML
    private Rectangle fullLoadingBar;
    @FXML
    private Rectangle loadingBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    private void init() {
        Thread printThread = new Thread(() -> {
            SessionFactoryConfig.getInstance().getSession();
        });
        printThread.start();

        Timeline timeline = new Timeline();

        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(2500), actionEvent -> {
            loadingBar.setWidth(fullLoadingBar.getWidth() * 0.2);
        });

        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(3000), actionEvent -> {
            loadingLbl.setText("Loading Internal Resources....");
            loadingBar.setWidth(fullLoadingBar.getWidth() * 0.5);
        });
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(3500), actionEvent -> {
            loadingLbl.setText("Loading Images....");
            loadingBar.setWidth(fullLoadingBar.getWidth() * 0.6);
        });
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(4000), actionEvent -> {
            loadingLbl.setText("Loading UIs....");
            loadingBar.setWidth(fullLoadingBar.getWidth() * 0.8);
        });
        KeyFrame keyFrame5 = new KeyFrame(Duration.millis(4500), actionEvent -> {
            loadingLbl.setText("Welcome to D-24 v1.0.0");
            loadingBar.setWidth(fullLoadingBar.getWidth());
        });
        KeyFrame keyFrame6 = new KeyFrame(Duration.millis(5000), actionEvent -> {
            try {
                Navigation.navigation(Rout.LOGIN,pane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        timeline.getKeyFrames().addAll(keyFrame1, keyFrame2, keyFrame3, keyFrame4, keyFrame5, keyFrame6);
        timeline.playFromStart();
    }
}
