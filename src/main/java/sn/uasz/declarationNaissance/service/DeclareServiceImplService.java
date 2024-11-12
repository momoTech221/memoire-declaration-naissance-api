package sn.uasz.declarationNaissance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.mapper.DeclareMapper;
import sn.uasz.declarationNaissance.modele.DeclareDto;
import sn.uasz.declarationNaissance.repositories.DeclareRepository;
import sn.uasz.declarationNaissance.service.impl.DeclareService;
import sn.uasz.spi.declarationNaissanceApi.model.Declare;

import java.util.List;

@Service
public class DeclareServiceImplService implements DeclareService {
    @Autowired
    DeclareRepository declareRepository;

    @Autowired
    DeclareMapper declareMapper;

    @Override
    public String save(Declare declare) {
        DeclareDto declareDto = declareMapper.mapDeclareToDeclareDto(declare);
        declareRepository.save(declareDto);
        return "Insertion reussie !!!";
    }

    @Override
    public List<Declare> list() {
        List<DeclareDto> declareDtos = declareRepository.findAll();
        return declareMapper.mapListDeclareDtoToListDeclare(declareDtos);
    }

    @Override
    public Declare search(Long id) {
        DeclareDto declareDto = declareRepository.findById(id).get();
        return declareMapper.mapDeclareDtoToDeclare(declareDto);
    }

    @Override
    public String update(Long id, Declare declare) {
        DeclareDto declareDto = declareMapper.mapDeclareToDeclareDto(declare);
        DeclareDto baby = declareRepository.findById(id).get();
        if(baby != null) {
            if(declare.getNom() != null) baby.setNom(declareDto.getNom());
            if(declare.getPrenom() != null) baby.setPrenom(declareDto.getPrenom());
            if(declare.getSexe() != null) baby.setSexe(declareDto.getSexe());
            if(declare.getDateNaissance() != null) baby.setDateNaissance(declareDto.getDateNaissance());
            if(declare.getLieuNaissance() != null) baby.setLieuNaissance(declareDto.getLieuNaissance());

            declareRepository.save(baby);
            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }
    @Override
    public String remove(Long id) {
        declareRepository.deleteById(id);
        return "supression reussie !!!";
    }

    public Long getIdLastInsertion(){
        List<DeclareDto> list = declareRepository.findAll();
        DeclareDto declareDto = null;
        for(DeclareDto dto: list){
            declareDto = dto;
        }
        return declareDto.idDeclare;
    }

}
