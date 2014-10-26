package is.ru.honn.ruber.domain;

/**
 * Created by Axel Máni on 25.10.2014.
 */
public class Driver {
    private String driverName;
    private int driverID;
    private int productID;

    public Driver(String driverName, int driverID, int productID) {
        this.driverName = driverName;
        this.driverID = driverID;
        this.productID = productID;
    }

    private Price price;

    public String getDriverName() {
        return driverName;
    }

    public int getProductID() {
        return productID;
    }

    public int getDriverID() {
        return driverID;
    }
}
