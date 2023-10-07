package cz.cvut.fel.trippidy.utility;

public class StringUtility {
    public static String normalizeString(String input) {
        StringBuilder withoutHyphens = new StringBuilder(input.replace("-", ""));

        while (withoutHyphens.length() < 16) {
            withoutHyphens.insert(0, "0");
        }

        return withoutHyphens.toString();
    }
}
