package platzi.play.content;


import java.time.LocalDate;

public class Movie {
    private String title;
    private String description;
    private String genre;
    private LocalDate realiseYear;
    private double duration;
    private double rating;
    private boolean available;

    public Movie(String title, String description, String genre, LocalDate realiseYear, double duration ){
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.realiseYear = realiseYear;
        this.duration = duration;
        this.rating = 0;
        this.available = true;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getRealiseYear() {
        return realiseYear;
    }

    public double getDuration() {
        return duration;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenere(String genere) {
        this.genre = genere;
    }

    public void setRealiseYear(LocalDate realiseYear) {
        this.realiseYear = realiseYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }



    // Methods
    public void play(){
        System.out.println("playing..." + title);
    }



    public String getTechnicalSpecification() {
        return title + " " +realiseYear.getYear() + "\n" +
                "Genre: " + genre + "\n" +
                "Rating: "+rating+"/5";
    }
    public void rate(double rating){
        if (rating>= 0 && rating<=5){
            this.rating = rating;
        }
    }

    public boolean isPopular(){
        return rating >= 4;
    }
}
