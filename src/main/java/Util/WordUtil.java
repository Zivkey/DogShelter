package Util;

public class WordUtil {
    public static boolean onlyNumbers(String s) {
        char [] array = s.toCharArray();
        if (array.length == 0) {
            return false;
        }
        for (char x : array) {
            if (!Character.isDigit(x)) {
                return false;
            }
        }
        return true;
    }
}
