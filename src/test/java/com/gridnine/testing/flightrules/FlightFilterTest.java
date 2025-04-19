package com.gridnine.testing.flightrules;


import com.gridnine.testing.flightrules.entity.Flight;
import com.gridnine.testing.flightrules.entity.Segment;
import com.gridnine.testing.flightrules.filter.FlightFilter;
import com.gridnine.testing.flightrules.filter.FlightRuleFilter;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FlightFilterTest {

    @Test
    void testFilterWithNoMatches() {
        FlightRuleFilter alwaysFalse = flight -> false;
        List<Flight> flights = List.of(
                new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2)))
                ));
        assertEquals(1, FlightFilter.filter(flights, alwaysFalse).size());
    }

    @Test
    void testFilterWithAllMatches() {
        FlightRuleFilter alwaysTrue = flight -> true;
        List<Flight> flights = List.of(
                new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2))))
        );
        assertTrue(FlightFilter.filter(flights, alwaysTrue).isEmpty());
    }
}