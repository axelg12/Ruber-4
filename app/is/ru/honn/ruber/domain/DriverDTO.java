package is.ru.honn.ruber.domain;

import java.util.List;

/**
 * Created by Axel Máni on 26.10.2014.
 */
public class DriverDTO {
    private Driver driver;
    private Product product;
    private List<Rating> rating;

    public DriverDTO(Driver driver) {
        this.driver = driver;
    }

    public DriverDTO(Driver driver, Product product) {
        this.driver = driver;
        this.product = product;
    }

    public DriverDTO(Driver driver, List<Rating> rating) {
        this.driver = driver;
        this.rating = rating;
    }

    public Driver getDriver() {
        return driver;
    }

    public Product getProduct() {
        return product;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }
}
