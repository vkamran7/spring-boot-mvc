package az.admin.fleetap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeTypeController {

    @GetMapping("/employeeType")
    public String getCountries() {
        return "employeeType";
    }
}
