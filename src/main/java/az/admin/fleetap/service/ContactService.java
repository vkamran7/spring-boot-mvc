package az.admin.fleetap.service;

import az.admin.fleetap.model.Client;
import az.admin.fleetap.model.Contact;
import az.admin.fleetap.repository.ClientRepository;
import az.admin.fleetap.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public Optional<Contact> findById(int id) {
        return contactRepository.findById(id);
    }

    public void delete(int id) {
        contactRepository.deleteById(id);
    }
}
