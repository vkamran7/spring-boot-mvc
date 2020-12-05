package az.admin.fleetap.service;

import az.admin.fleetap.model.Invoice;
import az.admin.fleetap.model.State;
import az.admin.fleetap.repository.InvoiceRepository;
import az.admin.fleetap.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public Optional<Invoice> findById(int id) {
        return invoiceRepository.findById(id);
    }

    public void delete(int id) {
        invoiceRepository.deleteById(id);
    }
}
