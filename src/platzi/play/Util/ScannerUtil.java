package platzi.play.Util;

import platzi.play.content.Genre;
import platzi.play.content.Language;
import platzi.play.content.Quality;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    public static List<Language> getLanguages(String message){
        boolean keepAsking = true;
        List<Language> languagesList =new ArrayList<>();
        while (keepAsking){
            for (Language language : Language.values()){
                System.out.println("-" + language);
            }
            System.out.println(message+" : ");
            try {
            String languageSelected = SCANNER.nextLine().toUpperCase().trim();

            languagesList.add(Language.valueOf(languageSelected));
                System.out.println("Would you like add another language to this movie? Y/N");
                String option = SCANNER.nextLine();

            if (!option.equalsIgnoreCase("Y")){
                keepAsking = false;
            }

            }catch (Exception e){
                System.out.println("Invalid language. try again please...");
            }


        }
        return languagesList;
    }

    public static List<Quality> getQualities(String message){
        boolean keepAsking = true;
        List<Quality> qualityList = new ArrayList<>();
        while (keepAsking){
            for (Quality quality : Quality.values()){
                System.out.println("-" + quality);
            }
            System.out.println(message+" : ");
            try {
                String qualitySelected = SCANNER.nextLine().toUpperCase().trim();

                qualityList.add(Quality.valueOf(qualitySelected));
                System.out.println("Would you like add another quality to this movie? Y/N");
                String option = SCANNER.nextLine();

                if (!option.equalsIgnoreCase("Y")){
                    keepAsking = false;
                }

            }catch (Exception e){
                System.out.println("Invalid quañity. try again please...");
            }


        }
        return qualityList;
    }



}
