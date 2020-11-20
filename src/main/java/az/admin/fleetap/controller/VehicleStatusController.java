package az.admin.fleetap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleStatusController {
    @GetMapping("/vehicleStatus")
    public String getCountries() {
        return "vehicleStatus";
    }
}
