package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    private static final String NUMBER_PATTERN = "^375\\d{2}\\s\\d{7}";

    private static final Pattern PATTERN = Pattern.compile(NUMBER_PATTERN);

    public static boolean isValidNumber(String number) {
        Matcher matcher = PATTERN.matcher(number);
        return matcher.matches();
    }
}

