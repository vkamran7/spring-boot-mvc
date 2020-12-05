package az.admin.fleetap.service;

import az.admin.fleetap.model.VehicleMovement;
import az.admin.fleetap.repository.VehicleMovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {

    private final VehicleMovementRepository vehicleMovementRepository;

    public VehicleMovementService(VehicleMovementRepository vehicleMovementRepository) {
        this.vehicleMovementRepository = vehicleMovementRepository;
    }

    public List<VehicleMovement> getVehicleMovements() {
        return vehicleMovementRepository.findAll();
    }

    public void save(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }

    public Optional<VehicleMovement> findById(int id) {
        return vehicleMovementRepository.findById(id);
    }

    public void delete(int id) {
        vehicleMovementRepository.deleteById(id);
    }
}
