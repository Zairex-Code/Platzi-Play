package platzi.play;

import platzi.play.Platform.Platform;
import platzi.play.Platform.User;
import platzi.play.Util.ScannerUtil;
import platzi.play.content.Genre;
import platzi.play.content.Movie;

import java.time.Duration;
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
        public static final int GET_POPULAR_MOVIES = 5;
        public static final int GET_VERY_POPULAR_MOVIES = 6;
        public static final int GET_LONGER_MOVIE = 7;
        public static final int GET_SHORTER_MOVIE = 8;
        public static final int REMOVE = 9;
        public static final int REGISTER_NEW_USER = 10;
        public static final int SHOW_ALL_USERS = 11;
        public static final int EXIT = 12;

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
                    5. get popular movies
                    6. get very popular movies
                    7. get longer movie
                    8. get shorter movie
                    9. Remove
                    10. Register new user
                    11. Show all users
                    12. Exit
                    Select One option""");
            System.out.println("shose option was : " + shoseOption );
            switch (shoseOption){
                case ADD_CONTENT -> {
                    String movieTitle = ScannerUtil.getText("Insert Title");
                    String movieDescription = ScannerUtil.getText("Insert Description");
                    Genre movieGenre = ScannerUtil.getGenre("Insert genre");
                    LocalDate movieRealiseYear = ScannerUtil.getDate("Insert realise date");
                    double movieDuration = ScannerUtil.getDecimal("Insert Duration");
                    double movieRating = ScannerUtil.getDecimal("Insert rating");
                    Movie movie = new Movie(movieTitle, movieDescription, movieGenre, movieRealiseYear, movieDuration, movieRating);
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
                    Genre genre = ScannerUtil.getGenre("Insert the movie genre to search: ");
                    List<Movie> movieList = platform.searchByGenre(genre);
                    if (!movieList.isEmpty()) {
                        System.out.println("Movies list with genre: " + genre);
                        movieList.forEach(movie -> System.out.println("- " + movie.getTechnicalSpecification()));
                    } else {
                        System.out.println("No movies found with genre: " + genre);
                    }

                }
                case GET_POPULAR_MOVIES -> {

                    List<Movie> popularMoviesList = platform.getPopularMovies();
                    if (!popularMoviesList.isEmpty()) {
                        System.out.println("Popular movies: ");
                        popularMoviesList.forEach(movie -> System.out.println("- " + movie.getTechnicalSpecification()));
                    } else {
                        System.out.println("Nothing to show");
                    }
                }
                case GET_VERY_POPULAR_MOVIES -> {
                    List<Movie> veryPopularMoviesList = platform.getVeryPopularMovie();
                    if (!veryPopularMoviesList.isEmpty()) {
                        System.out.println("Very popular movies: ");
                        veryPopularMoviesList.forEach(movie -> System.out.println("- " + movie.getTechnicalSpecification()));
                    } else {
                        System.out.println("Nothing to show");
                    }
                }
                case GET_LONGER_MOVIE -> {
                    List<Movie> duratiomMovieList = platform.getLongerMovie();
                    Movie longerMovie = duratiomMovieList.stream().findFirst().orElse(null);
                    System.out.println("The longer movie is: " + longerMovie.getTechnicalSpecification() +"\n"+ "and its duration is: " + longerMovie.getDuration() + " min");
                }
                case GET_SHORTER_MOVIE -> {
                    List<Movie> durationMovieList = platform.getShorterMovie();
                    Movie shorterMovie = durationMovieList.stream().findFirst().orElse(null);
                    System.out.println("The shorter movie is: " + shorterMovie.getTechnicalSpecification() +"\n"+ "and its duration is: " + shorterMovie.getDuration() + " min" );
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
    private static void loadMovies(Platform platform) {
        platform.addMovie(new Movie("Shrek", "An ogre rescues a princess to get his swamp back.", Genre.ANIMATION, LocalDate.of(2001, 5, 18), 90.0, 4.2));
        platform.addMovie(new Movie("Inception", "A dream thief seeks to plant an idea into a subconscious.", Genre.SCIENCE_FICTION, LocalDate.of(2010, 7, 16), 148.0, 4.6));
        platform.addMovie(new Movie("Titanic", "Two young people from different social classes fall in love on the famous ship.", Genre.DRAMA, LocalDate.of(1997, 12, 19), 195.0, 3.0));
        platform.addMovie(new Movie("John Wick", "A retired assassin seeks revenge for the death of his dog.", Genre.ACTION, LocalDate.of(2014, 10, 24), 101.0, 2.0));
        platform.addMovie(new Movie("The Conjuring", "Paranormal investigators help a family on a farmhouse.", Genre.HORROR, LocalDate.of(2013, 7, 19), 112.0, 4.1));
        platform.addMovie(new Movie("Coco", "A boy travels to the Land of the Dead to discover his legacy.", Genre.ANIMATION, LocalDate.of(2017, 10, 27), 105.0, 5.0));
        platform.addMovie(new Movie("Interstellar", "Explorers travel through a wormhole to save humanity.", Genre.SCIENCE_FICTION, LocalDate.of(2014, 11, 7), 169.0, 3.5));
        platform.addMovie(new Movie("Joker", "A failed comedian descends into madness in Gotham City.", Genre.DRAMA, LocalDate.of(2019, 10, 4), 122.0, 3.6));
        platform.addMovie(new Movie("Toy Story", "A boy's toys come to life when he is not around.", Genre.ANIMATION, LocalDate.of(1995, 11, 22), 81.0, 4.3));
        platform.addMovie(new Movie("Avengers: Endgame", "The heroes try to reverse the damage caused by Thanos.", Genre.ACTION, LocalDate.of(2019, 4, 26), 181.0, 3.8));
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
