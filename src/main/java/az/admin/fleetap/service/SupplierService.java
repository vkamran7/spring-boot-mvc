package az.admin.fleetap.service;

import az.admin.fleetap.model.Client;
import az.admin.fleetap.model.Supplier;
import az.admin.fleetap.repository.ClientRepository;
import az.admin.fleetap.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public Optional<Supplier> findById(int id) {
        return supplierRepository.findById(id);
    }

    public void delete(int id) {
        supplierRepository.deleteById(id);
    }
}
