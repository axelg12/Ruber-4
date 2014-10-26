package controllers;


import is.ru.honn.ruber.domain.TripDTO;
import is.ru.honn.ruber.users.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.trips;

import java.util.List;

public class UserController extends Controller
{
  protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/UserService.xml");

  public static Result getTrips(int userID)
  {
      UserService userService = (UserService)ctx.getBean("userService");
      List<TripDTO> tripList = userService.getTrips(userID);

      return ok(trips.render(tripList));
  }
}
