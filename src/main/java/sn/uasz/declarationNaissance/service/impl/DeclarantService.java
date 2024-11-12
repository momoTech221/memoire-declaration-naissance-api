package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Declarant;

import java.util.List;

public interface DeclarantService {
    public String save(Declarant declarant);
    public List<Declarant> list();
    public Declarant search(Long id);
    public String update(Long id, Declarant declarant);
    public String remove(Long id);
}
