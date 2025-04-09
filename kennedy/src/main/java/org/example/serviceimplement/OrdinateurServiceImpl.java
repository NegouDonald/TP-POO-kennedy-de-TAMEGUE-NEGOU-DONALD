package org.example.serviceimplement;



import org.example.model.Ordinateur;
import org.example.repository.OrdinateurRepository;
import org.example.service.OrdinateurService;

import java.util.List;

public class OrdinateurServiceImpl implements OrdinateurService {

    private final OrdinateurRepository repository;

    public OrdinateurServiceImpl(OrdinateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ordinateur getOrdinateurById(int id) {
        return repository.findById(id);
    }

    @Override
    public Ordinateur getBySerialNumber(String serial) {
        return repository.findByMacAddress(serial);
    }

    @Override
    public boolean declareVole(String serialNumber) {
        Ordinateur ord = repository.findByMacAddress(serialNumber);
        if (ord != null) {
            ord.setVole(true);
            return repository.update(ord);
        }
        return false;
    }

    @Override
    public boolean add(Ordinateur ordinateur) {
        return repository.save(ordinateur);
    }

    @Override
    public boolean update(Ordinateur ordinateur) {
        return repository.update(ordinateur);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public List<Ordinateur> getAll() {
        return repository.findAll();
    }
}