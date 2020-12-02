package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.State;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.LocationService;
import az.admin.fleetap.service.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {
    private final LocationService locationService;
    private final CountryService countryService;
    private final StateService stateService;

    public LocationController(LocationService locationService, CountryService countryService, StateService stateService) {
        this.locationService = locationService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    @GetMapping("/locations")
    public String getStates(Model model) {
        List<Location> locations = locationService.getLocations();
        model.addAttribute("locations", locations);

        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);

        List<State> states = stateService.getStates();
        model.addAttribute("states", states);

        return "location";
    }

    @PostMapping("/locations/addNew")
    public String addNew(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @GetMapping("/locations/findById")
    @ResponseBody
    public Optional<Location> findById(int id) {
        return locationService.findById(id);
    }


    @RequestMapping(value = "/locations/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        locationService.delete(id);
        return "redirect:/locations";
    }
}
