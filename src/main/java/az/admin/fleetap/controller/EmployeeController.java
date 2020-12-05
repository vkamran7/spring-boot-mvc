package az.admin.fleetap.controller;

import az.admin.fleetap.model.*;
import az.admin.fleetap.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

//    @GetMapping("/employees")
//    public String getCountries() {
//        return "employee";
//    }

    private final EmployeeService employeeService;
    private final JobTitleService jobTitleService;
    private final EmployeeTypeService employeeTypeService;
    private final CountryService countryService;
    private final StateService stateService;

    public EmployeeController(EmployeeService employeeService,
                             JobTitleService jobTitleService,
                             EmployeeTypeService employeeTypeService,
                             CountryService countryService,
                             StateService stateService
    ) {
        this.employeeService = employeeService;
        this.jobTitleService = jobTitleService;
        this.employeeTypeService = employeeTypeService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    @GetMapping("/employees")
    public String getStates(Model model) {
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);

        List<JobTitle> jobTitles = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitles);

        List<EmployeeType> employeeTypes = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypes);

        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);

        List<State> states = stateService.getStates();
        model.addAttribute("states", states);

        return "employee";
    }

    @PostMapping("/employees/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/findById")
    @ResponseBody
    public Optional<Employee> findById(int id) {
        return employeeService.findById(id);
    }


    @RequestMapping(value = "/employees/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
