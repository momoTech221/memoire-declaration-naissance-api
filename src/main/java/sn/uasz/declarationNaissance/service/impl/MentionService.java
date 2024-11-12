package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.Mention;

import java.util.List;

public interface MentionService {
    public String save(Mention mention );
    public List<Mention> list();
    public Mention search(Long id);

    public String update(Long id, Mention mention );
    public String remove(Long id);
}
