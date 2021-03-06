package com.apap.tutorial7.repository;

import java.util.Optional;

import com.apap.tutorial7.model.FlightModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FlightDb
 */
@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long> {
    void deleteByFlightNumber(String flightNumber);

    FlightModel findById(long id);
    Optional<FlightModel> findByFlightNumber(String flightNumber);
}