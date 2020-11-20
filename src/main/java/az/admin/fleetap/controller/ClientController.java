package az.admin.fleetap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping("/clients")
    public String getCountries() {
        return "clients";
    }

}
