package pro.sky.com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RuleService implements Rule {

    public List<Flight> flights;
    public List<Segment> segs;
    public LocalDateTime currentDateTime = LocalDateTime.now();


    public List<Flight> flightsAfterCurrentTime(List<Flight> flights) {
        return flights.stream()
                .filter(e -> e.getSegments().stream()
                        .filter(t -> t.getDepartureDate().isAfter(currentDateTime)).isParallel())
                .collect(Collectors.toList());
        }


    public List<Flight> segsArrTimeBeforeDepTime(List<Flight> flights) {
        return flights.stream()
                .filter(e-> e.getSegments().stream()
                        .filter(t -> t.getArrivalDate().isAfter(t.getDepartureDate())).isParallel())
                .collect(Collectors.toList());
    }


    public List<Flight> flightsWithTimeOnEarth(List<Flight> flights) {
        return flights.stream()
                .filter(e -> e.getSegments().stream()
                        .filter(t -> t.getDepartureDate().getHour() - t.getArrivalDate().getHour() < 2).isParallel())
                .collect(Collectors.toList());
    }
}
