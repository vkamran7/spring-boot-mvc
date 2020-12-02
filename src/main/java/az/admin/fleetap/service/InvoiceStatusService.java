package az.admin.fleetap.service;

import az.admin.fleetap.model.EmployeeType;
import az.admin.fleetap.model.InvoiceStatus;
import az.admin.fleetap.repository.EmployeeTypeRepository;
import az.admin.fleetap.repository.InvoiceStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {

    private final InvoiceStatusRepository invoiceStatusRepository;

    public InvoiceStatusService(InvoiceStatusRepository invoiceStatusRepository) {
        this.invoiceStatusRepository = invoiceStatusRepository;
    }

    public List<InvoiceStatus> getLocations() {
        return invoiceStatusRepository.findAll();
    }

    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public Optional<InvoiceStatus> findById(int id) {
        return invoiceStatusRepository.findById(id);
    }

    public void delete(int id) {
        invoiceStatusRepository.deleteById(id);
    }
}
