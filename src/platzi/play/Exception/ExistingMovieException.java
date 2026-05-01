package platzi.play.Exception;

// We create a mew exception if the name already exist
public class ExistingMovieException extends RuntimeException{
    public ExistingMovieException(String title){
        super("Error trying add "+title + " because this movie is already existing...");
    }
}

