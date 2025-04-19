package com.gridnine.testing.flightrules;

import com.gridnine.testing.flightrules.builder.FlightBuilder;
import com.gridnine.testing.flightrules.entity.Flight;
import com.gridnine.testing.flightrules.filter.ArrivalBeforeDepartureRuleFilter;
import com.gridnine.testing.flightrules.filter.DepartureBeforeCurrentTimeRuleFilter;
import com.gridnine.testing.flightrules.filter.FlightFilter;
import com.gridnine.testing.flightrules.filter.TimeExceedsRuleFilter;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Все перелёты:");
        flights.forEach(System.out::println);

        System.out.println("1. Исключены перелёты с вылетом до текущего момента времени:");
        FlightFilter.filter(flights, new DepartureBeforeCurrentTimeRuleFilter()).forEach(System.out::println);

        System.out.println("2. Исключены перелёты с сегментами, где дата прилёта раньше даты вылета:");
        FlightFilter.filter(flights, new ArrivalBeforeDepartureRuleFilter()).forEach(System.out::println);

        System.out.println("3. Исключены перелёты с общим временем на земле более двух часов:");
        FlightFilter.filter(flights, new TimeExceedsRuleFilter()).forEach(System.out::println);
    }
}
