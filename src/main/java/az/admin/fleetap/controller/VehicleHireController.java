package az.admin.fleetap.controller;

import az.admin.fleetap.model.Client;
import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.Vehicle;
import az.admin.fleetap.model.VehicleHire;
import az.admin.fleetap.service.ClientService;
import az.admin.fleetap.service.LocationService;
import az.admin.fleetap.service.VehicleHireService;
import az.admin.fleetap.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {

    private final VehicleHireService vehicleHireService;
    private final VehicleService vehicleService;
    private final LocationService locationService;
    private final ClientService clientService;

    public VehicleHireController(VehicleHireService vehicleHireService,
                                 VehicleService vehicleService,
                                 LocationService locationService,
                                 ClientService clientService) {
        this.vehicleHireService = vehicleHireService;
        this.vehicleService = vehicleService;
        this.locationService = locationService;
        this.clientService = clientService;
    }

    @GetMapping("/vehicleHire")
    public String getStates(Model model) {
        List<VehicleHire> vehicleHires = vehicleHireService.getVehicleHires();
        model.addAttribute("vehicleHires", vehicleHires);

        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);

        List<Location> locations = locationService.getLocations();
        model.addAttribute("locations", locations);

        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);

        return "vehicleHire";
    }

    @PostMapping("/vehicleHire/addNew")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHire";
    }

    @GetMapping("/vehicleHire/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(int id) {
        return vehicleHireService.findById(id);
    }


    @RequestMapping(value = "/vehicleHire/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHire";
    }

    @RequestMapping(value = "/vehicleHire/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicleHire";
    }
}
