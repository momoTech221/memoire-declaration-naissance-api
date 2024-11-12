package sn.uasz.declarationNaissance.service;

import sn.uasz.declarationNaissance.mapper.JugementMapper;
import sn.uasz.declarationNaissance.modele.JugementDto;
import sn.uasz.declarationNaissance.service.impl.JugementService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.declarationNaissance.repositories.JugementRepository;
import sn.uasz.spi.declarationNaissanceApi.model.Jugement;

import java.util.List;
@Data
@Service
public class JugementServiceImplService implements JugementService {

    @Autowired
    JugementRepository jugementRepository;

    @Autowired
    JugementMapper jugementMapper;

    @Override
    public String save(Jugement jugement) {
        String  s = "";
        if(jugementRepository.findIdByNumero(jugement.getNumero())==null){
            JugementDto dto = jugementMapper.mapJugementToJugementDto(jugement);
            jugementRepository.save(dto);
            s="Insertion reussie !!!";
        }
        else{
            s="Informations deja existantes !!!";
        }
        return s;
    }

    @Override
    public List<Jugement> list() {
        List<JugementDto> jugementDtos = jugementRepository.findAll();
        return jugementMapper.mapListJugementDtoToListJugement(jugementDtos);
    }

    @Override
    public Jugement search(Long id) {
        JugementDto jugementDto = jugementRepository.findById(id).get();
        return jugementMapper.mapJugementDtoToJugement(jugementDto);
    }

    @Override
    public String update(Long id, Jugement jugement) {
        JugementDto jugementDto = jugementMapper.mapJugementToJugementDto(jugement);
        JugementDto existe = jugementRepository.findById(id).get();

        if(existe != null) {
            if(jugement.getDate() != null) existe.setDate(jugementDto.getDate());
            if((jugement.getLieu() != null)) existe.setLieu(jugementDto.getLieu());
            if(jugement.getNumero() != null) existe.setNumero(jugementDto.getNumero());

            jugementRepository.save(existe);
            return "Modification effectuée avec succée !!";
        }
        return "Identifiant correspondant introuvable !!";
    }

    @Override
    public String remove(Long id) {
        jugementRepository.deleteById(id);
        return "supression reussie !!!";
    }


}
