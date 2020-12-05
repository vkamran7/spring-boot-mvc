package az.admin.fleetap.controller;

import az.admin.fleetap.model.*;
import az.admin.fleetap.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {

    private final VehicleMovementService vehicleMovementService;
    private final VehicleService vehicleService;
    private final LocationService locationService;

    public VehicleMovementController(VehicleMovementService vehicleMovementService, VehicleService vehicleService, LocationService locationService) {
        this.vehicleMovementService = vehicleMovementService;
        this.vehicleService = vehicleService;
        this.locationService = locationService;
    }

    @GetMapping("/vehicleMovement")
    public String getStates(Model model) {
        List<VehicleMovement> vehicleMovements = vehicleMovementService.getVehicleMovements();
        model.addAttribute("vehicleMovements", vehicleMovements);

        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);

        List<Location> locations = locationService.getLocations();
        model.addAttribute("locations", locations);

        return "vehicleMovement";
    }

    @PostMapping("/vehicleMovement/addNew")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @GetMapping("/vehicleMovement/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(int id) {
        return vehicleMovementService.findById(id);
    }


    @RequestMapping(value = "/vehicleMovement/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @RequestMapping(value = "/vehicleMovement/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovement";
    }
}
