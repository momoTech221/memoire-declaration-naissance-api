package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.FormationSanitaire;

import java.util.List;

public interface FormationSanitaireService {
    public String save(FormationSanitaire formationSanitaire);
    public List<FormationSanitaire> list();
    public FormationSanitaire search(Long id);
    public String update(Long id, FormationSanitaire formationSanitaire);
    public String remove(Long id);
    public Long getIdByLibele(String libele);
    public List<String> allFormationByLibele();
}
