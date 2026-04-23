package platzi.play;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
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

    }

}
