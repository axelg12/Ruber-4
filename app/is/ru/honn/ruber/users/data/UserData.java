package is.ru.honn.ruber.users.data;

import is.ru.honn.ruber.domain.*;
import is.ru.honn.ruber.drivers.data.DriverRowMapper;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ru.honn.ruber.users.service.UsernameExistsException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.*;

public class UserData extends RuData implements UserDataGateway
{
  public int addUser(User user)
  {
    SimpleJdbcInsert insert =
        new SimpleJdbcInsert(getDataSource())
            .withTableName("ru_users")
            .usingGeneratedKeyColumns("id");

    Map<String, Object> parameters = new HashMap<String, Object>(6);
    parameters.put("username", user.getUsername());
    parameters.put("firstname", user.getFirstName());
    parameters.put("lastname", user.getLastName());
    parameters.put("password", user.getPassword());
    parameters.put("email", user.getEmail());
    parameters.put("registered", new Date());

    int returnKey;

    try
    {
      returnKey = insert.executeAndReturnKey(parameters).intValue();
    }
    catch(DataIntegrityViolationException divex)
    {
      throw new UsernameExistsException("User " + user.getUsername() + " already exits", divex);
    }

    user.setId(returnKey);
    return returnKey;
  }

  public User getUserByUsername(String username)
  {
    Collection<String> users;
    JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    User user;
    try
    {
      user = (User)jdbcTemplate.queryForObject(
          "select * from ru_users where username = '" + username + "'", new UserRowMapper());
    }
    catch (EmptyResultDataAccessException erdaex)
    {
      throw new UserNotFoundException("No user found with username: " + username);
    }
    return user;
  }

    @Override
    public List<TripDTO> getTrips(int userID) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<TripDTO> trips = new ArrayList<TripDTO>();
        List list;
        List<Trip> tripList = jdbcTemplate.query("select * from ru_trips where uuid=?", new TripRowMapper(), userID);
        for (int i = 0; i < tripList.size(); i++) {
            TripDTO dto = new TripDTO();
            tripList.get(i).setDriverID(1);
            Driver driver = (Driver)jdbcTemplate.queryForObject(
                    "select * from ru_drivers where id =?", new DriverRowMapper(), tripList.get(i).getDriverID());

            dto.setDate(tripList.get(i).getStartTime());
            System.out.println( driver.getDriverName() );
            dto.setDriver(driver.getDriverName());
            dto.setLength(tripList.get(i).getDistance());
            dto.setMinutes(tripList.get(i).getStartTime(), tripList.get(i).getEndTime());

            trips.add(dto);
        }

        return trips;

    }
}
