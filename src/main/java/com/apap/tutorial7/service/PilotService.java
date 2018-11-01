package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.PilotModel;

/**
 * PilotService
 */
public interface PilotService {
    Optional<PilotModel> getPilotDetailByLicenseNumber(String licenseNumber);

    PilotModel addPilot(PilotModel pilot);

    void deletePilotByLicenseNumber(String licenseNumber);

    Optional<PilotModel> getPilotDetailById(long id);
    void updatePilot(PilotModel pilot, long id);
    
    void deletePilot(PilotModel pilot);
    List<PilotModel> getListPilot();
    
}