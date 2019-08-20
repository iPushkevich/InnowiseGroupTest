package app.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleInput {
    private static Scanner scanner = new Scanner(System.in);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt() {
        if (scanner.hasNextInt()) return scanner.nextInt();
        System.out.println("Ошибка! Введите целое число");
        scanner.next();
        scanner.close();
        return getInt();
    }

    public static String getString() {
        String s = null;

        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
