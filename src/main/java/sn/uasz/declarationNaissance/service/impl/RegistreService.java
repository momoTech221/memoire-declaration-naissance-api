package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Registre;

import java.util.List;

public interface RegistreService {
    public String save(Registre registre);
    public List<Registre> list();
    public Registre search(Long id);
    public String update(Long id, Registre registre);
    public String remove(Long id);
    public Long getByAnnee(String annee);
    public List<String> allRegistreByAneee();
}
