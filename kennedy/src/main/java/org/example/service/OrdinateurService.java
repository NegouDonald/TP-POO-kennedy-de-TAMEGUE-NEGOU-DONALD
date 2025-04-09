package org.example.service;


import org.example.model.Ordinateur;
import java.util.List;

public interface OrdinateurService extends ObjetService<Ordinateur> {
    Ordinateur getOrdinateurById(int id);
}