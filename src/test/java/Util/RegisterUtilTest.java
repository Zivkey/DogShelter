package Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUtilTest {

    @Test
    void checkPasswordTrue() {
        String pass1 = "123";
        String pass2 = "123";
        Assertions.assertEquals(true, RegisterUtil.checkPassword(pass1, pass2));
    }

    @Test
    void checkPasswordFalse() {
        String pass1 = "321";
        String pass2 = "123";
        Assertions.assertEquals(false, RegisterUtil.checkPassword(pass1, pass2));
    }

    @Test
    void checkPasswordEmptry() {
        String pass1 = "";
        String pass2 = "";
        Assertions.assertEquals(true, RegisterUtil.checkPassword(pass1, pass2));
    }

    @Test
    void passwordIsOkTrue() {
        String pass = "password123";
        Assertions.assertEquals(true, RegisterUtil.passwordIsOk(pass));
    }

    @Test
    void passwordIsOkFalse() {
        String pass = "asd. dsa, ";
        Assertions.assertEquals(false, RegisterUtil.passwordIsOk(pass));
    }

    @Test
    void passwordIsOkEmptry() {
        String pass = "";
        Assertions.assertEquals(false, RegisterUtil.passwordIsOk(pass));
    }


    @Test
    void nameCheckTrue() {
        String name = "Laza";
        Assertions.assertEquals(true, RegisterUtil.nameCheck(name));
    }

    @Test
    void nameCheckFalse() {
        String name = "As";
        Assertions.assertEquals(false, RegisterUtil.nameCheck(name));
    }

    @Test
    void nameCheckEmpty() {
        String name = "";
        Assertions.assertEquals(false, RegisterUtil.nameCheck(name));
    }

    @Test
    void checkAgeTrue() {
        String age = "22";
        Assertions.assertEquals(true, RegisterUtil.checkAge(age));
    }

    @Test
    void checkAgeFalse() {
        String age = "13";
        Assertions.assertEquals(false, RegisterUtil.checkAge(age));
    }

    @Test
    void checkAgeEmpty() {
        String age = "";
        Assertions.assertEquals(false, RegisterUtil.checkAge(age));
    }
}