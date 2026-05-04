package platzi.play.content;

import java.time.LocalDate;
import java.util.List;

public class Movie extends Content {
    public Movie(String title, String description, Genre genre, LocalDate realiseYear, double duration, double rating, List<Language> languages, List<Quality> qualities) {
        super(title, description, genre, realiseYear, duration, rating, languages, qualities);
    }
}
