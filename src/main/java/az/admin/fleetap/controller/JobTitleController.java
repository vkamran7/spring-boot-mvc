package az.admin.fleetap.controller;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.model.JobTitle;
import az.admin.fleetap.model.Location;
import az.admin.fleetap.model.State;
import az.admin.fleetap.service.CountryService;
import az.admin.fleetap.service.JobTitleService;
import az.admin.fleetap.service.LocationService;
import az.admin.fleetap.service.StateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

//    @GetMapping("/jobTitles")
//    public String getCountries() {
//        return "jobTitle";
//    }
    private final JobTitleService jobTitleService;

    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/jobTitles")
    public String getStates(Model model) {
        List<JobTitle> jobTitles = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitles);

        return "jobTitle";
    }

    @PostMapping("/jobTitles/addNew")
    public String addNew(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @GetMapping("/locations/findById")
    @ResponseBody
    public Optional<JobTitle> findById(int id) {
        return jobTitleService.findById(id);
    }


    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id) {
        jobTitleService.delete(id);
        return "redirect:/jobTitles";
    }
}
