package platzi.play.Platform;

import platzi.play.content.Movie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Platform {
    private String platformName;
    private List<Movie> content;
    private List<User> users;


    public Platform(String platformName){
        this.platformName = platformName;
        this.content = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    public void addMovie(Movie movie){
        this.content.add(movie);
    }
    public void removeMovie(Movie movie){
        this.content.remove(movie);
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public void removeUser(User user){
        this.users.remove(user);
    }

    public void showUsersList(){
        int counter = 0;
        System.out.println("All Movies availables: ");
        for (User user : users) {
            ++counter;
            System.out.println(counter + ". "+ user.getName());
        }
        System.out.println("");
    }

    public String getName(){
        return platformName;
    }
    public List<Movie> getContent(){
        return this.content;
    }

    public void showTitlesList(){
        int counter = 0;

        System.out.println("All Movies availables: ");

        for (Movie movie : content) {
           ++counter;
           System.out.println(counter+". "+movie.getTitle());
      }
    }
    public void getTotalDuration(){
        double hoursContent = content.stream().mapToDouble(content -> content.getDuration()).sum();
        System.out.println("🖥" +hoursContent + " of content" );
    }

    // This function orders all movies from higher to lower
    public List<Movie> getPopularMovies() {
        return content.stream().sorted(Comparator.comparingDouble(Movie::getRating).reversed()).toList();
    }

    public List<Movie> getVeryPopularMovie(){
        return  content.stream().filter(movie -> movie.getRating() > 4).toList();
    }

    public List<Movie> getLongerMovie(){
        return content.stream().sorted(Comparator.comparingDouble(Movie::getDuration).reversed()).toList();
    }
    public List<Movie> getShorterMovie(){
        return content.stream().sorted(Comparator.comparingDouble(Movie::getDuration)).toList();
    }
    public Movie searchByTitle(String Title){
//        for (Movie movie: content){
//            if (movie.getTitle().equalsIgnoreCase(Title)){
//                return movie;
//            }
//
//        }
        //We can do the sale as the before for
        return content.stream()
                .filter(content -> content.getTitle().equalsIgnoreCase(Title))
                .findFirst()
                .orElse(null);



    }
    public List<Movie> searchByGenre(String genre){
        return content.stream().
                filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .toList();
    }





}
