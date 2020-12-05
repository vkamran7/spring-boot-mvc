package az.admin.fleetap.controller;

import az.admin.fleetap.model.*;
import az.admin.fleetap.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;
    private final LocationService locationService;
    private final EmployeeService employeeService;
    private final VehicleMakeService vehicleMakeService;
    private final VehicleStatusService vehicleStatusService;
    private final VehicleTypeService vehicleTypeService;
    private final VehicleModelService vehicleModelService;

    public VehicleController(VehicleService vehicleService,
                             LocationService locationService,
                             EmployeeService employeeService,
                             VehicleMakeService vehicleMakeService,
                             VehicleStatusService vehicleStatusService,
                             VehicleTypeService vehicleTypeService,
                             VehicleModelService vehicleModelService
                             ) {
        this.vehicleService = vehicleService;
        this.locationService = locationService;
        this.employeeService = employeeService;
        this.vehicleMakeService = vehicleMakeService;
        this.vehicleStatusService = vehicleStatusService;
        this.vehicleTypeService = vehicleTypeService;
        this.vehicleModelService = vehicleModelService;
    }

    @GetMapping("/vehicle")
    public String getStates(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);

        List<Location> locations = locationService.getLocations();
        model.addAttribute("locations", locations);

        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);

        List<VehicleMake> vehicleMakes = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakes", vehicleMakes);

        List<VehicleStatus> vehicleStatuses = vehicleStatusService.getVehicleStatuses();
        model.addAttribute("vehicleStatuses", vehicleStatuses);

        List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypes);

        List<VehicleModel> vehicleModels = vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModels", vehicleModels);

        return "vehicle";
    }

    @PostMapping("/vehicle/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicle";
    }

    @GetMapping("/vehicle/findById")
    @ResponseBody
    public Optional<Vehicle> findById(int id) {
        return vehicleService.findById(id);
    }


    @RequestMapping(value = "/vehicle/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicle";
    }

    @RequestMapping(value = "/vehicle/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        vehicleService.delete(id);
        return "redirect:/vehicle";
    }
}
