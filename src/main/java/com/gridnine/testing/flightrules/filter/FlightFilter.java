package com.gridnine.testing.flightrules.filter;

import com.gridnine.testing.flightrules.entity.Flight;

import java.util.List;

public class FlightFilter {

    public static List<Flight> filter(List<Flight> flights, FlightRuleFilter flightRule){
        return flights.stream()
                .filter(flightRule)
                .toList();
    }
}
