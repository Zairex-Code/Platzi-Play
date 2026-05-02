package platzi.play.Util;

import platzi.play.Platform.Platform;
import platzi.play.content.Genre;
import platzi.play.content.Language;
import platzi.play.content.Movie;
import platzi.play.content.Quality;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
        public static final String fileName = "movies.txt";
        public static final String separator = "|";
    public static List<Movie> readFile(){
        List<Movie> movieFromFile = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            lines.forEach(line -> {
                String[] data = line.split("\\" + separator);
                String title = data[0];
                String description = data[1];
                Genre genre = Genre.valueOf(data[2]);
                LocalDate realiseDate = LocalDate.parse(data[3]);
                double duration = Double.parseDouble(data[4]);
                double rate = Double.parseDouble(data[5]);
                List<Language> language = Arrays.stream(data[6].split(",")).map(Language::valueOf).toList();
                List<Quality> quality = Arrays.stream(data[7].split(",")).map(Quality::valueOf).toList();

                Movie movie = (new Movie(title,description,genre,realiseDate,duration,rate,language,quality));
                movieFromFile.add(movie);



            });

        }catch (IOException e){
            System.out.println("Error to read the file" + e.getMessage());
        }
        return movieFromFile;
    }
}
// Coco|Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather.|ANIMATION|2017-11-22|105.0|4.8|ENGLISH,SPANISH|HD_720P,FHD_1080P,UHD_4K