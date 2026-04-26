package platzi.play;

import platzi.play.Platform.User;
import platzi.play.content.Movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("Hello, This is Platzi Play 🚀");
        System.out.println("========================================================================"+"\n");

        Movie movie = new Movie();
        movie.title= "Interstellar";
        movie.description =
                "is a critically acclaimed epic science fiction film directed by Christopher Nolan, following a team of astronauts who travel through a wormhole near Saturn in search of a new home for humanity as Earth faces extinction from catastrophic blight. The film is known for its scientifically grounded, often emotionally charged, exploration of time dilation, love, and survival, featuring a notable, complex plot.";
        movie.genere = "Suspense";
        movie.realiseYear = LocalDate.of(2024,02, 29);
        movie.duration = 2.4;
        movie.rating = 4.2;
        movie.rate(3.1);



        User user = new User();
        user.name = "Dylan";
        user.lastName = "Florez";
        user.age = 23;
        user.nationality = "Colombian";
        user.city = "Soledad";
        user.phone = 956146471;
        user.registeredDate = LocalDateTime.now();

        movie.play();
        user.watch(movie.title);
        System.out.println(movie.getTechnicalSpecification());

        user.getRegisteredDate();









       /*
        System.out.println("========================================================================");

        System.out.println("Hello, This is Platzi Play 🚀");
        System.out.println("========================================================================"+"\n");
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Insert your name: ");
        String name = Scanner.nextLine();
        System.out.println("Insert your age: ");
        int age = Scanner.nextInt();
        Scanner.nextLine();
        System.out.println("Insert your nationality: ");
        String nationality = Scanner.nextLine();
        System.out.println("Which city do you live in: ");
        String city = Scanner.nextLine();
        System.out.println("Hello " + name + " wellcome to Platzi Play" );
        System.out.println("Now we'll recommend to you some +" + age + " movies");
        System.out.println("These are the movies which " + nationality + " loved it");
       */

    }

}
