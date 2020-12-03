package az.admin.fleetap.service;

import az.admin.fleetap.model.Client;
import az.admin.fleetap.model.State;
import az.admin.fleetap.repository.ClientRepository;
import az.admin.fleetap.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    public void delete(int id) {
        clientRepository.deleteById(id);
    }
}
