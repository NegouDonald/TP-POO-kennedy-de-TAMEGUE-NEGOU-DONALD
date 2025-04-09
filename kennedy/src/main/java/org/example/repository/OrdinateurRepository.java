package org.example.repository;



import org.example.model.Ordinateur;
import java.util.List;

public interface OrdinateurRepository {
    Ordinateur findById(int id);
    Ordinateur findByMacAddress(String macAddress);
    List<Ordinateur> findAll();
    boolean save(Ordinateur ordinateur);
    boolean update(Ordinateur ordinateur);
    boolean delete(int id);
}