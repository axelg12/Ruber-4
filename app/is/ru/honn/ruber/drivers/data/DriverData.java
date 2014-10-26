package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.*;
import is.ru.honn.ruber.users.data.UserRowMapper;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axel Máni on 25.10.2014.
 */
public class DriverData extends RuData implements DriverDataGateway {
    @Override
    public List<DriverDTO> getDrivers() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<DriverDTO> dtoList = new ArrayList<DriverDTO>();
        List<Driver> drivers = jdbcTemplate.query("select * from ru_drivers", new DriverRowMapper());
        for (int i = 0; i < drivers.size(); i++) {
            Product p = (Product)jdbcTemplate.queryForObject(
                    "select * from ru_product where id =?", new ProductRowMapper(), drivers.get(i).getProductID());

            dtoList.add(new DriverDTO(drivers.get(i),p));
        }
        return dtoList;
    }

    @Override
    public DriverDTO getDriver(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        Driver driver;
        List<Rating> rating;
        try
        {
            driver = (Driver)jdbcTemplate.queryForObject(
                    "select * from ru_drivers where id =?", new DriverRowMapper(), id);
            rating = jdbcTemplate.query("select * from ru_rating where tripID =?", new RatingRowMapper(), driver.getDriverID());

        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new UserNotFoundException("No driver found with driverID: " + id);
        }
        return new DriverDTO(driver, rating);
    }
}
