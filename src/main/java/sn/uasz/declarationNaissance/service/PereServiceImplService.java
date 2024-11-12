package sn.uasz.declarationNaissance.service;

import sn.uasz.declarationNaissance.mapper.PereMapper;
import sn.uasz.declarationNaissance.modele.PereDto;
import sn.uasz.declarationNaissance.service.impl.PereService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.repositories.PereRepository;
import sn.uasz.spi.declarationNaissanceApi.model.Pere;

import java.util.List;

@Data
@Service
public class PereServiceImplService implements PereService {
    @Autowired
    PereRepository pereRepository;

    @Autowired
    PereMapper pereMapper;

    @Override
    public String save(Pere pere) {
        String  s = "";
        if(pereRepository.findIdByNumeroPiece(pere.getNumeroPiece())==null){
            PereDto dto = pereMapper.mapPereToPereDto(pere);
            pereRepository.save(dto);
            s="Insertion reussie !!!";
        }
        else{
            s="Informations deja existantes !!!";
        }
        return s;
    }

    @Override
    public List<Pere> list() {
        List<PereDto> pereList = pereRepository.findAll();
        return pereMapper.mapListPereDtoToListPere(pereList);
    }

    @Override
    public Pere search(Long id) {
        PereDto pereDto = pereRepository.findById(id).get();
        return pereMapper.mapPereDtoToPere(pereDto);
    }

    @Override
    public String update(Long id, Pere pere) {
        PereDto pereDto = pereMapper.mapPereToPereDto(pere);
        PereDto dad = pereRepository.findById(id).get();
        if (dad != null) {
            if (pere.getNom() != null) dad.setNom(pereDto.getNom());
            if (pere.getPrenom() != null) dad.setPrenom(pereDto.getPrenom());
            if (pere.getProfession() != null) dad.setProfession(pereDto.getProfession());
            if (pere.getAdresse() != null) dad.setAdresse(pereDto.getAdresse());
            if (pere.getTypePiece() != null) dad.setTypePiece(pereDto.getTypePiece());
            if (pere.getNumeroPiece() != null) dad.setNumeroPiece(pereDto.getNumeroPiece());
            if (pere.getDateNaiss() != null) dad.setDateNaiss(pereDto.getDateNaiss());
            if (pere.getLieuNaiss() != null) dad.setLieuNaiss(pereDto.getLieuNaiss());

            pereRepository.save(dad);

            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }

    @Override
    public String remove(Long id) {
            pereRepository.deleteById(id);
            return "supression reussie !!!";
    }
}



