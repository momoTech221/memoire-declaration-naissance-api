package sn.uasz.declarationNaissance.service;

import sn.uasz.declarationNaissance.mapper.RegistreMapper;
import sn.uasz.declarationNaissance.modele.RegistreDto;
import sn.uasz.declarationNaissance.service.impl.RegistreService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.repositories.RegistreRepository;
import sn.uasz.spi.declarationNaissanceApi.model.Registre;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class RegistreServiceImplService implements RegistreService {
    @Autowired
    RegistreRepository registreRepository;
    @Autowired
    RegistreMapper registreMapper;

    @Override
    public String save(Registre registre) {
        RegistreDto registreDto = registreMapper.mapRegistreToRegistreDto(registre);
        registreRepository.save(registreDto);
        return "Insertion reussie !!!";

//        String  s = "";
//        if(repository.findByAnnee(registre.getAnnee())==null){
//            RegistreDto dto = mapper.mapRegistreToRegistreDto(registre);
//            repository.save(dto);
//            s="Insertion reussie !!!";
//        }
//        else{
//            s="Année de registre !!!";
//        }
//        return s;
    }

    @Override
    public List<Registre> list() {
        List<RegistreDto> registreDtos = registreRepository.findAll();
        List<Registre> registres= registreMapper.mapListRegistreDtoToListRegistre(registreDtos);
        return registres;
    }

    @Override
    public Registre search(Long id) {
        RegistreDto registreDto = registreRepository.findById(id).get();
        return registreMapper.mapRegistreDtoToRegistre(registreDto);
    }

    @Override
    public String update(Long id, Registre registre) {
        RegistreDto registreDto= registreMapper.mapRegistreToRegistreDto(registre);
        RegistreDto existe = registreRepository.findById(id).get();

        if(existe != null) {
            if(registre.getActive() != null) existe.setActive(registreDto.getActive());
            if(registre.getAnnee() != null) existe.setAnnee(registreDto.getAnnee());
            if(registre.getNumero() != null) existe.setNumero(registreDto.getNumero());

            registreRepository.save(existe);

            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }

        @Override
        public String remove(Long id) {
            String resultat = null;
            registreRepository.deleteById(id);
            if(search(id) == null){
                resultat ="Supression effectuée avec succée";
            }
            else{
                resultat="Oups!!! la supression a échoué.";
            }
            return resultat;
        }
        @Override
        public Long getByAnnee(String annee) {
            return registreRepository.findByAnnee(annee);
        }

        @Override
        public List<String> allRegistreByAneee() {
            List<String> allYears = new ArrayList<>();
            List<RegistreDto> list =registreRepository.findAll();
            for(RegistreDto dto: list){
                allYears.add(dto.getAnnee());
            }
            return allYears;
        }
    }




