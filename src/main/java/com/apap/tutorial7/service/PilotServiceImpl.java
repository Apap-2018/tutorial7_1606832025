package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.PilotDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PilotServiceImpl
 */
@Service
@Transactional
public class PilotServiceImpl implements PilotService {
    @Autowired
    private PilotDB pilotDb;

    @Override
    public Optional<PilotModel> getPilotDetailByLicenseNumber(String licenseNumber) {
        return pilotDb.findByLicenseNumber(licenseNumber);
    }

    @Override
    public PilotModel addPilot(PilotModel pilot) {
        return pilotDb.save(pilot);
    }

    @Override
    public void deletePilotByLicenseNumber(String licenseNumber) {
        pilotDb.deleteByLicenseNumber(licenseNumber);
    }

    @Override
    public Optional<PilotModel> getPilotDetailById(long id) {
        return pilotDb.findById(id);
    }
    
    @Override
	public List<PilotModel> getListPilot() {
		// TODO Auto-generated method stub
		return pilotDb.findAll();
	}

    @Override
	public void updatePilot(PilotModel pilot, long id) {
		// TODO Auto-generated method stub
		PilotModel old = pilotDb.findById(id).get();
		old.setFlyHour(pilot.getFlyHour());
		old.setName(pilot.getName());
		old.setLicenseNumber(old.getLicenseNumber());
		old.setId(old.getId());
		pilotDb.save(old);
		
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);		
	}
}