package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Mere;

import java.util.List;

public interface MereService {
    public String save(Mere mere);
    public List<Mere> list();
    public Mere search(Long id);

    public String update(Long id, Mere mere );
    public String remove(Long id);
}
