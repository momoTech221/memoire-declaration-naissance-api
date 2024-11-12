package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Temoin;

import java.util.List;

public interface TemoinService {
    public String save(Temoin temoin);
    public List<Temoin> list();
    public Temoin search(Long id);

    public String update(Long id, Temoin temoin);
    public String remove(Long id);
}
