package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.State;
import az.admin.fleetap.model.VehicleMake;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.LocationService;
import az.admin.fleetap.service.StateService;
import az.admin.fleetap.service.VehicleMakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {
//    @GetMapping("/vehicleMake")
//    public String getCountries() {
//        return "vehicleMake";
//    }
    private final VehicleMakeService vehicleMakeService;

    public VehicleMakeController(VehicleMakeService vehicleMakeService) {
        this.vehicleMakeService = vehicleMakeService;
    }

    @GetMapping("/vehicleMake")
    public String getStates(Model model) {
        List<VehicleMake> vehicleMakes = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakes", vehicleMakes);
        return "vehicleMake";
    }

    @PostMapping("/vehicleMake/addNew")
    public String addNew(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    @GetMapping("/vehicleMake/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(int id) {
        return vehicleMakeService.findById(id);
    }


    @RequestMapping(value = "/vehicleMake/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    @RequestMapping(value = "/vehicleMake/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMake";
    }
}
