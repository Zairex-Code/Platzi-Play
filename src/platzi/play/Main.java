package platzi.play;

import platzi.play.Platform.Platform;
import platzi.play.Platform.User;
import platzi.play.Util.ScannerUtil;
import platzi.play.content.Movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static final String PLATFORM_NAME = "Platzi Play 🚀";
        public static  final String VERSION = "1.0";
        public static final int ADD_CONTENT = 1;
        public static final int SHOW_CONTENT = 2;
        public static final int SEARCH_BY_TITLE = 3;
        public static final int SEARCH_BY_GENRE = 4;
        public static final int REMOVE = 5;
        public static final int REGISTER_NEW_USER = 6;
        public static final int SHOW_ALL_USERS = 7;
        public static final int EXIT = 8;

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
        loadMovies(platform);
        loadUsers(platform);


        while (true){
            int shoseOption = ScannerUtil.getNumber("""
                    1. Add Content
                    2. Show all content
                    3. Search by title
                    4. Search by Genre
                    5. Remove
                    6. Register new user
                    7. Show all users
                    8. Exit
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
                    String title = ScannerUtil.getText("Insert the movie name to search: ");
                    Movie movie = platform.searchByTitle(title);
                    if (movie != null){
                        System.out.println(movie.getTechnicalSpecification());
                    }else{
                        System.out.println("Movie doesnt found");
                    }
                }
                case SEARCH_BY_GENRE -> {
                    String genre = ScannerUtil.getText("Insert the movie genre to search: ");
                    List<Movie> movieList = platform.searchByGenre(genre);
                    if (!movieList.isEmpty()) {
                        System.out.println("Movies list with genre: " + genre);
                        movieList.forEach(movie -> System.out.println("- " + movie.getTechnicalSpecification()));
                    } else {
                        System.out.println("No movies found with genre: " + genre);
                    }

                }
                case REMOVE -> {
                    String title = ScannerUtil.getText("Insert the movie name to remove: ");
                    Movie movie = platform.searchByTitle(title);
                    if (movie != null){
                        String option = ScannerUtil.getText("Are you sure that you want to remove this movie? Y/N :");
                        if (option.equalsIgnoreCase("y")) {
                            platform.removeMovie(movie);
                            System.out.println("Movie removed successfully");
                        }
                    }else{
                        System.out.println("Movie doesnt found");
                    }
                }
                case REGISTER_NEW_USER -> {
                    String userName = ScannerUtil.getText("Insert name");
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


    }
    private static void loadMovies(Platform platform){
            platform.addMovie(new Movie("Shrek", "Un ogro rescata a una princesa para recuperar su pantano.", "Animada", LocalDate.of(2001, 5, 18), 90.0));
            platform.addMovie(new Movie("Inception", "Un ladrón de sueños busca implantar una idea en un subconsciente.", "Ciencia Ficción", LocalDate.of(2010, 7, 16), 148.0));
            platform.addMovie(new Movie("Titanic", "Dos jóvenes de distintas clases sociales se enamoran en el famoso barco.", "Drama", LocalDate.of(1997, 12, 19), 195.0));
            platform.addMovie(new Movie("John Wick", "Un asesino retirado busca venganza por la muerte de su perro.", "Acción", LocalDate.of(2014, 10, 24), 101.0));
            platform.addMovie(new Movie("El Conjuro", "Investigadores paranormales ayudan a una familia en una granja.", "Terror", LocalDate.of(2013, 7, 19), 112.0));
            platform.addMovie(new Movie("Coco", "Un niño viaja al mundo de los muertos para descubrir su legado.", "Animada", LocalDate.of(2017, 10, 27), 105.0));
            platform.addMovie(new Movie("Interstellar", "Exploradores viajan por un agujero de gusano para salvar la humanidad.", "Ciencia Ficción", LocalDate.of(2014, 11, 7), 169.0));
            platform.addMovie(new Movie("Joker", "Un comediante fallido desciende a la locura en Gotham City.", "Drama", LocalDate.of(2019, 10, 4), 122.0));
            platform.addMovie(new Movie("Toy Story", "Los juguetes de un niño cobran vida cuando él no está presente.", "Animada", LocalDate.of(1995, 11, 22), 81.0));
            platform.addMovie(new Movie("Avengers: Endgame", "Los héroes intentan revertir el daño causado por Thanos.", "Acción", LocalDate.of(2019, 4, 26), 181.0));

    }

    private static void loadUsers(Platform platform){
        platform.addUser(new User("James", "Miller", 28, "American", "New York", 21255501));
        platform.addUser(new User("Emily", "Wilson", 34, "British", "London", 20794601));
        platform.addUser(new User("Oliver", "Brown", 22, "Canadian", "Toronto", 41655502));
        platform.addUser(new User("Sophie", "Taylor", 45, "Australian", "Sydney", 29212443));
        platform.addUser(new User("Liam", "Smith", 30, "Irish", "Dublin", 16654321));
        platform.addUser(new User("Emma", "Johnson", 26, "American", "Los Angeles", 31055503));
        platform.addUser(new User("Noah", "Davis", 31, "American", "Chicago", 31255504));
        platform.addUser(new User("Isabella", "White", 29, "British", "Manchester", 16149602));
        platform.addUser(new User("Lucas", "Anderson", 40, "Canadian", "Vancouver", 60455505));
        platform.addUser(new User("Mia", "Thompson", 24, "American", "Seattle", 20655506));

    }

}
