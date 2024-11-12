package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Pere;

import java.util.List;

public interface PereService {
    public String save(Pere pere);
    public List<Pere> list();
    public Pere search(Long id);
    public String update(Long id, Pere pere );
    public String remove(Long id);
}
