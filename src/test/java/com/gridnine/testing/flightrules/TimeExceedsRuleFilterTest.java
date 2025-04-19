package com.gridnine.testing.flightrules;

import com.gridnine.testing.flightrules.entity.Flight;
import com.gridnine.testing.flightrules.entity.Segment;
import com.gridnine.testing.flightrules.filter.TimeExceedsRuleFilter;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class TimeExceedsRuleFilterTest {

    @Test
    void testFlightWithShortGroundTime() {
        TimeExceedsRuleFilter filter = new TimeExceedsRuleFilter();
        LocalDateTime now = LocalDateTime.now();
        Flight flight = new Flight(List.of(
                new Segment(now, now.plusHours(1)),
                new Segment(now.plusHours(1).plusMinutes(30), now.plusHours(3))
        ));
        assertFalse(filter.test(flight));
    }

    @Test
    void testFlightWithLongGroundTime() {
        TimeExceedsRuleFilter filter = new TimeExceedsRuleFilter();
        LocalDateTime now = LocalDateTime.now();
        Flight flight = new Flight(List.of(
                new Segment(now, now.plusHours(1)),
                new Segment(now.plusHours(4), now.plusHours(5))
        ));
        assertTrue(filter.test(flight));
    }

    @Test
    void testSingleSegmentFlight() {
        TimeExceedsRuleFilter filter = new TimeExceedsRuleFilter();
        Flight flight = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1))
        ));
        assertFalse(filter.test(flight));
    }
}
