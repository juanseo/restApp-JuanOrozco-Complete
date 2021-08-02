package com.codebyterequest.rest.service;

import com.codebyterequest.rest.exception.ResourceNotFoundException;
import com.codebyterequest.rest.model.Vehicle;
import com.codebyterequest.rest.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicle(Long id) {
        Optional<Vehicle> vehicleDb = this.vehicleRepository.findById(id);

        if (vehicleDb.isPresent()){
            return vehicleDb.get();
        }else{
            throw new ResourceNotFoundException("Resource not found with id = " + id);
        }


    }

    @Override
    public Vehicle update(Long id, Vehicle vehicle) {
       Optional<Vehicle> vehicleDb = this.vehicleRepository.findById(vehicle.getId());

       if (vehicleDb.isPresent()){
           Vehicle vehicleUpdate = vehicleDb.get();
           vehicleUpdate.setBrand(vehicle.getBrand());
           vehicleUpdate.setEngine(vehicle.getEngine());
           vehicleUpdate.setFeatures(vehicle.getFeatures());
           vehicleUpdate.setModel(vehicle.getModel());
           vehicleUpdate.setLaunch_date(vehicle.getLaunch_date());
           vehicleUpdate.setMaximum_speed(vehicle.getMaximum_speed());

           vehicleRepository.save(vehicleUpdate);
           return vehicleUpdate;
       }else{
           throw new ResourceNotFoundException("Resource not found with id = " + vehicle.getId());
       }
    }

    @Override
    public void delete(Long id) {
        Optional<Vehicle> vehicleDb = this.vehicleRepository.findById(id);
        if (vehicleDb.isPresent()){
           this.vehicleRepository.delete(vehicleDb.get());
        }else{
            throw new ResourceNotFoundException("Resource not found with id = " + id );
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return this.vehicleRepository.findAll();
    }
}
