package is.ru.honn.ruber.domain;

/**
 * Created by Axel Máni on 25.10.2014.
 */
public class Driver {
    private String driverName;
    private Product product;

    public Driver(String driverName) {
        this.driverName = driverName;
    }

    private Price price;

    public String getDriverName() {
        return driverName;
    }
}
