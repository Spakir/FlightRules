package com.gridnine.testing.flightrules.filter;

import com.gridnine.testing.flightrules.entity.Flight;

import java.time.LocalDateTime;

public class DepartureBeforeCurrentTimeRuleFilter implements FlightRuleFilter {
    @Override
    public boolean test(Flight flight) {
        LocalDateTime now = LocalDateTime.now();
        return flight.getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate().isBefore(now));
    }
}
