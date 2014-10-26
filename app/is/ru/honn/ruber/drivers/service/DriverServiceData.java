package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverDTO;
import is.ru.honn.ruber.drivers.data.DriverDataGateway;

import java.util.List;

/**
 * Created by Axel Máni on 25.10.2014.
 */
public class DriverServiceData implements DriverService {
    private DriverDataGateway driverDataGateway;

    public DriverServiceData(DriverDataGateway driverDataGateway) {
        this.driverDataGateway = driverDataGateway;
    }

    public DriverServiceData() {
    }

    @Override
    public List<DriverDTO> getDrivers() {
        List<DriverDTO> drivers = driverDataGateway.getDrivers();
        if (drivers == null)
        {
            throw new DriverNotFoundException("No driver found");
        }
        return drivers;
    }

    @Override
    public DriverDTO getDriver(int id) throws DriverNotFoundException {
        DriverDTO driver = driverDataGateway.getDriver(id);
        if(driver == null)
        {
            throw new DriverNotFoundException("Driver not found");
        }
        return driver;
    }
}
