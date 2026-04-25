package platzi.play.Platform;

import java.time.LocalDate;

public class User {
    public String name;
    public String lastName;
    public int age;
    public String nationality;
    public String city;
    public int phone;
    public LocalDate registeredDate;
    public void getRegisteredDate(){
        System.out.println(name + " Was registered on " + registeredDate);
    }
    public void watch(String title){
        System.out.println(name + " is watching "+ title);

    }
}



