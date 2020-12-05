package az.admin.fleetap.controller;

import az.admin.fleetap.model.*;
import az.admin.fleetap.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMaintenanceController {

    private final VehicleMaintenanceService vehicleMaintenanceService;
    private final VehicleService vehicleService;
    private final SupplierService supplierService;

    public VehicleMaintenanceController(VehicleMaintenanceService vehicleMaintenanceService, VehicleService vehicleService, SupplierService supplierService) {
        this.vehicleMaintenanceService = vehicleMaintenanceService;
        this.vehicleService = vehicleService;
        this.supplierService = supplierService;
    }

    @GetMapping("/vehicleMaintenance")
    public String getStates(Model model) {
        List<VehicleMaintenance> vehicleMaintenances = vehicleMaintenanceService.getVehicleMaintenances();
        model.addAttribute("vehicleMaintenances", vehicleMaintenances);

        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);

        List<Supplier> suppliers = supplierService.getSuppliers();
        model.addAttribute("suppliers", suppliers);

        return "vehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenance/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @GetMapping("/vehicleMaintenance/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(int id) {
        return vehicleMaintenanceService.findById(id);
    }


    @RequestMapping(value = "/vehicleMaintenance/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @RequestMapping(value = "/vehicleMaintenance/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenance";
    }
}
