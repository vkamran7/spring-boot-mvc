package az.admin.fleetap.service;

import az.admin.fleetap.model.EmployeeType;
import az.admin.fleetap.repository.EmployeeTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    private final EmployeeTypeRepository employeeTypeRepository;

    public EmployeeTypeService(EmployeeTypeRepository employeeTypeRepository) {
        this.employeeTypeRepository = employeeTypeRepository;
    }

    public List<EmployeeType> getLocations() {
        return employeeTypeRepository.findAll();
    }

    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public Optional<EmployeeType> findById(int id) {
        return employeeTypeRepository.findById(id);
    }

    public void delete(int id) {
        employeeTypeRepository.deleteById(id);
    }
}
