package az.admin.fleetap.service;

import az.admin.fleetap.model.VehicleHire;
import az.admin.fleetap.repository.VehicleHireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    private final VehicleHireRepository vehicleHireRepository;

    public VehicleHireService(VehicleHireRepository vehicleHireRepository) {
        this.vehicleHireRepository = vehicleHireRepository;
    }

    public List<VehicleHire> getVehicleHires() {
        return vehicleHireRepository.findAll();
    }

    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }

    public Optional<VehicleHire> findById(int id) {
        return vehicleHireRepository.findById(id);
    }

    public void delete(int id) {
        vehicleHireRepository.deleteById(id);
    }
}
