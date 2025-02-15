package com.example.vehicle_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private Long vehicleId;
    private String licensePlate;
    private String make;
    private String model;
}
