package platzi.play.content;

import java.time.LocalDate;
import java.util.List;

public class Documental extends Content{
    private String narrator;
    public Documental(String title, String description, Genre genre, LocalDate realiseYear, double duration, double rating, List<Language> languages, List<Quality> qualities , String narrator ) {
        super(title, description, genre, realiseYear, duration, rating, languages, qualities);
        this.narrator = narrator;
    }

    public String getNarrator() {
        return narrator;
    }
}
