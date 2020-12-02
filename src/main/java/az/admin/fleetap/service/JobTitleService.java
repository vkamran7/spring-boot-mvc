package az.admin.fleetap.service;

import az.admin.fleetap.model.JobTitle;
import az.admin.fleetap.repository.JobTitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    private final JobTitleRepository jobTitleRepository;

    public JobTitleService(JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }

    public List<JobTitle> getLocations() {
        return jobTitleRepository.findAll();
    }

    public void save(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    public Optional<JobTitle> findById(int id) {
        return jobTitleRepository.findById(id);
    }

    public void delete(int id) {
        jobTitleRepository.deleteById(id);
    }
}
