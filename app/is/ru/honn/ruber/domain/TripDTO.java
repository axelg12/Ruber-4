package is.ru.honn.ruber.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Axel Máni on 25.10.2014.
 */
public class TripDTO {
    private Date date;
    private double length;
    private String minutes;
    private String driver;

    public Date getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = new Date(date*1000);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(long start, long end) {
            long minutes = (end - start) / 60;
        System.out.println(end);
            int hours = (int)minutes / 60;
            int min = (int)minutes % 60;

            this.minutes = Integer.toString(hours) + ":" + Integer.toString(min);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
