package pro.sky.com.gridnine.testing;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RuleService ruleService = new RuleService();
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println(flights);

        System.out.println(ruleService.flightsAfterCurrentTime(flights));
        System.out.println(ruleService.segsArrTimeBeforeDepTime(flights));
        System.out.println(ruleService.flightsWithTimeOnEarth(flights));
    }
}