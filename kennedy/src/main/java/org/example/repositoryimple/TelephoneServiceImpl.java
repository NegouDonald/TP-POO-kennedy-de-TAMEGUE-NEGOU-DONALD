package org.example.repositoryimple;


import org.example.model.Telephone;
import org.example.repository.TelephoneRepository;
import org.example.service.TelephoneService;

import java.util.List;

public class TelephoneServiceImpl implements TelephoneService {

    private final TelephoneRepository repository;

    public TelephoneServiceImpl(TelephoneRepository repository) {
        this.repository = repository;
    }

    public Telephone getTelephoneById(int id) {
        return repository.findById(id);
    }

    public Telephone getTelephoneByImei(String imei) {
        return repository.findByImei(imei);
    }

    public boolean addTelephone(Telephone telephone) {
        return repository.save(telephone);
    }

    public boolean updateTelephone(Telephone telephone) {
        return repository.update(telephone);
    }

    public boolean deleteTelephone(int id) {
        return repository.delete(id);
    }

    public boolean estVole(String imei) {
        Telephone tel = repository.findByImei(imei);
        return tel != null && tel.isVole();
    }

    public List<Telephone> getAllTelephones() {
        return repository.findAll();
    }
}
