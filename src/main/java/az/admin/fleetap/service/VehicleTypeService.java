package az.admin.fleetap.service;

import az.admin.fleetap.model.VehicleMake;
import az.admin.fleetap.model.VehicleType;
import az.admin.fleetap.repository.VehicleMakeRepository;
import az.admin.fleetap.repository.VehicleTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public void save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public Optional<VehicleType> findById(int id) {
        return vehicleTypeRepository.findById(id);
    }

    public void delete(int id) {
        vehicleTypeRepository.deleteById(id);
    }
}
