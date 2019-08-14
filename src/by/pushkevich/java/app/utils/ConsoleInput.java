package app.utils;

import java.util.*;

public class ConsoleInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        if (scanner.hasNextInt()) return scanner.nextInt();
        System.out.println("Ошибка! Введите целое число");
        scanner.next();
        return getInt();
    }

    public static String getString() {
        return scanner.next();
    }

    public static long getLong() {
        if (scanner.hasNextLong()) return scanner.nextLong();
        System.out.println("Ошибка! Введите целое число");
        scanner.next();
        return getLong();
    }


}
