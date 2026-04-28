package platzi.play;

import platzi.play.Platform.Platform;
import platzi.play.Platform.User;
import platzi.play.Util.ScannerUtil;
import platzi.play.content.Movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
        public static final String PLATFORM_NAME = "Platzi Play 🚀";
        public static  final String VERSION = "1.0";
        public static final int ADD_CONTENT = 1;
        public static final int SHOW_CONTENT = 2;
        public static final int SEARCH_BY_TITLE = 3;
        public static final int REMOVE = 4;
        public static final int REGISTER_NEW_USER = 5;
        public static final int SHOW_ALL_USERS = 6;
        public static final int EXIT = 7;

    static void main(String[] args) {

        System.out.println("========================================================================");
        System.out.println(PLATFORM_NAME + "V" + VERSION);
        System.out.println("========================================================================"+"\n");
        // 1. Add content
        // 2. Show all content
        // 3. search by title
        // 4. remove
        // 5. Exit


        Platform platform = new Platform(PLATFORM_NAME);


        while (true){
            int shoseOption = ScannerUtil.getNumber("""
                    1. Add Content
                    2. Show all content
                    3. Search by title
                    4. Remove
                    5. Register new user
                    6. Show all users
                    7. Exit
                    Select One option: 
                    """);
            System.out.println("shose option was : " + shoseOption );
            switch (shoseOption){
                case ADD_CONTENT -> {
                    String movieTitle = ScannerUtil.getText("Insert Title");
                    String movieDescription = ScannerUtil.getText("Insert Description");
                    String movieGenre = ScannerUtil.getText("Insert genre");
                    LocalDate movieRealiseYear = ScannerUtil.getDate("Insert realise date");
                    double movieDuration = ScannerUtil.getDecimal("Insert Duration");
                    double movieRating = ScannerUtil.getDecimal("Insert rating");
                    Movie movie = new Movie(movieTitle, movieDescription, movieGenre, movieRealiseYear, movieDuration);
                    platform.addMovie(movie);
                    System.out.println("Movie added successfully");
                }
                case SHOW_CONTENT ->  platform.showTitlesList();
                case SEARCH_BY_TITLE -> {
                    // pending
                }
                case REMOVE -> {
                    while (true){
                        platform.showTitlesList();
                        int option = ScannerUtil.getNumber("Select the movie that you want to remove");
                        //platform.removeMovie(content[option]);
                    }
                }
                case REGISTER_NEW_USER -> {
                    String userName = ScannerUtil.getText("Inser name");
                    String userLastName = ScannerUtil.getText("Insert last name");
                    int userAge = ScannerUtil.getNumber("Insert Age");
                    String userNationality = ScannerUtil.getText("Insert Nationality");
                    String userCity = ScannerUtil.getText("Insert city");
                    int userPhone = ScannerUtil.getNumber("Insert Phone");
                    User user = new User(userName,userLastName,userAge,userNationality,userCity,userPhone);
                    platform.addUser(user);
                    System.out.println("User added successfully");
                }
                case SHOW_ALL_USERS -> platform.showUsersList();
                case  EXIT -> System.exit(0);
            }


        }


//
//
//        platform.addMovie(movie);
//
//
//        switch ()
//        movie.play();
//        user.watch(movie.getTitle());
//        System.out.println("This platform contain "+platform.getContent().size() + "Movies");
//        platform.showTitlesList();
//        platform.removeMovie(movie3);
//        platform.showTitlesList();
//
//        System.out.println(movie.getTechnicalSpecification());
//
//        user.getRegisteredDate();
//





    }

}
