package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String getCountries(Model model) {
        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);
        return "country";
    }

    @PostMapping("/countries/addNew")
    public String addNew(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/countries/findById")
    @ResponseBody
    public Optional<Country> findById(int id) {
        return countryService.findById(id);
    }


    @RequestMapping(value = "/countries/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        countryService.delete(id);
        return "redirect:/countries";
    }
}
