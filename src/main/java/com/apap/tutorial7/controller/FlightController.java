package com.apap.tutorial7.controller;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.rest.PilotDetail;
import com.apap.tutorial7.service.FlightService;
import com.apap.tutorial7.service.PilotService;
import com.apap.tutorial7.rest.Setting;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PilotController
 */
@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    
    @Autowired
    private PilotService pilotService;

   

    @PostMapping(value = "/add")
    public FlightModel addFlightSubmit(@RequestBody FlightModel flight) {
        
        return flightService.addFlight(flight);
    }
    
    @GetMapping(value = "/all")
   	private List<FlightModel> viewall() {
   		List<FlightModel> flight = flightService.getAllFlight();
   		
   		return flight;
   	}
    
    @GetMapping(value = "/view/{flightNumber}")
    private FlightModel flightView(@PathVariable("flightNumber") String flightNumber) {
        FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber).get();
        return flight;
    }
   
    
    @DeleteMapping(value = "/{flightId}")
    private String deleteFlight(@PathVariable("flightId") long flightId) {
       FlightModel flight = flightService.getById(flightId);
       flightService.deleteFlight(flight);
       return "Flight has been deleted";
    }
    
    
    @PutMapping(value = "/update/{flightId}")
    private String updateFlightSubmit(@PathVariable("flightId") long flightId,
            @RequestParam(value = "destination", required = false) String destination,
            @RequestParam(value = "origin", required = false) String origin,
            @RequestParam(value = "time", required = false) Date time
    		){
    	 
        FlightModel flight = flightService.getById(flightId);
        if (flight.equals(null)){
            return "Couldn't find your flight";
        }
        if (destination != null) {
        	flight.setDestination(destination);
        }
        if (origin != null) {
        	flight.setOrigin(origin);
        }
        if (time != null) {
        	flight.setTime(time);
        }
        
        flightService.updateFlight(flight, flightId);
        return "flight update success";  
        
    }

    /*
    @GetMapping(value="/status/{licenseNumber}")
    public String getStatus(@PathVariable("licenseNumber") String licenseNumber) throws Exception{
        String path = Setting.pilotUrl + "/pilot?licenseNumber=" + licenseNumber;
        return restTemplate.getForEntity(path, String.class).getBody();
    }

    @GetMapping(value="/full/{licenseNumber}")
    public PilotDetail postStatus(@PathVariable("licenseNumber") String licenseNumber) throws Exception{
        String path = Setting.pilotUrl + "/pilot";
        PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber).get();
        PilotDetail detail = restTemplate.postForObject(path, pilot, PilotDetail.class);
        return detail;
    }

   */

    

    
    
    
 
    
}