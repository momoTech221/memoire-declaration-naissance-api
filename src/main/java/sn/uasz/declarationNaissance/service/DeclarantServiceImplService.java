package sn.uasz.declarationNaissance.service;


import sn.uasz.declarationNaissance.mapper.DeclarantMapper;
import sn.uasz.declarationNaissance.modele.DeclarantDto;
import sn.uasz.declarationNaissance.service.impl.DeclarantService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.repositories.DeclarantRepository;
import sn.uasz.spi.declarationNaissanceApi.model.Declarant;

import java.util.List;

@Data
@Service
public class DeclarantServiceImplService implements DeclarantService {
    @Autowired
    DeclarantRepository declarantRepository;
    @Autowired
    DeclarantMapper declarantMapper;

    @Override
    public String save(Declarant declarant) {
        String  s = "";
        if(declarantRepository.findIdByNumeroPiece(declarant.getNumeroPiece())==null){
            DeclarantDto dto = declarantMapper.mapDeclarantToDeclarantDto(declarant);
            declarantRepository.save(dto);
            s="Insertion reussie !!!";
        }
        else{
            s="Informations deja existantes !!!";
        }
        return s;
    }

    @Override
    public List<Declarant> list() {
        List<DeclarantDto> declarantDtoList = declarantRepository.findAll();
        return declarantMapper.mapListDeclarantDtoToListDeclarant(declarantDtoList);
    }

    @Override
    public Declarant search(Long id) {
        DeclarantDto declarantDto = declarantRepository.findById(id).get();
        return declarantMapper.mapDeclarantDtoToDeclarant(declarantDto);
    }

    @Override
    public String update(Long id, Declarant declarant) {
        DeclarantDto existeDeclarantDto = declarantRepository.findById(id).get();
        DeclarantDto declarantDto = declarantMapper.mapDeclarantToDeclarantDto(declarant);

        if(existeDeclarantDto != null) {
            if(declarant.getNom() != null) existeDeclarantDto.setNom(declarantDto.getNom());
            if(declarant.getPrenom() != null) existeDeclarantDto.setPrenom(declarantDto.getPrenom());
            if(declarant.getTypePiece() != null) existeDeclarantDto.setTypePiece(declarantDto.getTypePiece());
            if(declarant.getNumeroPiece() != null) existeDeclarantDto.setNumeroPiece(declarantDto.getNumeroPiece());
            if(declarant.getProfession() != null) existeDeclarantDto.setProfession(declarantDto.getProfession());
            if(declarant.getAdresse() != null) existeDeclarantDto.setAdresse(declarantDto.getAdresse());
            if(declarant.getDateNaissance() != null) existeDeclarantDto.setDateNaissance(declarantDto.getDateNaissance());
            if(declarant.getLieuNaissance() != null) existeDeclarantDto.setLieuNaissance(declarantDto.getLieuNaissance());

            declarantRepository.save(existeDeclarantDto);
            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }

    @Override
    public String remove(Long id) {
        declarantRepository.deleteById(id);
        return "Supression reussie !!!";
    }
}




