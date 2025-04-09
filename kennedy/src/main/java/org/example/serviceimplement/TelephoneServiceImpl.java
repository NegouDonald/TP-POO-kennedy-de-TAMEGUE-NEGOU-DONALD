package org.example.serviceimplement;
import org.example.model.Telephone;
import org.example.repository.TelephoneRepository;
import org.example.service.TelephoneService;

import java.util.List;

public class TelephoneServiceImpl implements TelephoneService {

    private final TelephoneRepository repository;

    public TelephoneServiceImpl(TelephoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public Telephone getBySerialNumber(String serial) {
        return repository.findByImei(serial);
    }

    @Override
    public boolean declareVole(String serialNumber) {
        Telephone tel = repository.findByImei(serialNumber);
        if (tel != null) {
            tel.setVole(true);
            return repository.update(tel);
        }
        return false;
    }

    @Override
    public boolean add(Telephone telephone) {
        return repository.save(telephone);
    }

    @Override
    public boolean update(Telephone telephone) {
        return repository.update(telephone);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public List<Telephone> getAll() {
        return repository.findAll();
    }

    @Override
    public Telephone getTelephoneById(int id) {
        return repository.findById(id);
    }
}