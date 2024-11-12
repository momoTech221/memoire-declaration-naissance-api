package sn.uasz.declarationNaissance.service;

import sn.uasz.declarationNaissance.mapper.FormationSanitaireMapper;
import sn.uasz.declarationNaissance.modele.FormationSanitaireDto;
import sn.uasz.declarationNaissance.service.impl.FormationSanitaireService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.repositories.FormationSanitaireRepository;
import sn.uasz.spi.declarationNaissanceApi.model.FormationSanitaire;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class FormationSanitaireImplService implements FormationSanitaireService {

    @Autowired
    FormationSanitaireRepository formationSanitaireRepository;

    @Autowired
    FormationSanitaireMapper formationSanitaireMapper;

    @Override
    public String save(FormationSanitaire formationSanitaire) {
        FormationSanitaireDto formationSanitaireDto = formationSanitaireMapper.mapFormationSanitaireToFormationSanitaireDto(formationSanitaire);
        formationSanitaireRepository.save(formationSanitaireDto);
        return "Insertion reussie !!!";
    }

    @Override
    public List<FormationSanitaire> list() {
        List<FormationSanitaireDto> formationSanitaireDtos = formationSanitaireRepository.findAll();
        return formationSanitaireMapper.mapListFormationSanitaireDtoToListFormationSanitaire(formationSanitaireDtos);
    }

    @Override
    public FormationSanitaire search(Long id) {
        FormationSanitaireDto formationSanitaireDto = formationSanitaireRepository.findById(id).get();
        return formationSanitaireMapper.mapFormationSanitaireDtoToFormationSanitaire(formationSanitaireDto);
    }

    @Override
    public String update(Long id, FormationSanitaire formationSanitaire) {
        FormationSanitaireDto formationSanitaireDto = formationSanitaireMapper.mapFormationSanitaireToFormationSanitaireDto(formationSanitaire);
        FormationSanitaireDto existe = formationSanitaireRepository.findById(id).get();
        if(existe != null) {
            if(formationSanitaire.getCode() != null) existe.setCode(formationSanitaireDto.getCode());
            if(formationSanitaire.getLibele() != null) existe.setLibele(formationSanitaireDto.getLibele());
            if(formationSanitaire.getType() != null) existe.setType(formationSanitaireDto.getType());
            if(formationSanitaire.getLocalisation() != null) existe.setLocalisation(formationSanitaireDto.getLocalisation());
            formationSanitaireRepository.save(existe);
            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }

    @Override
    public String remove(Long id) {
        formationSanitaireRepository.deleteById(id);
        return "supression reussie !!!";
    }

    @Override
    public Long getIdByLibele(String libele) {
        return formationSanitaireRepository.findByLibele(libele);
    }

    @Override
    public List<String> allFormationByLibele() {
        List<String> allFormations = new ArrayList<>();
        List<FormationSanitaireDto> list = formationSanitaireRepository.findAll();
        for(FormationSanitaireDto dto: list){
            allFormations.add(dto.getLibele());
        }
        return allFormations;
    }
}
