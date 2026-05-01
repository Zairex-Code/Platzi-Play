package platzi.play.content;


import java.time.LocalDate;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private Genre genre;
    private LocalDate realiseYear;
    private double duration;
    private double rating;
    private List<Language> languages;
    private List<Quality> qualities;
    private boolean available;


    public Movie(String title, String description, Genre genre, LocalDate realiseYear,  double duration, double rating, List<Language> languages, List<Quality> qualities ){
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.realiseYear = realiseYear;
        this.duration = duration;
        this.rating = rating;
        this.languages = languages;
        this.qualities = qualities;
        this.available = true;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Genre getGenre() {
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

    public List<Language> getLanguage(){return languages;}

    public List<Quality> getQuality(){return  qualities;}

    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenere(Genre genere) {
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
        return """
           ==================================================
            🎬 %s (%d)
           ==================================================
            📌 Genre:     %s
            ⏱️ Duration:  %.0f min
            ⭐ Rating:    %.1f / 5.0
            🗣️ Languages: %s
            📺 Qualities: %s
           --------------------------------------------------
            📝 Synopsis:
            %s
           ==================================================
           """.formatted(
                title,
                realiseYear.getYear(),
                genre,
                duration,
                rating,
                languages,
                qualities,
                description
        );
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
