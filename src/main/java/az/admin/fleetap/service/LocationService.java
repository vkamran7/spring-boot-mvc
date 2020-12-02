package az.admin.fleetap.service;

import az.admin.fleetap.model.Location;
import az.admin.fleetap.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public void save(Location location) {
        locationRepository.save(location);
    }

    public Optional<Location> findById(int id) {
        return locationRepository.findById(id);
    }

    public void delete(int id) {
        locationRepository.deleteById(id);
    }
}
