package is.ru.honn.ruber.domain;

/**
 * Created by Axel Máni on 26.10.2014.
 */
public class Rating {
    private double rating;
    private String comment;

    public Rating() {
    }

    public Rating(double rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
