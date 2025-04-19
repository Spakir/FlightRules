package com.gridnine.testing.flightrules.filter;

import com.gridnine.testing.flightrules.entity.Flight;

public class ArrivalBeforeDepartureRuleFilter implements FlightRuleFilter {
    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream()
                .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));
    }
}
