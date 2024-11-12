package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Centre;


import java.util.List;

public interface CentreService {
    public String save(Centre centre);
    public List<Centre> list();
    public Centre search(Long id);
    public String update(Long id, Centre centre);
    public String remove(Long id);
    public Long getByLibele(String libele);
    public List<String> allCentreByLibele();
}
