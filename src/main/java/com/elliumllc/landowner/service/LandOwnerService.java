package com.elliumllc.landowner.service;

import com.elliumllc.landowner.entity.LandOwner;
import com.elliumllc.landowner.repository.LandOwnerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandOwnerService {

    private final LandOwnerRepo landOwnerRepo;

    public LandOwnerService(LandOwnerRepo landOwnerRepo) {
        this.landOwnerRepo = landOwnerRepo;
    }

    public List<LandOwner> findAllLandOwners() {
        return landOwnerRepo.findAll();
    }

    public Optional<LandOwner> findLandOwnerById(Integer id) {
        return landOwnerRepo.findById(id);
    }

    public LandOwner addLandOwner(LandOwner newLandOwner) {
        return landOwnerRepo.save(newLandOwner);
    }

    public void deleteLandOwnerById(Integer id) {
        landOwnerRepo.deleteById(id);
    }
}
