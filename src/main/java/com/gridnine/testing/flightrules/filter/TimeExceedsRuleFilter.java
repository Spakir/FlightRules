package com.gridnine.testing.flightrules.filter;

import com.gridnine.testing.flightrules.entity.Flight;
import com.gridnine.testing.flightrules.entity.Segment;

import java.time.Duration;
import java.util.List;
import java.time.LocalDateTime;

public class TimeExceedsRuleFilter implements FlightRuleFilter {
    private static final long MAX_GROUND_TIME_HOURS = 2;

    @Override
    public boolean test(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments.size() <= 1) {
            return false;
        }

        long totalGroundTime = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime currentArrival = segments.get(i).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i+1).getDepartureDate();
            totalGroundTime += Duration.between(currentArrival, nextDeparture).toHours();

            if (totalGroundTime > MAX_GROUND_TIME_HOURS) {
                return true;
            }
        }

        return false;
    }
}
