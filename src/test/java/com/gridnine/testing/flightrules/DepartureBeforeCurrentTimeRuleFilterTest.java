package com.gridnine.testing.flightrules;

import com.gridnine.testing.flightrules.entity.Flight;
import com.gridnine.testing.flightrules.entity.Segment;
import com.gridnine.testing.flightrules.filter.DepartureBeforeCurrentTimeRuleFilter;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DepartureBeforeCurrentTimeRuleFilterTest {

    @Test
    void testFlightWithPastDeparture() {
        DepartureBeforeCurrentTimeRuleFilter filter = new DepartureBeforeCurrentTimeRuleFilter();
        Flight flight = new Flight(List.of(
                new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now())
        ));
        assertTrue(filter.test(flight));
    }

    @Test
    void testFlightWithFutureDeparture() {
        DepartureBeforeCurrentTimeRuleFilter filter = new DepartureBeforeCurrentTimeRuleFilter();
        Flight flight = new Flight(List.of(
                new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2))
        ));
        assertFalse(filter.test(flight));
    }
}
