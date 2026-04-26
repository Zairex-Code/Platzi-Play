package platzi.play.Platform;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private String name;
    private String lastName;
    private int age;
    private String nationality;
    private String city;
    private int phone;
    private LocalDateTime registeredDate;

    public User(String name, String lastName, int age, String nationality, String city, int phone){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.city = city;
        this.phone = phone;
        this.registeredDate = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }



    public void getRegisteredDate(){
        System.out.println(name + " Was registered on " + registeredDate);
    }
    public void watch(String title){
        System.out.println(name + " is watching "+ title);

    }
}



