package pro.sky.com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public interface Rule {
    List<Flight> flightsAfterCurrentTime(List<Flight> flights);
    List<Flight> segsArrTimeBeforeDepTime(List<Flight> flights);
    List<Flight> flightsWithTimeOnEarth(List<Flight> flights);

}
