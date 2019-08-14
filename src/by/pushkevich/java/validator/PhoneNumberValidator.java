package validator;

public class PhoneNumberValidator {

    public static boolean isValidNumber(long number) {
        String tmp = String.valueOf(number);
        if (tmp.startsWith("375") && tmp.length() == 12) return true;
        else return false;
    }
}

