package sn.uasz.declarationNaissance.service;

import sn.uasz.declarationNaissance.mapper.TemoinMapper;
import sn.uasz.declarationNaissance.modele.TemoinDto;
import sn.uasz.declarationNaissance.service.impl.TemoinService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.repositories.TemoinRepository;
import sn.uasz.spi.declarationNaissanceApi.model.Temoin;

import java.util.List;

@Data
@Service
public class TemoinServiceImplService implements TemoinService {
    @Autowired
    TemoinRepository temoinRepository;

    @Autowired
    TemoinMapper temoinMapper;

    @Override
    public String save(Temoin temoin) {
        String  s = "";
        if(temoinRepository.findIdByNumeroPiece(temoin.getNumeroPiece())==null){
            TemoinDto dto = temoinMapper.mapTemoinToTemoinDto(temoin);
            temoinRepository.save(dto);
            s="Insertion reussie !!!";
        }
        else{
            s="Informations deja existantes !!!";
        }
        return s;
    }

    @Override
    public List<Temoin> list() {
        List<TemoinDto> temoinDtos = temoinRepository.findAll();
        return temoinMapper.mapListTemoinDtoToListTemoin(temoinDtos);
    }

    @Override
    public Temoin search(Long id) {
        TemoinDto temoinDto = temoinRepository.findById(id).get();
        return temoinMapper.mapTemoinDtoToTemoin(temoinDto);
    }

    @Override
    public String update(Long id, Temoin temoin) {
        TemoinDto temoinDto = temoinMapper.mapTemoinToTemoinDto(temoin);
        TemoinDto existe = temoinRepository.findById(id).get();
        if(existe != null) {
            if(temoin.getNom() != null) existe.setNom(temoinDto.getNom());
            if(temoin.getPrenom() != null) existe.setPrenom(temoinDto.getPrenom());
            if(temoin.getProfession() != null) existe.setProfession(temoinDto.getProfession());
            if(temoin.getDomicile() != null) existe.setDomicile(temoinDto.getDomicile());;
            if(temoin.getTypePiece() != null) existe.setTypePiece(temoinDto.getTypePiece());
            if(temoin.getNumeroPiece() != null) existe.setNumeroPiece(temoinDto.getNumeroPiece());
            if(temoin.getDateNaissance() != null) existe.setDateNaissance(temoinDto.getDateNaissance());
            if(temoin.getLieuNaissance() != null) existe.setLieuNaissance(temoinDto.getLieuNaissance());

            temoinRepository.save(existe);
            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }

    @Override
    public String remove(Long id) {
//        Temoin existe= search(id);
//        String resultat= null;
//        if(existe != null){
            temoinRepository.deleteById(id);
            return "supression reussie !!!";
//            if(search(id) == null){
//                resultat ="Supression effectuée avec succée";
//            }
//            else{
//                resultat="Oups!!! la supression a échoué.";
//            }
//        }
//        else {
//            resultat = "Cette information est inexistante !!";
//        }
//        return resultat;
    }
}
