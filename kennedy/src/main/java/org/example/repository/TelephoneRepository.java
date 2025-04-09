package org.example.repository;



import org.example.model.Telephone;
import java.util.List;

public interface TelephoneRepository {
    Telephone findById(int id);
    Telephone findByImei(String imei);
    List<Telephone> findAll();
    boolean save(Telephone telephone);
    boolean update(Telephone telephone);
    boolean delete(int id);
}