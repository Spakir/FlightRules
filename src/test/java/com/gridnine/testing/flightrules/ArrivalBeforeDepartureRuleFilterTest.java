package com.gridnine.testing.flightrules;

import com.gridnine.testing.flightrules.entity.Flight;
import com.gridnine.testing.flightrules.entity.Segment;
import com.gridnine.testing.flightrules.filter.ArrivalBeforeDepartureRuleFilter;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ArrivalBeforeDepartureRuleFilterTest {

    @Test
    void testNormalFlight() {
        ArrivalBeforeDepartureRuleFilter filter = new ArrivalBeforeDepartureRuleFilter();
        Flight flight = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2))
        ));
        assertFalse(filter.test(flight));
    }

    @Test
    void testAbnormalFlight() {
        ArrivalBeforeDepartureRuleFilter filter = new ArrivalBeforeDepartureRuleFilter();
        Flight flight = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().minusHours(1))
        ));
        assertTrue(filter.test(flight));
    }
}