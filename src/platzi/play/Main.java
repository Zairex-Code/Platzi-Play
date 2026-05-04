package platzi.play;

import jdk.jfr.ContentType;
import platzi.play.Exception.ExistingContentException;
import platzi.play.Platform.Platform;
import platzi.play.Platform.User;
import platzi.play.Util.FileUtils;
import platzi.play.Util.ScannerUtil;
import platzi.play.content.*;

import java.time.LocalDate;
import java.util.List;

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
        public static final int MOST_VIEWED_MOVIE = 11;
        public static final int REGISTER_NEW_USER = 12;
        public static final int SHOW_ALL_USERS = 13;
        public static final int EXIT = 14;

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
                    11. Most viewed movie
                    12. Register new user
                    13. Show all users
                    14. Exit
                    Select One option""");
            System.out.println("shose option was : " + shoseOption );
            switch (shoseOption){
                case ADD_CONTENT -> {
                    int contentType = ScannerUtil.getNumber("What kind of content would you lile add? \n1.Movie\n2.Documental");
                    String contentTitle = ScannerUtil.getText("Insert Title");
                    String contentDescription = ScannerUtil.getText("Insert Description");
                    Genre contentGenre = ScannerUtil.getGenre("Insert genre");
                    LocalDate contentRealiseYear = ScannerUtil.getDate("Insert realise date");
                    double contentDuration = ScannerUtil.getDecimal("Insert Duration");
                    double contentRating = ScannerUtil.getDecimal("Insert rating");
                    List<Language> contentLanguages = ScannerUtil.getLanguages("Insert language");
                    List<Quality> contentQuality = ScannerUtil.getQualities("Insert qualities");
                    try {
                        if (contentType == 1){
                            Content content = new Movie(contentTitle, contentDescription, contentGenre, contentRealiseYear, contentDuration, contentRating,contentLanguages,contentQuality);
                            platform.addMovie(content);
                            System.out.println("Movie added successfully");

                        } else if (contentType == 2) {
                            String narrator = ScannerUtil.getText("Insert the narrator name");
                            Content content = new Documental(contentTitle, contentDescription, contentGenre, contentRealiseYear, contentDuration, contentRating,contentLanguages,contentQuality,narrator);
                            platform.addMovie(content);
                            System.out.println("Movie added successfully");
                        }else {
                            System.out.println("Invalid option... try again");
                        }
                    }catch (ExistingContentException e){
                        System.out.println(e.getMessage());
                    }

                }
                case SHOW_CONTENT ->  {
                    List<ContentSummary> contentSummaryList = platform.getContentSummary();
                    contentSummaryList.forEach(c -> System.out.println("- "+c.title()));
                }
                case SEARCH_BY_TITLE -> {
                    String title = ScannerUtil.getText("Insert the movie name to search: ");
                    Content content = platform.searchByTitle(title);
                    if (content != null){
                        System.out.println(content.getTechnicalSpecification());
                    }else{
                        System.out.println("Movie doesnt found");
                    }
                }
                case SEARCH_BY_GENRE -> {
                    Genre genre = ScannerUtil.getGenre("Insert the movie genre to search: ");
                    List<Content> contentList = platform.searchByGenre(genre);
                    if (!contentList.isEmpty()) {
                        System.out.println("Movies list with genre: " + genre);
                        contentList.forEach(content -> System.out.println("- " + content.getTechnicalSpecification()));
                    } else {
                        System.out.println("No movies found with genre: " + genre);
                    }

                }
                case GET_POPULAR_MOVIES -> {

                    List<Content> popularMoviesList = platform.getPopularMovies();
                    if (!popularMoviesList.isEmpty()) {
                        System.out.println("Popular movies: ");
                        popularMoviesList.forEach(content -> System.out.println("- " + content.getTechnicalSpecification()));
                    } else {
                        System.out.println("Nothing to show");
                    }
                }
                case GET_VERY_POPULAR_MOVIES -> {
                    List<Content> veryPopularMoviesList = platform.getVeryPopularMovie();
                    if (!veryPopularMoviesList.isEmpty()) {
                        System.out.println("Very popular movies: ");
                        veryPopularMoviesList.forEach(content -> System.out.println("- " + content.getTechnicalSpecification()));
                    } else {
                        System.out.println("Nothing to show");
                    }
                }
                case GET_LONGER_MOVIE -> {
                    List<Content> duratiomContentList = platform.getLongerMovie();
                    Content longerContent = duratiomContentList.stream().findFirst().orElse(null);
                    System.out.println("The longer movie is: " + longerContent.getTechnicalSpecification() +"\n"+ "and its duration is: " + longerContent.getDuration() + " min");
                }
                case GET_SHORTER_MOVIE -> {
                    List<Content> durationContentList = platform.getShorterMovie();
                    Content shorterContent = durationContentList.stream().findFirst().orElse(null);
                    System.out.println("The shorter movie is: " + shorterContent.getTechnicalSpecification() +"\n"+ "and its duration is: " + shorterContent.getDuration() + " min" );
                }
                case PLAY_MOVIE -> {
                    boolean keepAsking = true;
                    while (keepAsking){
                        System.out.println("Select the movie that you would like to play:");
                        List<ContentSummary> contentSummaryList = platform.getContentSummary();
                        contentSummaryList.forEach(movie -> System.out.println("- "+movie.title()));
                        String movieSelected = ScannerUtil.getText("Insert the movie title that you would like to play");
                        Content content = platform.searchByTitle(movieSelected.trim());
                        if (content != null){
                            platform.playing(content);
                            keepAsking = false;
                        }else {
                            System.out.println("Movie doesn't found ");
                        }

                    }


                }
                case MOST_VIEWED_MOVIE -> {
                    Content mostViewedContent =  platform.getMostViewed();
                    int views = platform.getViews(mostViewedContent);
                    System.out.println("The mos viewed movie is " + mostViewedContent.getTitle() + " With " + views);
                }
                case REMOVE -> {
                    String title = ScannerUtil.getText("Insert the movie name to remove: ");
                    Content content = platform.searchByTitle(title);
                    if (content != null){
                        String option = ScannerUtil.getText("Are you sure that you want to remove this movie? Y/N :");
                        if (option.equalsIgnoreCase("y")) {
                            platform.removeMovie(content);
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
        //platform.getContent().addAll(FileUtils.readFile());
        FileUtils.readMoviesFile().forEach(content -> platform.addMovie(content));
        System.out.println("Movies loaded");
    }

    private static void loadUsers(Platform platform){
        FileUtils.readUsersFile().forEach(user -> platform.addUser(user));
        System.out.println("all Users are loaded");


    }

}
