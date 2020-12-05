package az.admin.fleetap.controller;

import az.admin.fleetap.model.Client;
import az.admin.fleetap.model.Contact;
import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.State;
import az.admin.fleetap.service.ClientService;
import az.admin.fleetap.service.ContactService;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

//    @GetMapping("/contacts")
//    public String getCountries() {
//        return "contacts";
//    }

    private final ContactService contactService;
    private final CountryService countryService;
    private final StateService stateService;

    public ContactController(ContactService contactService, CountryService countryService, StateService stateService) {
        this.contactService = contactService;
        this.countryService = countryService;
        this.stateService = stateService;
    }

    @GetMapping("/contacts")
    public String getStates(Model model) {
        List<Contact> contacts = contactService.getContacts();
        model.addAttribute("contacts", contacts);

        List<Country> countries = countryService.getCountries();
        model.addAttribute("countries", countries);

        List<State> states = stateService.getStates();
        model.addAttribute("states", states);

        return "contacts";
    }

    @PostMapping("/contacts/addNew")
    public String addNew(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(int id) {
        return contactService.findById(id);
    }


    @RequestMapping(value = "/contacts/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
