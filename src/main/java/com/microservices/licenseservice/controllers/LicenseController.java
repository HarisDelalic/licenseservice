package com.microservices.licenseservice.controllers;

import com.microservices.licenseservice.models.License;
import com.microservices.licenseservice.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}")
public class LicenseController {

    @Autowired
    LicenseRepository licenseRepository;

    @RequestMapping(value = "/licenses/{licenseId}", method = RequestMethod.GET)
    public License getLicense(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {

        License license = License.LicenseBuilder.newInstance()
                .withId(licenseId)
                .withProductName("Teleco")
                .withType("Seat")
                .withOrganization(organizationId)
                .build();
        return license;

    }

    @RequestMapping(value="/licenses",method = RequestMethod.GET)
    public List<License> getLicenses() {
        return licenseRepository.findAll();
    }

    @RequestMapping(value="/licenses/{licenseId}", method = RequestMethod.POST)
    public License save(@PathVariable("organizationId") String organizationId,
                        @PathVariable("licenseId") String licenseId) {
        License license = License.LicenseBuilder.newInstance()
                .withId(licenseId)
                .withProductName("Teleco")
                .withType("Seat")
                .withOrganization(organizationId)
                .build();
        return licenseRepository.save(license);
    }
}
