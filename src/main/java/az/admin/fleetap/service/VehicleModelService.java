package az.admin.fleetap.service;

import az.admin.fleetap.model.VehicleModel;
import az.admin.fleetap.repository.VehicleModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

    private final VehicleModelRepository vehicleModelRepository;

    public VehicleModelService(VehicleModelRepository vehicleModelRepository) {
        this.vehicleModelRepository = vehicleModelRepository;
    }

    public List<VehicleModel> getVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public Optional<VehicleModel> findById(int id) {
        return vehicleModelRepository.findById(id);
    }

    public void delete(int id) {
        vehicleModelRepository.deleteById(id);
    }
}
