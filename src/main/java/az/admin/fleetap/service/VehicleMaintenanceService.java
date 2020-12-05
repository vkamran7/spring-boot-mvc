package az.admin.fleetap.service;

import az.admin.fleetap.model.VehicleMaintenance;
import az.admin.fleetap.repository.VehicleMaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {

    private final VehicleMaintenanceRepository vehicleMaintenanceRepository;

    public VehicleMaintenanceService(VehicleMaintenanceRepository vehicleMaintenanceRepository) {
        this.vehicleMaintenanceRepository = vehicleMaintenanceRepository;
    }

    public List<VehicleMaintenance> getVehicleMaintenances() {
        return vehicleMaintenanceRepository.findAll();
    }

    public void save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public Optional<VehicleMaintenance> findById(int id) {
        return vehicleMaintenanceRepository.findById(id);
    }

    public void delete(int id) {
        vehicleMaintenanceRepository.deleteById(id);
    }
}
