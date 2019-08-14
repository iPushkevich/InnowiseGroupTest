package validator;

import app.action.BasicAction;
import entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private static Matcher matcher;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern PATTERN = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValidEmail(String s) {
        matcher = PATTERN.matcher(s);

        return matcher.matches();
    }
}
