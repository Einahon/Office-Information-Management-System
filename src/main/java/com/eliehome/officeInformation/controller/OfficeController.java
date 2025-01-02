package com.eliehome.officeInformation.controller;

import com.eliehome.officeInformation.entity.Office;
import com.eliehome.officeInformation.error.OfficeNotFoundException;
import com.eliehome.officeInformation.service.OfficeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfficeController {
    @Autowired
    private OfficeService officeService;


    private final Logger LOGGER = LoggerFactory.getLogger(OfficeController.class);

    @PostMapping("/offices")
    public Office saveOffice(@Valid @RequestBody Office office){
        LOGGER.info("Inside saveOffice of officeController");
        return officeService.saveOffice(office);

    }
    @GetMapping("/offices")
    public List<Office> fetchOfficeList(){
        LOGGER.info("Inside fetchOfficeList of officeController");
        return officeService.fetchOfficeList();
    }
    @GetMapping("/offices/{id}")

    public Office fetchOfficeById(@PathVariable("id") Long office_id) throws OfficeNotFoundException {
        LOGGER.info("Inside fetchOfficeById of officeController");
        return officeService.fetchOfficeById(office_id);
    }
    @DeleteMapping("/offices/{id}")

    public String deleteOfficeById(@PathVariable("id") Long office_id) throws OfficeNotFoundException {
         officeService.deleteOfficeById(office_id);
        return "Office deleted sucessfully!!!";
    }
    @PutMapping("/offices/{id}")
    public Office updateOffice(@Valid @RequestBody Office office, @PathVariable("id") Long office_id) throws OfficeNotFoundException {
        return officeService.updateOffice(office, office_id);

    }
    @GetMapping("/offices/manager/{name}")
    public Office fetchOfficeByManager(@PathVariable("name") String manager) throws OfficeNotFoundException {
        return officeService.fetchOfficeByManager(manager);
    }

}
