package platzi.play.Util;

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
}
