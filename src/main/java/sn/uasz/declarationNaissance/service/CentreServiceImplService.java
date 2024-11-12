package sn.uasz.declarationNaissance.service;

import sn.uasz.declarationNaissance.modele.CentreDto;
import sn.uasz.declarationNaissance.service.impl.CentreService;
import lombok.Data;
import sn.uasz.declarationNaissance.mapper.CentreMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.repositories.CentreRepository;
import sn.uasz.spi.declarationNaissanceApi.model.Centre;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class CentreServiceImplService implements CentreService {
    @Autowired
    CentreRepository centreRepository;

    @Autowired
    CentreMapper centreMapper;

   @Override
    public String save( Centre centre) {
        CentreDto centreDto = centreMapper.mapperCentreToCentreDto(centre);
        centreRepository.save(centreDto);
        return "Insertion reussie !!!";
    }


    @Override
    public List<Centre> list() {
        List<CentreDto> centreDtoList = centreRepository.findAll();
        return centreMapper.mapListCentreDtoToListCentre(centreDtoList);
    }

    @Override
    public Centre search(Long id) {
        CentreDto centreDto = centreRepository.findById(id).get();
        return centreMapper.mapperCentreDtoToCentre(centreDto);
    }

    @Override
    public String update(Long id, Centre centre) {
        CentreDto existe = centreRepository.findById(id).get();
        CentreDto centreConverti = centreMapper.mapperCentreToCentreDto(centre);
        if(existe != null) {
            if(centre.getCode() != null) existe.setCode(centreConverti.getCode());
            if(centre.getCollectiviteLocale() != null) existe.setCollectiviteLocale(centreConverti.getCollectiviteLocale());
            if(centre.getDepartement() != null) existe.setDepartement(centreConverti.getDepartement());
            if(centre.getLibele() != null) existe.setLibele(centreConverti.getLibele());
            if(centre.getRegion() != null) existe.setRegion(centreConverti.getRegion());

            centreRepository.save(existe);
            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }

    @Override
    public String remove(Long id) {
//        String resultat = null;
        centreRepository.deleteById(id);
        return "supression reussie !!!";
//        if(search(id) == null){
//            resultat ="Supression effectuée avec succée";
//        }
//        else{
//            resultat="Oups!!! la supression a échoué.";
//        }
//        return resultat;
   }

    @Override
    public Long getByLibele(String libele) {
        return centreRepository.findByLibele(libele);
    }

    @Override
    public List<String> allCentreByLibele() {
        List<String> allCenters = new ArrayList<>();
        List<CentreDto> list=centreRepository.findAll();
        for(CentreDto dto : list){
            allCenters.add(dto.getLibele());
        }
        return allCenters;
    }
}
