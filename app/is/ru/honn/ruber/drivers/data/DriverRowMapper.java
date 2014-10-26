package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Driver;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Axel Máni on 25.10.2014.
 */
public class DriverRowMapper implements RowMapper<Driver> {

    @Override
    public Driver mapRow(ResultSet rs, int i) throws SQLException {
        return new Driver(
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(1));
    }
}
