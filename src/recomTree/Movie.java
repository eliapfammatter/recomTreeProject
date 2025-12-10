package recomTree;

public class Movie {
    private String id;
    private String title;
    private int year;
    private double averageRating;
    private int ratingCount;

    public Movie(String id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.averageRating = 0.0;
        this.ratingCount = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year=" + year +
                ", title='" + title + '\'' +
                '}';
    }

    public void addRating(double newRating){
        double totalScore = this.averageRating * this.ratingCount;
        this.ratingCount++;
        this.averageRating = (totalScore + newRating) / this.ratingCount;
    }
}
