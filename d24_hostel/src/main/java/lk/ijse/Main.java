package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.ijse.configaration.SessionFactoryConfig;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/views/dashBoardForm.fxml")));
        stage.setScene(scene);
        stage.setTitle("D-24");
        stage.getIcons().add(new Image("/assets/d23_logo.png"));
        stage.centerOnScreen();
//        stage.setResizable(false);
        stage.show();
    }
}