package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.State;
import az.admin.fleetap.model.VehicleModel;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.LocationService;
import az.admin.fleetap.service.StateService;
import az.admin.fleetap.service.VehicleModelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    private final VehicleModelService vehicleModelService;

    public VehicleModelController(VehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    @GetMapping("/vehicleModel")
    public String getStates(Model model) {
        List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModels", vehicleModels);

        return "vehicleModel";
    }

    @PostMapping("/vehicleModel/addNew")
    public String addNew(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }

    @GetMapping("/vehicleModel/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(int id) {
        return vehicleModelService.findById(id);
    }


    @RequestMapping(value = "/vehicleModel/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }

    @RequestMapping(value = "/vehicleModel/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        vehicleModelService.delete(id);
        return "redirect:/vehicleModel";
    }
}
