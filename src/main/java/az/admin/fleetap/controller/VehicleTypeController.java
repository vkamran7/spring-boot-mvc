package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.State;
import az.admin.fleetap.model.VehicleType;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.LocationService;
import az.admin.fleetap.service.StateService;
import az.admin.fleetap.service.VehicleTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {
//    @GetMapping("/vehicleType")
//    public String getCountries() {
//        return "vehicleType";
//    }

    private final VehicleTypeService vehicleTypeService;

    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping("/vehicleType")
    public String getStates(Model model) {
        List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypes);


        return "vehicleType";
    }

    @PostMapping("/vehicleType/addNew")
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";
    }

    @GetMapping("/vehicleType/findById")
    @ResponseBody
    public Optional<VehicleType> findById(int id) {
        return vehicleTypeService.findById(id);
    }


    @RequestMapping(value = "/vehicleType/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";
    }

    @RequestMapping(value = "/vehicleType/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicleType";
    }
}
