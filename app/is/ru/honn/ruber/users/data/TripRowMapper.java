package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Axel Máni on 24.10.2014.
 */
public class TripRowMapper implements RowMapper<Trip> {
    @Override
    public Trip mapRow(ResultSet rs, int i) throws SQLException {
        return  new Trip(rs.getInt(1),      // id
                rs.getInt(3),   // requestedTime
                rs.getInt(5),   // productID
                TripStatus.valueOf(rs.getString(7).toUpperCase()),   // lastname
                rs.getDouble(4),   // distance
                rs.getLong(2),   // startTime
                rs.getLong(8)      // endtime
        );
    }
}
