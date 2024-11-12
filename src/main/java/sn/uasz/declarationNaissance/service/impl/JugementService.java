package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Jugement;

import java.util.List;

public interface JugementService {
    public String save(Jugement jugement );
    public List<Jugement> list();
    public Jugement search(Long id);
    public String update(Long id, Jugement jugement );
    public String remove(Long id);
}
