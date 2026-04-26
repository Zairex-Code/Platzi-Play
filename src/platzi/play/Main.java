package platzi.play;

import platzi.play.Platform.User;
import platzi.play.Util.ScannerUtil;
import platzi.play.content.Movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
        public static final String PLATFORM_NAME = "Platzi Play 🚀";
        public static  final String VERSION = "1.0";

    static void main(String[] args) {

        System.out.println("========================================================================");
        System.out.println(PLATFORM_NAME + "V" + VERSION);
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

        


        Movie movie = new Movie(movieTitle, movieDescription, movieGenre, movieRealiseYear, movieDuration);
        User user = new User(userName,userLastName,userAge,userNationality,userCity,userPhone);

        movie.play();
        user.watch(movie.getTitle());
        System.out.println(movie.getTechnicalSpecification());

        user.getRegisteredDate();






    }

}
