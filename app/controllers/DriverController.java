package controllers;


import is.ru.honn.ruber.domain.DriverDTO;
import is.ru.honn.ruber.drivers.service.DriverService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Result;
import play.mvc.Controller;
import views.html.drivers;
import views.html.driver;

import java.util.List;


/**
 * Created by Axel Máni on 25.10.2014.
 */
public class DriverController extends Controller {
    protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/UserService.xml");

    public static Result getDrivers()
    {

        DriverService driverService = (DriverService)ctx.getBean("driverService");
        List<DriverDTO> driverList = driverService.getDrivers();

        return ok(drivers.render(driverList));
    }

    public static Result getDriver(int driverID)
    {
        DriverService driverService = (DriverService)ctx.getBean("driverService");
        DriverDTO driverObj = driverService.getDriver(driverID);
        return ok(driver.render(driverObj, driverObj.getRating()));
    }
}
