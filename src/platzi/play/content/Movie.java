package platzi.play.content;

public class Movie {
    public String title;
    public String description;
    public String genere;
    public int realiseYear;
    public double duration;
    public double rating;
    public boolean available;


    public void play(){
        System.out.println("playing..." + title);
    }

    public String getTechnicalSpecification() {
        return title + " " +realiseYear + "\n" +
                "Genre: " + genere + "\n" +
                "Rating: "+rating+ "\n"+"/5";
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
