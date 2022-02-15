package pl.adrian_komuda.manipulate_volume_object;

import java.util.Locale;

public class TestUtils {
    public static boolean TEST_FLAG = false;

    public static String changeSnakeCaseToCamelCase(String string) {
        String[] words = string.split("_");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase(Locale.ROOT))
                    .append(word.substring(1));
        }
        return result.toString();
    }

    public static String changeSnakeCaseToUpperCase(String string) {
        return string.toUpperCase(Locale.ROOT);
    }
}