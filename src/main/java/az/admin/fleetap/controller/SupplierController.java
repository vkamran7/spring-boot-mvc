package az.admin.fleetap.controller;

import az.admin.fleetap.model.Client;
import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.State;
import az.admin.fleetap.model.Supplier;
import az.admin.fleetap.service.ClientService;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.StateService;
import az.admin.fleetap.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {
//    @GetMapping("/suppliers")
//    public String getCountries() {
//        return "supplier";
//    }


    private final SupplierService supplierService;
    private final CountryService countryService;
    private final StateService stateService;

    public SupplierController(SupplierService supplierService, CountryService countryService, StateService stateService) {
        this.supplierService = supplierService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    @GetMapping("/suppliers")
    public String getStates(Model model) {
        List<Supplier> suppliers = supplierService.getSuppliers();
        model.addAttribute("suppliers", suppliers);

        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);

        List<State> states = stateService.getStates();
        model.addAttribute("states", states);

        return "supplier";
    }

    @PostMapping("/suppliers/addNew")
    public String addNew(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(int id) {
        return supplierService.findById(id);
    }


    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
