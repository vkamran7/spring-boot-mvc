package az.admin.fleetap.service;

import az.admin.fleetap.model.VehicleStatus;
import az.admin.fleetap.repository.VehicleStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    private final VehicleStatusRepository vehicleStatusRepository;

    public VehicleStatusService(VehicleStatusRepository vehicleStatusRepository) {
        this.vehicleStatusRepository = vehicleStatusRepository;
    }

    public List<VehicleStatus> getLocations() {
        return vehicleStatusRepository.findAll();
    }

    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatus> findById(int id) {
        return vehicleStatusRepository.findById(id);
    }

    public void delete(int id) {
        vehicleStatusRepository.deleteById(id);
    }
}
