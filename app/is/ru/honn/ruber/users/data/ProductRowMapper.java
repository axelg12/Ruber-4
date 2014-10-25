package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Axel Máni on 25.10.2014.
 */
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        Product p = new Product();
        p.setId(rs.getInt(1));
        p.setDescription(rs.getString(2));
        p.setDisplay_name(rs.getString(3));
        p.setCapacity(rs.getInt(4));
        p.setImage(rs.getString(5));
        return p;
    }
}
