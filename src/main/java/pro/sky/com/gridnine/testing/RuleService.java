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
                        .allMatch(segment -> segment.getDepartureDate().isAfter(currentDateTime)))
                .collect(Collectors.toList());
        }


    public List<Flight> segsArrTimeBeforeDepTime(List<Flight> flights) {
        return flights.stream()
                .filter(e-> e.getSegments().stream()
                        .allMatch(t -> t.getArrivalDate().isAfter(t.getDepartureDate())))
                .collect(Collectors.toList());

    }


    public List<Flight> flightsWithTimeOnEarth(List<Flight> flights) {
//        Duration duration = Duration.between(
//                flights.stream()
//                        .map(Flight::getSegments)
//                        .map(e -> e.stream()
//                                .allMatch(t -> t.getDepartureDate().is))
//        )
        return flights.stream()
                .filter(e -> e.getSegments().stream()
                        .allMatch(t -> (t.getArrivalDate().getHour() - t.getDepartureDate().getHour() < 2) &&
                                (t.getArrivalDate().getDayOfMonth() - t.getDepartureDate().getDayOfMonth() == 0)))
                .collect(Collectors.toList());
    }
}
