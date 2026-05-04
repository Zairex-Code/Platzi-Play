package platzi.play.Exception;

// We create a mew exception if the name already exist
public class ExistingContentException extends RuntimeException{
    public ExistingContentException(String title){
        super("Error trying add "+title + " because this content is already existing...");
    }
}

