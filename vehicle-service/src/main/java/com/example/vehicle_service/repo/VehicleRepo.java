package com.example.vehicle_service.repo;

import com.example.vehicle_service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {
    Vehicle findByLicensePlate(String licensePlate);
}
