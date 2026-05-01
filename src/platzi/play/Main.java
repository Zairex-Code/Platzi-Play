package platzi.play;

import platzi.play.Exception.ExistingMovieException;
import platzi.play.Platform.Platform;
import platzi.play.Platform.User;
import platzi.play.Util.ScannerUtil;
import platzi.play.content.*;

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
        public static final int PLAY_MOVIE = 10;
        public static final int REGISTER_NEW_USER = 11;
        public static final int SHOW_ALL_USERS = 12;
        public static final int EXIT = 13;

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
                    10. Play movie
                    11. Register new user
                    12. Show all users
                    13. Exit
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
                    List<Language> movieLanguages = ScannerUtil.getLanguages("Insert language");
                    List<Quality> movieQuality = ScannerUtil.getQualities("Insert qualities");
                    try {
                    Movie movie = new Movie(movieTitle, movieDescription, movieGenre, movieRealiseYear, movieDuration, movieRating,movieLanguages,movieQuality);
                    platform.addMovie(movie);
                    System.out.println("Movie added successfully");
                    }catch (ExistingMovieException e){
                        System.out.println(e.getMessage());
                    }

                }
                case SHOW_CONTENT ->  {
                    List<ContentSummary> contentSummaryList = platform.getContentSummary();
                    contentSummaryList.forEach(c -> System.out.println("- "+c.title()));
                }
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
                case PLAY_MOVIE -> {
                    boolean keepAsking = true;
                    while (keepAsking){
                        System.out.println("Select the movie that you would like to play:");
                        List<ContentSummary> contentSummaryList = platform.getContentSummary();
                        contentSummaryList.forEach(movie -> System.out.println("- "+movie.title()));
                        String movieSelected = ScannerUtil.getText("Insert the movie title that you would like to play");
                        Movie movie = platform.searchByTitle(movieSelected.trim());
                        if (movie != null){
                            platform.playing(movie);
                            keepAsking = false;
                        }else {
                            System.out.println("Movie doesn't found ");
                        }

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
    private static void loadMovies(Platform platform) {
        platform.addMovie(new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea.", Genre.SCIENCE_FICTION, LocalDate.of(2010, 7, 16), 148.0, 4.8, List.of(Language.ENGLISH, Language.SPANISH, Language.FRENCH), List.of(Quality.FHD_1080P, Quality.UHD_4K)));
        platform.addMovie(new Movie("Pulp Fiction", "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", Genre.DRAMA, LocalDate.of(1994, 10, 14), 154.0, 4.9, List.of(Language.ENGLISH), List.of(Quality.HD_720P, Quality.FHD_1080P)));
        platform.addMovie(new Movie("The Lord of the Rings: The Fellowship of the Ring", "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth.", Genre.FANTASY, LocalDate.of(2001, 12, 19), 178.0, 4.9, List.of(Language.ENGLISH, Language.SPANISH), List.of(Quality.FHD_1080P, Quality.UHD_4K)));
        platform.addMovie(new Movie("Fight Club", "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.", Genre.DRAMA, LocalDate.of(1999, 10, 15), 139.0, 4.8, List.of(Language.ENGLISH, Language.GERMAN), List.of(Quality.HD_720P, Quality.FHD_1080P)));
        platform.addMovie(new Movie("Forrest Gump", "The presidencies of Kennedy and Johnson, the Vietnam War, and other events unfold from the perspective of an Alabama man with an IQ of 75.", Genre.DRAMA, LocalDate.of(1994, 7, 6), 142.0, 4.8, List.of(Language.ENGLISH, Language.SPANISH, Language.FRENCH), List.of(Quality.SD_480P, Quality.FHD_1080P)));
        platform.addMovie(new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", Genre.DRAMA, LocalDate.of(1972, 3, 24), 175.0, 5.0, List.of(Language.ENGLISH, Language.ITALIAN), List.of(Quality.HD_720P, Quality.FHD_1080P, Quality.UHD_4K)));
        platform.addMovie(new Movie("Jurassic Park", "A pragmatic paleontologist touring an almost complete theme park on an island in Central America is tasked with protecting a couple of kids.", Genre.ADVENTURE, LocalDate.of(1993, 6, 11), 127.0, 4.7, List.of(Language.ENGLISH, Language.SPANISH), List.of(Quality.HD_720P, Quality.FHD_1080P, Quality.UHD_4K)));
        platform.addMovie(new Movie("Titanic", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", Genre.ROMANCE, LocalDate.of(1997, 12, 19), 194.0, 4.6, List.of(Language.ENGLISH, Language.SPANISH, Language.FRENCH), List.of(Quality.SD_480P, Quality.HD_720P, Quality.FHD_1080P)));
        platform.addMovie(new Movie("The Avengers", "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army.", Genre.ACTION, LocalDate.of(2012, 5, 4), 143.0, 4.5, List.of(Language.ENGLISH, Language.SPANISH), List.of(Quality.HD_720P, Quality.FHD_1080P, Quality.UHD_4K)));
        platform.addMovie(new Movie("Toy Story", "A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him as top toy in a boy's room.", Genre.ANIMATION, LocalDate.of(1995, 11, 22), 81.0, 4.8, List.of(Language.ENGLISH, Language.SPANISH, Language.FRENCH), List.of(Quality.SD_480P, Quality.HD_720P, Quality.FHD_1080P)));
        platform.addMovie(new Movie("Gladiator", "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.", Genre.ACTION, LocalDate.of(2000, 5, 5), 155.0, 4.7, List.of(Language.ENGLISH, Language.SPANISH), List.of(Quality.HD_720P, Quality.FHD_1080P, Quality.UHD_4K)));
        platform.addMovie(new Movie("Back to the Future", "Marty McFly, a 17-year-old high school student, is accidentally sent thirty years into the past in a time-traveling DeLorean.", Genre.SCIENCE_FICTION, LocalDate.of(1985, 7, 3), 116.0, 4.8, List.of(Language.ENGLISH, Language.SPANISH), List.of(Quality.SD_480P, Quality.HD_720P, Quality.FHD_1080P)));
        platform.addMovie(new Movie("The Lion King", "Lion prince Simba and his father are targeted by his bitter uncle, who wants to ascend the throne himself.", Genre.ANIMATION, LocalDate.of(1994, 6, 24), 88.0, 4.8, List.of(Language.ENGLISH, Language.SPANISH, Language.FRENCH), List.of(Quality.SD_480P, Quality.HD_720P, Quality.FHD_1080P)));
        platform.addMovie(new Movie("Avatar", "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.", Genre.SCIENCE_FICTION, LocalDate.of(2009, 12, 18), 162.0, 4.5, List.of(Language.ENGLISH, Language.SPANISH), List.of(Quality.HD_720P, Quality.FHD_1080P, Quality.UHD_4K)));
        platform.addMovie(new Movie("Coco", "Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather.", Genre.ANIMATION, LocalDate.of(2017, 11, 22), 105.0, 4.8, List.of(Language.ENGLISH, Language.SPANISH), List.of(Quality.HD_720P, Quality.FHD_1080P, Quality.UHD_4K)));
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
