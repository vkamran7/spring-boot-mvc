package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.State;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {
    private StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/states")
    public String getStates(Model model) {
        List<State> states = stateService.getStates();
        model.addAttribute("states", states);
        return "state";
    }

    @PostMapping("/states/addNew")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @GetMapping("/states/findById")
    @ResponseBody
    public Optional<State> findById(int id) {
        return stateService.findById(id);
    }


    @RequestMapping(value = "/states/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        stateService.delete(id);
        return "redirect:/states";
    }
}
