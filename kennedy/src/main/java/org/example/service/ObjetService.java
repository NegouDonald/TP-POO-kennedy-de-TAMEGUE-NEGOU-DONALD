package org.example.service;


import org.example.model.Objet;
import java.util.List;

public interface ObjetService<T extends Objet> {
    T getBySerialNumber(String serial);
    boolean declareVole(String serialNumber);
    boolean add(T objet);
    boolean update(T objet);
    boolean delete(int id);
    List<T> getAll();
}