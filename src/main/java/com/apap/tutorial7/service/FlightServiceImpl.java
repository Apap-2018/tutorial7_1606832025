package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDB flightDb;
    
    @Override
    public FlightModel addFlight(FlightModel flight) {
        return flightDb.save(flight);
    }

    @Override
    public void deleteByFlightNumber(String flightNumber) {
        flightDb.deleteByFlightNumber(flightNumber);
    }
    
    @Override
    public void deleteFlight(FlightModel flight) {
    	flightDb.delete(flight);
    }
    
    @Override
	public List<FlightModel> getAllFlight() {
		// TODO Auto-generated method stub
		return flightDb.findAll();
	}

    @Override
    public Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber) {
        return flightDb.findByFlightNumber(flightNumber);
    }

	@Override
	public FlightModel getById(long id) {
		// TODO Auto-generated method stub
		return flightDb.findById(id);
	}

	@Override
	public void updateFlight(FlightModel flight, long id) {
		FlightModel old = flightDb.findById(id);
		old.setFlightNumber(flight.getFlightNumber());
		old.setOrigin(flight.getOrigin());;
		old.setDestination(flight.getDestination());
		old.setTime(flight.getTime());
		flightDb.save(old);
			
		
		
	}
	
	
}