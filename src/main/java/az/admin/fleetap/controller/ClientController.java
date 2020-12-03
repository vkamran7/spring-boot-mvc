package az.admin.fleetap.controller;

import az.admin.fleetap.model.Client;
import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.State;
import az.admin.fleetap.service.ClientService;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

//    @GetMapping("/clients")
//    public String getCountries() {
//        return "clients";
//    }

    private final ClientService clientService;
    private final CountryService countryService;
    private final StateService stateService;

    public ClientController(ClientService clientService, CountryService countryService, StateService stateService) {
        this.clientService = clientService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    @GetMapping("/clients")
    public String getStates(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);

        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);

        List<State> states = stateService.getStates();
        model.addAttribute("states", states);

        return "clients";
    }

    @PostMapping("/clients/addNew")
    public String addNew(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/findById")
    @ResponseBody
    public Optional<Client> findById(int id) {
        return clientService.findById(id);
    }


    @RequestMapping(value = "/clients/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        clientService.delete(id);
        return "redirect:/clients";
    }

}
