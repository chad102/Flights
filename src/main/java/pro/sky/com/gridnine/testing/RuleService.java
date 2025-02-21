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
//                        .findAny()
//                        .get()
//                        .getSegments()
//                        .stream().findAny()
//                        .get()
//                        .getArrivalDate()
//                        .toLocalTime()
//                        ,
//
//                flights.stream()
//                        .findAny()
//                        .get()
//                        .getSegments()
//                        .stream().findAny()
//                        .get()
//                        .getDepartureDate()
//                        .toLocalTime()
//        );

        return flights.stream()
                .filter(flight -> {
                    long totalGroundTime = 0;
                    if (flight.getSegments().size() == 1) {
                        return true;
                    }
                    for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                        totalGroundTime = totalGroundTime + Duration.between(
                                flight.getSegments().get(i).getArrivalDate(),
                                flight.getSegments().get(i + 1).getDepartureDate()).toMinutes();
                    }
                    System.out.println(totalGroundTime);
                    return totalGroundTime <= 120;
                })
                .collect(Collectors.toList());
    }
}
