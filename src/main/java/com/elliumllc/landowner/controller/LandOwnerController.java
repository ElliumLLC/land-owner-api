package com.elliumllc.landowner.controller;

import com.elliumllc.landowner.entity.LandOwner;
import com.elliumllc.landowner.service.LandOwnerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/land-owner")
@CrossOrigin("*")
public class LandOwnerController {

    private final LandOwnerService landOwnerService;

    public LandOwnerController(LandOwnerService landOwnerService) {
        this.landOwnerService = landOwnerService;
    }

    // Find all owners
    @GetMapping(value = "/all")
    public List<LandOwner> findAllLandOwners() {
        return landOwnerService.findAllLandOwners();
    }

    // Find owner by id
    @GetMapping(value = "/id/{id}")
    @ResponseBody
    public LandOwner findLandOwnerById(@PathVariable(value = "id") Optional<String> id) {
        System.out.println("ID: " + id.orElseGet(() -> "not provided"));
        // Still need to check id.isPresent()
        Integer idInteger = Integer.parseInt(id.get());
        return landOwnerService.findLandOwnerById(idInteger).get();
    }

    // Add a new owner
    @PostMapping(
            value = "/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public LandOwner addLandOwner(@RequestBody LandOwner newLandOwner) {
        return landOwnerService.addLandOwner(newLandOwner);
    }

    // Update owner info
    @PutMapping(
            value = "update/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public LandOwner updateLandOwner(@PathVariable(value = "id") Optional<String> id,  @RequestBody LandOwner updatedLandOwner) {
        System.out.println("ID: " + id.orElseGet(() -> "not provided"));
        // Still need to check id.isPresent()
        Integer idInteger = Integer.parseInt(id.get());

        return landOwnerService.findLandOwnerById(idInteger)
                .map(landOwner -> {
                    landOwner.setFirstName(updatedLandOwner.getFirstName());
                    landOwner.setLastName(updatedLandOwner.getLastName());
                    landOwner.setAddress(updatedLandOwner.getAddress());
                    landOwner.setCity(updatedLandOwner.getCity());
                    landOwner.setCounty(updatedLandOwner.getCounty());
                    landOwner.setState(updatedLandOwner.getState());
                    landOwner.setTotalAcres(updatedLandOwner.getTotalAcres());
                    return landOwnerService.addLandOwner(landOwner);
                })
                .orElseGet(() -> {
                    return landOwnerService.addLandOwner(updatedLandOwner);
                });
    }

    // Delete owner by id
    @DeleteMapping(value = "/delete/{id}")
    public void deleteLandOwnerById(@PathVariable(value = "id") Optional<String> id) {
        System.out.println("ID: " + id.orElseGet(() -> "not provided"));
        // Still need to check id.isPresent()
        Integer idInteger = Integer.parseInt(id.get());

        // Print deleted user info on terminal
        Optional<LandOwner> deletedLandOwner = landOwnerService.findLandOwnerById(idInteger);
        System.out.println("Deleted user: " + deletedLandOwner.toString());

        landOwnerService.deleteLandOwnerById(idInteger);
    }
}
