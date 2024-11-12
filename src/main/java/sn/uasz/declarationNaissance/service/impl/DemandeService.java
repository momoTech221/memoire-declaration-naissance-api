package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Declare;
import sn.uasz.spi.declarationNaissanceApi.model.Demande;

import java.util.List;

public interface DemandeService {
    public String save(Demande demande);
    public List<Demande> list();
    public Demande search(Long id);
    public String update(Long id, Demande demande);
    public String remove(Long id);
}
