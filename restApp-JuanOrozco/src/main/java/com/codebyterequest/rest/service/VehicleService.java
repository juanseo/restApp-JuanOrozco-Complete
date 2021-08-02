package com.codebyterequest.rest.service;

import com.codebyterequest.rest.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    Vehicle save (Vehicle vehicle);

    Vehicle getVehicle( Long id);

    Vehicle update(Long id, Vehicle vehicle);

    void delete(Long id);

    List<Vehicle> getAllVehicles();
}
