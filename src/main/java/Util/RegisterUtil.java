package Util;

import DataBase.UserController;
import Entities.User;

import java.util.List;

public class RegisterUtil {
    public static boolean checkPassword(String one, String two) {
        if (one.equals(two)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean passwordIsOk(String password) {
        char [] array = password.toCharArray();
        if (array.length < 5) {
            return false;
        }
        for (char x : array) {
            if (!Character.isLetterOrDigit(x)) {
                return false;
            }
        }
        return true;
    }

    public static boolean emailCheck(String email) {
        List<User> users = UserController.readUsers();
        String mail = email;
        for (User x : users) {
            if (x.getEmail().equals(mail)) {
                return false;
            }
        }
        if (mail.contains("@gmail.com")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean nameCheck(String name) {
        if (name.length() > 2) {
            return true;
        }
        return false;
    }

    public static boolean checkAge(String age) {
        if (age.length() > 0) {
            if (WordUtil.onlyNumbers(age)) {
                if (Integer.parseInt(age) > 17 && Integer.parseInt(age) < 120) {
                    return true;
                }
            }
        }
        return false;
    }

}
