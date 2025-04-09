package org.example.service;



import org.example.model.Telephone;

public interface TelephoneService extends ObjetService<Telephone> {
    Telephone getTelephoneById(int id);
}