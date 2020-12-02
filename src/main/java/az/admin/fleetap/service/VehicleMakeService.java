package az.admin.fleetap.service;

import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.VehicleMake;
import az.admin.fleetap.repository.LocationRepository;
import az.admin.fleetap.repository.VehicleMakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    private final VehicleMakeRepository vehicleMakeRepository;

    public VehicleMakeService(VehicleMakeRepository vehicleMakeRepository) {
        this.vehicleMakeRepository = vehicleMakeRepository;
    }

    public List<VehicleMake> getVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    public void save(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    public Optional<VehicleMake> findById(int id) {
        return vehicleMakeRepository.findById(id);
    }

    public void delete(int id) {
        vehicleMakeRepository.deleteById(id);
    }
}
