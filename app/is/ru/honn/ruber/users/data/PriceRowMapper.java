package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.Price;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Axel Máni on 25.10.2014.
 */
public class PriceRowMapper implements RowMapper<Price> {
    @Override
    public Price mapRow(ResultSet rs, int i) throws SQLException {
        Price p = new Price();
        p.setId(rs.getInt(1));
        p.setCurrencyCode(rs.getString(2));
        p.setDisplayName(rs.getString(3));
        p.setLowEstimate(rs.getInt(4));
        p.setHighEstimate(rs.getInt(5));
        p.setSurgeMultiplier(rs.getFloat(6));
        return p;
    }
}
