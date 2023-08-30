package lk.ijse.controllers.util;

import animatefx.animation.Shake;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
public class Validation {
    static Shake shake;
    public static boolean txtValidation(TextField txt, Line line) {
        if (txt.getText().matches("^$")) {
            shakeLine(line);
        } else {
            defaultLine(line);
            return true;
        }
        return false;
    }
    static void shakeLine(Line line){
        line.setStroke(Color.RED);
        shake=new Shake(line);
        shake.setOnFinished(actionEvent -> {
            defaultLine(line);
        });
        shake.play();
    }
    static void defaultLine(Line line){
        line.setStroke(Color.BLACK);
    }
}
