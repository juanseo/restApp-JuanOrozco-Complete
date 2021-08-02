package com.codebyterequest.rest.controller;

import com.codebyterequest.rest.model.Vehicle;
import com.codebyterequest.rest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>>  getAllVehicle(){
        return ResponseEntity.ok().body(vehicleService.getAllVehicles());
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle>  getVehicleById(@PathVariable long id){
        return ResponseEntity.ok().body(this.vehicleService.getVehicle(id));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle ){
        return ResponseEntity.ok().body(this.vehicleService.save(vehicle));
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable long id, @RequestBody Vehicle vehicle){
        return ResponseEntity.ok().body(this.vehicleService.update(id,vehicle));
    }

    @DeleteMapping("/vehicles/{id}")
    public HttpStatus deleteVehicle(@PathVariable long id){
        this.vehicleService.delete(id);
        return HttpStatus.OK;
    }

}
