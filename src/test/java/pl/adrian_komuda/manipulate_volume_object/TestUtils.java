package pl.adrian_komuda.manipulate_volume_object;

import java.util.Locale;

public class TestUtils {
    public static boolean TEST_FLAG = false;

    public static String changeSnakeCaseToUpperCase(String string) {
        return string.toUpperCase(Locale.ROOT);
    }
}