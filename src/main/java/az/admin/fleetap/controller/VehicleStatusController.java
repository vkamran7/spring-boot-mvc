package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.State;
import az.admin.fleetap.model.VehicleStatus;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.LocationService;
import az.admin.fleetap.service.StateService;
import az.admin.fleetap.service.VehicleStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {
//    @GetMapping("/vehicleStatus")
//    public String getCountries() {
//        return "vehicleStatus";
//    }

    private final VehicleStatusService vehicleStatusService;

    public VehicleStatusController(VehicleStatusService vehicleStatusService) {
        this.vehicleStatusService = vehicleStatusService;
    }

    @GetMapping("/vehicleStatus")
    public String getStates(Model model) {
        List<VehicleStatus> vehicleStatuses = vehicleStatusService.getVehicleStatuses();
        model.addAttribute("vehicleStatuses", vehicleStatuses);

        return "vehicleStatus";
    }

    @PostMapping("/vehicleStatus/addNew")
    public String addNew(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @GetMapping("/vehicleStatus/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(int id) {
        return vehicleStatusService.findById(id);
    }


    @RequestMapping(value = "/vehicleStatus/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @RequestMapping(value = "/vehicleStatus/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatus";
    }
}
