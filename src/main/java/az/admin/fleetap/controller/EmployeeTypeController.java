package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.EmployeeType;
import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.State;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.EmployeeTypeService;
import az.admin.fleetap.service.LocationService;
import az.admin.fleetap.service.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

//    @GetMapping("/employeeTypes")
//    public String getCountries() {
//        return "employeeType";
//    }

    private final EmployeeTypeService employeeTypeService;

    public EmployeeTypeController(EmployeeTypeService employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    @GetMapping("/employeeTypes")
    public String getStates(Model model) {
        List<EmployeeType> employeeTypes = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypes);

        return "employeeType";
    }

    @PostMapping("/employeeTypes/addNew")
    public String addNew(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @GetMapping("/employeeTypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(int id) {
        return employeeTypeService.findById(id);
    }


    @RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(EmployeeType location) {
        employeeTypeService.save(location);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/employeeTypes/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }
}
