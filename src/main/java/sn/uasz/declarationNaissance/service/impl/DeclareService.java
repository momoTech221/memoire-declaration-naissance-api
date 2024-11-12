package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Declare;

import java.util.List;

public interface DeclareService {
    public String save(Declare declare);
    public List<Declare> list();
    public Declare search(Long id);
    public String update(Long id, Declare declare);
    public String remove(Long id);
}
