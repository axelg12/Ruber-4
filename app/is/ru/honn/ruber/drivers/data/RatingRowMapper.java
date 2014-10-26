package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Rating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Axel Máni on 26.10.2014.
 */
public class RatingRowMapper implements RowMapper<Rating> {
    @Override
    public Rating mapRow(ResultSet rs, int i) throws SQLException {
        return new Rating(
                rs.getFloat(3),
                rs.getString(4)
        );
    }
}
