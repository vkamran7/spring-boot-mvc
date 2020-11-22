package az.admin.fleetap.service;

import az.admin.fleetap.model.Country;
import az.admin.fleetap.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public Optional<Country> findById(Integer id) {
        return countryRepository.findById(id);
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
