package platzi.play.content;


import java.time.LocalDate;

public class Movie {
    public String title;
    public String description;
    public String genere;
    public LocalDate realiseYear;
    public double duration;
    public double rating;
    public boolean available;


    public void play(){
        System.out.println("playing..." + title);
    }

    public String getTechnicalSpecification() {
        return title + " " +realiseYear.getYear() + "\n" +
                "Genre: " + genere + "\n" +
                "Rating: "+rating+"/5";
    }
    public void rate(double rating){
        if (rating>= 0 && rating<=5){
            this.rating = rating;
        }
    }

    public boolean isPopular(){
        return rating >= 4;
    }
}
