package lk.ijse.controllers.util;

import animatefx.animation.Shake;
import javafx.scene.control.PasswordField;
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
    public static boolean pwValidation(PasswordField pwTxt, Line line) {
        if (pwTxt.getText().matches("^$")) {
            shakeLine(line);
        } else {
            defaultLine(line);
            return true;
        }
        return false;
    }
    public static void shakeLine(Line line){
        line.setStroke(Color.RED);
        shake=new Shake(line);
        shake.setOnFinished(actionEvent -> {
            defaultLine(line);
        });
        shake.play();
    }
    public static void defaultLine(Line line){
        line.setStroke(Color.BLACK);
    }

}
