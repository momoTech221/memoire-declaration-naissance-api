package sn.uasz.declarationNaissance.service.impl;

import sn.uasz.spi.declarationNaissanceApi.model.DeclarationNaissance;
import sn.uasz.spi.declarationNaissanceApi.model.VerifDeclaration;

import java.util.List;

public interface DeclarationNaissanceService {
    public String save(DeclarationNaissance declarationNaissance);

    public List<DeclarationNaissance> list();

    public DeclarationNaissance search(Long id);

    public String update(Long id, DeclarationNaissance declarationNaissance);

    public String remove(Long id);
    DeclarationNaissance verifDeclaration(VerifDeclaration declaration);

//    DeclarationNaissance verifDeclaration(String numero);
}
