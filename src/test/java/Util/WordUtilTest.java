package Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordUtilTest {

    @Test
    void onlyNumbersTrue() {
        String word = "123";
        Assertions.assertEquals(true, WordUtil.onlyNumbers(word));
    }

    @Test
    void onlyNumbersFalse() {
        String word = "12cbs25";
        Assertions.assertEquals(false, WordUtil.onlyNumbers(word));
    }

    @Test
    void onlyNumbersEmpty() {
        String word = "";
        Assertions.assertEquals(false, WordUtil.onlyNumbers(word));
    }
}