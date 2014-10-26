package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverDTO;

import java.util.List;

/**
 * Created by Axel Máni on 25.10.2014.
 */
public interface DriverService {
    public List<DriverDTO> getDrivers() throws DriverNotFoundException;
    public DriverDTO getDriver(int id) throws DriverNotFoundException;

}
