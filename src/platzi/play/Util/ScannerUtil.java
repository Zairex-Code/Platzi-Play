package platzi.play.Util;

import platzi.play.content.Genre;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ScannerUtil {
    public static final Scanner SCANNER = new Scanner(System.in);


    public static String getText(String message){
        System.out.println( message + ":");
        return SCANNER.nextLine();
    }

    public static int getNumber(String message){
        System.out.println(message + ":");
        while(!SCANNER.hasNextInt()){
            System.out.println("Invalid option select a valid option:");
            SCANNER.next();
        }
        int number = SCANNER.nextInt();
        SCANNER.nextLine();
        return number;
    }

    public static double getDecimal(String message){
        System.out.println(message + ":");
        while(!SCANNER.hasNextDouble()){
            System.out.println("Invalid option select a valid option:");
            SCANNER.next();
        }
        double decimal = SCANNER.nextDouble();
        SCANNER.nextLine();
        return decimal;
    }
    public static LocalDate getDate(String message){
        System.out.println(message + ": ");
        System.out.println("- Insert realise year: ");
        int reliseYear = SCANNER.nextInt();
//
        System.out.println("- Insert realise month: ");
        int realiseMonth = SCANNER.nextInt();
//       }
        System.out.println("- Insert realise day: ");
        int realiseDay = SCANNER.nextInt();


//
        LocalDate localDate = LocalDate.of(reliseYear,realiseMonth,realiseDay);
        System.out.println(localDate);

        return localDate;

    }
    public static Genre getGenre(String message){
        while (true){
                System.out.println(message + ": ");
                for (Genre genre : Genre.values()){
                    System.out.println("-"+genre);
                }
            String option = SCANNER.nextLine();
            try {
                return Genre.valueOf(option.toUpperCase());
            }catch (Exception e){
                System.out.println("Invalid genre selected.");
                System.out.println("Select one valid Genre: ");
            }
        }

    }
}
