package platzi.play;

import platzi.play.Platform.User;
import platzi.play.Util.ScannerUtil;
import platzi.play.content.Movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("Hello, This is Platzi Play 🚀");
        System.out.println("========================================================================"+"\n");

        String movieTitle = ScannerUtil.getText("Insert Title");
        String movieDescription = ScannerUtil.getText("Insert Description");
        String movieGenre = ScannerUtil.getText("Insert genre");
        LocalDate movieRealiseYear = ScannerUtil.getDate("Insert realise date");
        double movieDuration = ScannerUtil.getDecimal("Insert Duration");
        double movieRating = ScannerUtil.getDecimal("Insert rating");

        String userName = ScannerUtil.getText("Inser name");
        String userLastName = ScannerUtil.getText("Insert last name");
        int userAge = ScannerUtil.getNumber("Insert Age");
        String userNationality = ScannerUtil.getText("Insert Nationality");
        String userCity = ScannerUtil.getText("Insert city");
        int userPhone = ScannerUtil.getNumber("Insert Phone");
        LocalDateTime userRegisteredDate= LocalDateTime.now();




        Movie movie = new Movie();
        movie.title= movieTitle;
        movie.description = movieDescription;
        movie.genere = movieGenre;
        movie.realiseYear = movieRealiseYear;
        movie.duration = movieDuration;
        movie.rating = movieRating;




        User user = new User();
        user.name = userName;
        user.lastName = userLastName;
        user.age = userAge;
        user.nationality = userNationality;
        user.city = userCity;
        user.phone = userPhone;
        user.registeredDate = userRegisteredDate;

        movie.play();
        user.watch(movie.title);
        System.out.println(movie.getTechnicalSpecification());

        user.getRegisteredDate();









       /*
        System.out.println("========================================================================");

        System.out.println("Hello, This is Platzi Play 🚀");
        System.out.println("========================================================================"+"\n");
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Insert your name: ");
        String name = Scanner.nextLine();
        System.out.println("Insert your age: ");
        int age = Scanner.nextInt();
        Scanner.nextLine();
        System.out.println("Insert your nationality: ");
        String nationality = Scanner.nextLine();
        System.out.println("Which city do you live in: ");
        String city = Scanner.nextLine();
        System.out.println("Hello " + name + " wellcome to Platzi Play" );
        System.out.println("Now we'll recommend to you some +" + age + " movies");
        System.out.println("These are the movies which " + nationality + " loved it");
       */

    }

}
