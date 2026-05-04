package platzi.play.Platform;

import platzi.play.Exception.ExistingContentException;
import platzi.play.Util.FileUtils;
import platzi.play.content.*;

import java.util.*;

public class Platform {
    private String platformName;
    private List<Content> content;
    private List<User> users;
    private Map<Content,Integer> views;


    public Platform(String platformName){
        this.platformName = platformName;
        this.content = new ArrayList<>();
        this.users = new ArrayList<>();
        this.views = new HashMap<>();
    }
    public void addMovie(Content content){
        Content searchContent = this.searchByTitle(content.getTitle());
        if (searchContent != null){
            throw new ExistingContentException(content.getTitle());
        }else {
            FileUtils.addMovieToFile(content);
            this.content.add(content);
        }


    }
    public void removeMovie(Content content){
        this.content.remove(content);
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public void removeUser(User user){
        this.users.remove(user);
    }
    public int getViews(Content content) {
        return views.getOrDefault(content, 0);
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
    public List<Content> getContent(){
        return this.content;
    }

    public void showTitlesList(){
        int counter = 0;

        System.out.println("All Movies availables: ");

        for (Content content : this.content) {
           ++counter;
           System.out.println(counter+". "+ content.getTitle());
      }
    }

    public List<ContentSummary> getContentSummary(){
        return content.stream()
                .map(content ->new ContentSummary(content.getTitle(), content.getDuration(), content.getGenre()))
                .toList();
    }
    public void getTotalDuration(){
        double hoursContent = content.stream().mapToDouble(content -> content.getDuration()).sum();
        System.out.println("🖥" +hoursContent + " of content" );
    }

    // This function orders all movies from higher to lower
    public List<Content> getPopularMovies() {
        return content.stream().sorted(Comparator.comparingDouble(Content::getRating).reversed()).toList();
    }

    public List<Content> getVeryPopularMovie(){
        return  content.stream().filter(content -> content.getRating() > 4).toList();
    }

    public List<Content> getLongerMovie(){
        return content.stream().sorted(Comparator.comparingDouble(Content::getDuration).reversed()).toList();
    }
    public List<Content> getShorterMovie(){
        return content.stream().sorted(Comparator.comparingDouble(Content::getDuration)).toList();
    }
    public Content searchByTitle(String Title){
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
    public List<Content> searchByGenre(Genre genre){
        return content.stream().
                filter(content -> content.getGenre().equals(genre))
                .toList();
    }
    public void playing(Content content){
        int currentViews = views.getOrDefault(content, 0);
        System.out.println(content.getTitle() + " has been played " + currentViews + " times");
        this.counterViews(content);
        content.play();


    }
    public void counterViews(Content content) {
        int currentViews = getViews(content);
        views.put(content, currentViews + 1);
    }

    public Content getMostViewed(){
        List<Content> contentList = content.stream().sorted(Comparator.comparingInt(content -> this.getViews(content))).toList().reversed();
        Content mostViewed = contentList.stream().findFirst().orElse(null);
        return mostViewed;
    }

    public List<Movie> getMovies(){
        return content.stream()
                .filter(content -> content instanceof Movie)
                .map(filererdContent -> (Movie) filererdContent).toList();
    }

    public  List<Documental> getDocumentals(){
        return content.stream()
                .filter(content -> content instanceof Documental)
                .map(filteredContent -> (Documental) filteredContent).toList();
    }

}
