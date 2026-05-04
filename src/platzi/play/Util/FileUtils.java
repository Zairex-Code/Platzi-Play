package platzi.play.Util;

import platzi.play.Platform.User;
import platzi.play.content.*;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
        public static final String contentFileName = "Content.txt";
        public static final String usersFileName = "users.txt";
        public static final String separator = "|";


    public static List<Content> readContentFile(){
        List<Content> contentFromFile = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(contentFileName));

            lines.forEach(line -> {
                String[] data = line.split("\\" + separator);
                String contentType = data[0];

                if (contentType.equals("MOVIE") || contentType.equals("DOCUMENTAL")){
                    String title = data[1];
                    String description = data[2];
                    Genre genre = Genre.valueOf(data[3]);
                    LocalDate realiseDate = LocalDate.parse(data[4]);
                    double duration = Double.parseDouble(data[5]);
                    double rate = Double.parseDouble(data[6]);

                    // Limpiamos corchetes y espacios antes de hacer el split
                    List<Language> language = Arrays.stream(data[7].replace("[", "").replace("]", "").replace(" ", "").split(","))
                            .map(Language::valueOf).toList();
                    List<Quality> quality = Arrays.stream(data[8].replace("[", "").replace("]", "").replace(" ", "").split(","))
                            .map(Quality::valueOf).toList();

                    // SEPARAMOS LA LÓGICA AQUÍ
                    if (contentType.equals("MOVIE")){
                        Content content = new Movie(title,description,genre,realiseDate,duration,rate,language,quality);
                        contentFromFile.add(content);
                    } else {
                        // Solo buscamos data[9] si estamos 100% seguros de que es un documental
                        String narrator = data[9];
                        Content content = new Documental(title,description,genre,realiseDate,duration,rate,language,quality,narrator);
                        contentFromFile.add(content);
                    }
                }
            });

        }catch (IOException e){
            System.out.println("Error to read the file " + e.getMessage());
        }
        return contentFromFile;
    }

    public static List<User> readUsersFile(){
        List<User> UsersFromFile = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(usersFileName));
            lines.forEach(line -> {
                String[] data = line.split("\\" + separator);
                String name = data[0];
                String lastName = data[1];
                int age = Integer.parseInt(data[2]);
                String nationality = data[3];
                String city = data[4];
                int phone = Integer.parseInt(data[5]);

                User user = new User(name,lastName,age,nationality,city,phone);
                UsersFromFile.add(user);

            });

        }catch (IOException e){
            System.out.println("Error to read the file " + e.getMessage());
        }
        return UsersFromFile;
    }

    public static void addMovieToFile(Content content){
        String line = String.join(separator,
                content.getTitle(),
                content.getDescription(),
                String.valueOf(content.getGenre()),
                String.valueOf(content.getRealiseYear()),
                String.valueOf(content.getDuration()),
                String.valueOf(content.getRating()),
                String.valueOf(content.getLanguage()),
                String.valueOf(content.getQuality())
        );
        String finalLine;
        if (content instanceof Documental documental){
            finalLine = "DOCUMENTAL" + separator + line + separator + documental.getNarrator();
        }else {
            finalLine = "MOVIE" + separator + line + separator ;
        }

        try {
            Files.writeString(Paths.get(contentFileName),finalLine + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println("Error to open the file" + e.getMessage());
        }


    }
}
// Coco|Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather.|ANIMATION|2017-11-22|105.0|4.8|ENGLISH,SPANISH|HD_720P,FHD_1080P,UHD_4K