package az.admin.fleetap.controller;

import az.admin.fleetap.model.*;
import az.admin.fleetap.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

//    @GetMapping("/invoices")
//    public String getCountries() {
//        return "invoice";
//    }

    private final InvoiceService invoiceService;
    private final ClientService clientService;
    private final InvoiceStatusService invoiceStatusService;

    public InvoiceController(InvoiceService invoiceService, ClientService clientService, InvoiceStatusService invoiceStatusService) {
        this.invoiceService = invoiceService;
        this.clientService = clientService;
        this.invoiceStatusService = invoiceStatusService;
    }

    @GetMapping("/invoices")
    public String getStates(Model model) {
        List<Invoice> invoices = invoiceService.getInvoices();
        model.addAttribute("invoices", invoices);

        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);

        List<InvoiceStatus> invoiceStatuses = invoiceStatusService.getInvoiceStatues();
        model.addAttribute("invoiceStatuses", invoiceStatuses);
        return "invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id) {
        return invoiceService.findById(id);
    }


    @RequestMapping(value = "/invoices/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
