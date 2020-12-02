package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.InvoiceStatus;
import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.State;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.InvoiceStatusService;
import az.admin.fleetap.service.LocationService;
import az.admin.fleetap.service.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

//    @GetMapping("/invoiceStatus")
//    public String getCountries() {
//        return "invoiceStatus";
//    }

    private final InvoiceStatusService invoiceStatusService;


    public InvoiceStatusController(InvoiceStatusService invoiceStatusService) {
        this.invoiceStatusService = invoiceStatusService;
    }

    @GetMapping("/invoiceStatus")
    public String getStates(Model model) {
        List<InvoiceStatus> invoiceStatuses = invoiceStatusService.getInvoiceStatues();
        model.addAttribute("invoiceStatuses", invoiceStatuses);
        return "invoiceStatus";
    }

    @PostMapping("/invoiceStatus/addNew")
    public String addNew(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }

    @GetMapping("/invoiceStatus/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(int id) {
        return invoiceStatusService.findById(id);
    }


    @RequestMapping(value = "/invoiceStatus/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }

    @RequestMapping(value = "/invoiceStatus/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatus";
    }
}
