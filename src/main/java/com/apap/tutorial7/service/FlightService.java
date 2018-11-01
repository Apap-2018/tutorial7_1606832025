package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.FlightModel;

/**
 * FlightService
 */
public interface FlightService {
    FlightModel addFlight(FlightModel flight);
    
    void deleteByFlightNumber(String flightNumber);
    void updateFlight(FlightModel flight, long id);
    void deleteFlight(FlightModel flight);

    List<FlightModel> getAllFlight();
    FlightModel getById(long id);
    Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber);
}