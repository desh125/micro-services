package com.example.vehicle_service.service;

import com.example.vehicle_service.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    List<VehicleDTO> getAllVehicles();
    VehicleDTO saveVehicle(VehicleDTO vehicle);
    void updateVehicle(VehicleDTO vehicle);
    void deleteVehicle(VehicleDTO vehicle);
    VehicleDTO findVehicleByLicensePlate(String licensePlate);
}
