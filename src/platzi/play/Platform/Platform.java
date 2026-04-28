package platzi.play.Platform;

import platzi.play.content.Movie;
import java.util.ArrayList;
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
        for (User user : users) {
            ++counter;
            System.out.println(counter + ". "+ user.getName());
        }
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
        System.out.println();
    }




}
