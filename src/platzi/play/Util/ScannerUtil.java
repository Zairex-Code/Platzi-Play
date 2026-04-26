package platzi.play.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ScannerUtil {
    public static Scanner Scanner = new Scanner(System.in);

    public static String getText(String message){
        System.out.println( message + ":");
        return Scanner.nextLine();
    }

    public static int getNumber(String message){
        System.out.println(message + ":");
        int number = Scanner.nextInt();
        Scanner.nextLine();
        return number;
    }

    public static double getDecimal(String message){
        System.out.println(message + ":");
        double decimal = Scanner.nextDouble();
        Scanner.nextLine();
        return decimal;
    }
    public static LocalDate getDate(String message){
        System.out.println(message + ": ");
        System.out.println("- Insert realise year: ");
        int reliseYear = Scanner.nextInt();
        System.out.println("- Insert realise month: ");
        int realiseMonth = Scanner.nextInt();
        System.out.println("- Insert realise day: ");
        int realiseDay = Scanner.nextInt();
        LocalDate localDate = LocalDate.of(reliseYear,realiseMonth,realiseDay);

        return localDate;

    }
}
