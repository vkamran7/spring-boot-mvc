package az.admin.fleetap.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class VehicleMovementController {
    @GetMapping("/vehicleMovement")
    public String getCountries() {
        return "vehicleMovement";
    }
}
