package Util;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MessageUtil {

    /**
     * Metoda koja proverava da li je naslov poruke veci od 4 karaktera
     * @param messageField Naslov te poruke
     * @return Da li je naslov poruke duzi od 4 karaktera
     */

    public static boolean titleCheck(TextField messageField) {
        if (messageField.getText().length() > 4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metoda koja proverava da li je duzina poruke veca od 20 karaktera
     * @param messageText Text te poruke
     * @return Da li je poruka duza od 20 karaktera
     */

    public static boolean textCheck(TextArea messageText) {
        if (messageText.getText().length() > 20) {
            return true;
        } else {
            return false;
        }
    }
}
