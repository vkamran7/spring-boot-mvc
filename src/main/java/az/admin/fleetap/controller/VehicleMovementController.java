package az.admin.fleetap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class VehicleMovementController {
    @GetMapping("/vehicleMovement")
    public String getCountries() {
        return "vehicleMovement";
    }
}
