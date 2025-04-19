package com.gridnine.testing.flightrules.filter;

import com.gridnine.testing.flightrules.entity.Flight;

import java.util.function.Predicate;

public interface FlightRuleFilter extends Predicate<Flight> {

}
